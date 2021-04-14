package com.examples.scart.product.repository;

import com.examples.scart.product.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DataJpaTest
public class ProductRepositoryTests {

    @Autowired
    TestEntityManager entityMgr;

    @Autowired
    ProductRepository productRepo;

    @Test
    public void testCreateProduct() {
        System.out.println(entityMgr);

        Product mobile = new Product();
        mobile.setId("1");
        mobile.setName("Samsung Galaxy Note10");
        mobile.setCategory("Mobiles");
        mobile.setManufacturer("Samsung");

        productRepo.save(mobile);
        Product found = entityMgr.find(Product.class, mobile.getId());

        assertThat(found.getId()).isEqualTo(mobile.getId());

        assertThat(found).hasFieldOrProperty("name");
    }
}
