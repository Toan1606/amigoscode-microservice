package com.amigoscode.fraud.dto;

import lombok.Builder;

import java.io.Serializable;

@Builder
public class FraudResponse implements Serializable {

    private Boolean isFraudster;

}
