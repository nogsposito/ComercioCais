package br.com.nogsposito.portfolio.comerciocais.controller.dto.product;

import java.math.BigDecimal;

import br.com.nogsposito.portfolio.comerciocais.domain.product.Product;

public record ProductResponseDTO(Long id, String name, String description, BigDecimal price, CategoryDTO category){
    public ProductResponseDTO(Product product){
        this(product.getId(), product.getName(), product.getDescription(), product.getPrice(), new CategoryDTO(product.getCategory()));
    }
}