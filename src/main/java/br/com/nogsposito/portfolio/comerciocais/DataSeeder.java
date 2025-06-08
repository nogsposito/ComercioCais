package br.com.nogsposito.portfolio.comerciocais;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.nogsposito.portfolio.comerciocais.domain.product.Category;
import br.com.nogsposito.portfolio.comerciocais.domain.product.Product;
import br.com.nogsposito.portfolio.comerciocais.repository.CategoryRepository;
import br.com.nogsposito.portfolio.comerciocais.repository.ProductRepository;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        // Esta verificação impede que os dados sejam inseridos toda vez que a aplicação reiniciar.
        // Ele só vai popular o banco se a tabela de categorias estiver vazia.
        if (categoryRepository.count() == 0) {
            System.out.println(">>> [DataSeeder] Banco de dados vazio. Populando com dados de teste...");

            // 1. Criar e salvar as categorias primeiro
            Category cat1 = new Category(null, "Livros");
            Category cat2 = new Category(null, "Eletrônicos");
            categoryRepository.saveAll(Arrays.asList(cat1, cat2));

            // 2. Criar os produtos, associando as categorias já salvas
            Product p1 = new Product(
                    null,
                    "O Senhor dos Anéis: A Sociedade do Anel",
                    "Uma jornada épica para destruir um anel de poder.",
                    new BigDecimal("90.50"),
                    "978-85-325-1175-9",
                    "https://images.tcdn.com.br/img/img_prod/1109483/o_senhor_dos_aneis_a_sociedade_do_anel_volume_1_591_1_4192b003a8f596b6b7134304e2d3e351.jpg",
                    10,
                    cat1 // Associando à categoria "Livros"
            );

            Product p2 = new Product(
                    null,
                    "Fone de Ouvido Sem Fio",
                    "Fone com cancelamento de ruído e alta fidelidade de som.",
                    new BigDecimal("199.99"),
                    "FONE-BT-XYZ-001",
                    "https://images.kabum.com.br/produtos/fotos/476997/headset-sem-fio-gamer-hyperx-cloud-iii-wireless-drivers-53mm-dts-x-preto-e-vermelho-727a2aa_1693836102_g.jpg",
                    25,
                    cat2 // Associando à categoria "Eletrônicos"
            );

            Product p3 = new Product(
                    null,
                    "O Guia do Mochileiro das Galáxias",
                    "Não entre em pânico! A resposta é 42.",
                    new BigDecimal("42.00"),
                    "978-85-8041-949-3",
                    "https://m.media-amazon.com/images/I/81eKeGT9kFL._AC_UF1000,1000_QL80_.jpg",
                    15,
                    cat1 // Associando à categoria "Livros"
            );

            productRepository.saveAll(Arrays.asList(p1, p2, p3));

            System.out.println(">>> [DataSeeder] Banco de dados populado com sucesso!");
        } else {
            System.out.println(">>> [DataSeeder] Banco de dados já contém dados. Nenhuma ação necessária.");
        }
    }
}