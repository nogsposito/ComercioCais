package br.com.nogsposito.portfolio.comerciocais.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.nogsposito.portfolio.comerciocais.controller.dto.product.ProductRequestDTO;
import br.com.nogsposito.portfolio.comerciocais.domain.product.Product;
import br.com.nogsposito.portfolio.comerciocais.repository.ProductRepository;
import br.com.nogsposito.portfolio.comerciocais.service.ProductService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequestDTO data, UriComponentsBuilder uriBuilder){
        var newProduct = service.createProduct(data);
        var uri = uriBuilder.path("/products/{id}").buildAndExpand(newProduct.getId()).toUri();
        return ResponseEntity.created(uri).body(newProduct);
    }
}
