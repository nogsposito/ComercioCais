package br.com.nogsposito.portfolio.comerciocais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nogsposito.portfolio.comerciocais.domain.product.Product;

// produto: classe do objeto e long seu id no BD
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
