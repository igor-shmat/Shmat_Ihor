package dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductDto {
    private String productName;
    private LocalDate dateSale;
    private Double price;

    public ProductDto(String productName, Double price) {
        this.productName = productName;
        this.price = price;
    }

    public ProductDto(String productName, LocalDate dateSale, Double price) {
        this.productName = productName;
        this.dateSale = dateSale;
        this.price = price;
    }


}
