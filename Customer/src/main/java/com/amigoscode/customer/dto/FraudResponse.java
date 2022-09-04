package com.amigoscode.customer.dto;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
public class FraudResponse implements Serializable {

    private Boolean isFraudster;

}
