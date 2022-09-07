package com.amigoscode.clients.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRequest implements Serializable {

    private Integer toCustomerId;

    private String toCustomerEmail;

    private String message;
}
