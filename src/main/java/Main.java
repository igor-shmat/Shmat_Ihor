import dto.ProductDto;
import service.ProductService;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        ProductService productService = new ProductService();
        ProductDto productDto = productService.parseFile();
        System.out.printf("%s %s %s%n", productDto.getProductName(), productDto.getDateSale().format(formatter), productDto.getPrice());
    }
}
