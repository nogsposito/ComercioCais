package br.com.nogsposito.portfolio.comerciocais.controller.dto.product;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductRequestDTO (
    
    @NotBlank
    String name,

    String description,

    @NotNull
    @Positive
    BigDecimal price,

    @NotBlank
    String sku,

    String imageUrl,

    @NotNull
    Integer stockQuantity,

    @NotNull
    Long categoryId

) {}
