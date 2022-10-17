package com.amigoscode.customer;

import com.amigoscode.amqp.RabbitMQMessageProducer;
import com.amigoscode.clients.fraud.FraudCheckResponse;
import com.amigoscode.clients.fraud.FraudClient;
import com.amigoscode.clients.notification.NotificationClient;
import com.amigoscode.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRespository customerRespository;
    //private final NotificationClient notificationClient;
    private final FraudClient fraudClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;


    public void registerCustomer(CustomerRegistrationRequest registrationRequest){
        Customer customer = Customer.builder()
                .firstName(registrationRequest.firstName())
                .lastName(registrationRequest.lastName())
                .email(registrationRequest.email())
                .build();

        //todo: check if email valid
        //todo: check if email not taken
        customerRespository.saveAndFlush(customer);
        //todo: check if fraudster

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());
        if(fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("Fraudster");
        }

        //send notification
        //async. i.e. add to queue
        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, welcome to my project with help of Amigoscode....",
                        customer.getFirstName())
        );

        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );
    }

}
