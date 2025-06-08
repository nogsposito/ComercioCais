package br.com.nogsposito.portfolio.comerciocais.controller.dto.product;

import br.com.nogsposito.portfolio.comerciocais.domain.product.Category;

public record CategoryDTO(Long id, String name){
    public CategoryDTO(Category category){
        this(category.getId(), category.getName());
    }
}