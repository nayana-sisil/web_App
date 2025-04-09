package com.nayana.ecommerce_webApp.Repository;

import com.nayana.ecommerce_webApp.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    //youre making a interfacce of productrepository and ectending it using
    // defaults comes with jpa. by doing that you will gget certain methods to handle
    //database

}
