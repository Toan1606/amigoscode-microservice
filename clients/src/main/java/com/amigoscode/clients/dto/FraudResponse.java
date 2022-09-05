package com.amigoscode.clients.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Builder
public class FraudResponse implements Serializable {

    private boolean isFraudster;

}
