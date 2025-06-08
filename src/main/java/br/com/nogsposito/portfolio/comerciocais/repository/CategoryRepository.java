package br.com.nogsposito.portfolio.comerciocais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nogsposito.portfolio.comerciocais.domain.product.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
