package com.nayana.ecommerce_webApp.Controller;

import com.nayana.ecommerce_webApp.Model.Product;
import com.nayana.ecommerce_webApp.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin //solving the cross error.so you can give access to connect ffrontend port with backend port
@RequestMapping("/api") //this is the home
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("/") //this is for home call
    public String greet() {
        return "Hello world";
    }

    @GetMapping("/products")  //you will use getmapping because its a get(read)
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/product/{productId}")
    public Product getProductById(@PathVariable int productId){
        return service.getProductById(productId);
    }

    @PostMapping("/product")
    public void addProduct(@RequestPart Product product,
                           @RequestPart MultipartFile imageFile) throws IOException {
        service.addProduct(product,imageFile);
    }

    @GetMapping("/product/{productId}/image")
    public byte[] getImageProductById(@PathVariable Integer productId) {
        Product product = service.getProductById(productId);
        return product.getImageData();
    }

     @PutMapping("/product/{id}")
     public void updateProduct(@PathVariable int id,@RequestPart Product product,
                               @RequestPart MultipartFile imageFile) throws IOException {
        service.updateProduct(id,product,imageFile);
     }

     @DeleteMapping("/product/{id}")
    public void  deleteProduct(@PathVariable int id) {
        service.deleteProduct(id);
     }




}
