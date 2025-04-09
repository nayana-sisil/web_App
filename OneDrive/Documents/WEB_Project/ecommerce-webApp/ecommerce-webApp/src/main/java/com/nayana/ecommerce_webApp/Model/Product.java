package com.nayana.ecommerce_webApp.Model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
@AllArgsConstructor
@NoArgsConstructor ///thease are for lomback. that will create getters setters, constructos automatically
@Entity //creating the table using jpa
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//setting int id as primary key
    private int id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    //changiing the date format by help of json libry
    private Date releaseDate;
    private boolean productAvailable;
    private int stockQuantity;

    //for image
    private String imageName;
    private String imageType;
    @Lob // to hangle large object
    private byte[] imageData; //we store image in byte format


    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
