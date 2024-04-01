package com.example.produit_app;

import com.example.produit_app.entities.Product;
import com.example.produit_app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProduitAppApplication implements CommandLineRunner {
@Autowired
    private ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(ProduitAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(null,"Conputer",4300,3));
        productRepository.save(new Product(null,"Printer",1200,4));
        productRepository.save(new Product(null,"Smart Phone",3200,32));
        List<Product> products=productRepository.findAll();
        products.forEach(p->{
            System.out.println(p.toString());
        });
        Product product=productRepository.findById(Long.valueOf(1)).get();
        System.out.println("***************");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuantity());
        System.out.println("****************");
        System.out.println("----------------");
        List<Product> productList=productRepository.findByNameContains("C");
        productList.forEach(p->{
            System.out.println(p);
        });
        System.out.println("----------------");
        List<Product> productList2=productRepository.search("%C%");
        productList2.forEach(p->{
            System.out.println(p);
        });
        System.out.println("----------------");
        List<Product> productList3=productRepository.searchByPrice(3000);
        productList3.forEach(p->{
            System.out.println(p);
        });





    }
}
