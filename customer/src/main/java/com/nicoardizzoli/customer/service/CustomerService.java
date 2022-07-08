package com.nicoardizzoli.customer.service;

import com.nicoardizzoli.amqp.RabbitMQMessageProducer;
import com.nicoardizzoli.clients.fraud.FraudCheckResponse;
import com.nicoardizzoli.clients.fraud.FraudClient;
import com.nicoardizzoli.clients.notification.NotificationClient;
import com.nicoardizzoli.clients.notification.NotificationRequest;
import com.nicoardizzoli.customer.model.Customer;
import com.nicoardizzoli.customer.model.CustomerRegistrationRequest;
import com.nicoardizzoli.customer.reposistory.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;


    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {

        Customer customer = Customer.builder()
                .firstName(customerRegistrationRequest.getFirstName())
                .lastName(customerRegistrationRequest.getLastName())
                .email(customerRegistrationRequest.getEmail())
                .build();

        customerRepository.save(customer);

        FraudCheckResponse fraudResponse = fraudClient.isFraudster(customer.getId());

        if (fraudResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }

        NotificationRequest notificationRequest = new NotificationRequest(customer.getId(), customer.getEmail(), "CUSTOMER REGISTRATION SUCCESSFULLY");
        rabbitMQMessageProducer.publish(notificationRequest, "internal.exchange", "internal.notification.routing-key");
    }
}
