package br.com.nogsposito.portfolio.comerciocais.domain.order;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    WAITING_FOR_PAYMENT("Waiting for Payment"),
    PAID("Paid"),
    SHIPPED("Shipped"),
    DELIVERED("Delivered");

    private String name;
}
