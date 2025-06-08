package br.com.nogsposito.portfolio.comerciocais.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nogsposito.portfolio.comerciocais.controller.dto.product.ProductRequestDTO;
import br.com.nogsposito.portfolio.comerciocais.domain.product.Product;
import br.com.nogsposito.portfolio.comerciocais.repository.CategoryRepository;
import br.com.nogsposito.portfolio.comerciocais.repository.ProductRepository;
import jakarta.transaction.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public Product createProduct(ProductRequestDTO data){
        var category = categoryRepository.findById(data.categoryId()).orElseThrow(() -> new RuntimeException("Categoria não encontrada!"));
        var newProduct = new Product(null, data.name(), data.description(), data.price(), data.sku(), data.imageUrl(), data.stockQuantity(), category);
        return productRepository.save(newProduct);
    }
}
