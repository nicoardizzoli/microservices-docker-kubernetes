package com.nicoardizzoli.customer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRegistrationRequest {
    private String firstName;
    private String lastName;
    private String email;
}
