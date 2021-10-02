package service;


import com.google.common.base.Strings;
import dto.ProductDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class ProductService {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    // считываем файл
    public ProductDto parseFile() throws IOException {
        List<ProductDto> products = new ArrayList<>();
        ClassLoader loader = ProductService.class.getClassLoader();
        InputStream is = loader.getResourceAsStream("input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        String line = br.readLine();
        while (line != null) {
            // получили строку
            line = br.readLine();
            // проверили не пустая ли она
            if (!Strings.isNullOrEmpty(line)) {
                String split[] = line.split("#");
                products.add(new ProductDto(split[0], LocalDate.parse(split[1], formatter), Double.parseDouble(split[2])));
            }
        }
        return calculate(products);
    }

    public ProductDto calculate(List<ProductDto> products) {
        List<ProductDto> productSums = new ArrayList<>();
        products.stream()
                .collect(Collectors.groupingBy(one -> one.getProductName(),
                        Collectors.summingDouble(one -> one.getPrice())))
                .forEach((name, sumTargetCost) -> {
                    productSums.add(new ProductDto(name, sumTargetCost));
                });
        // сортируем по сумме , самая большая будет первая
        productSums.stream().sorted((p1, p2) -> ((Double) p1.getPrice()).compareTo(p2.getPrice()));
        ProductDto result = productSums.get(0);

        LocalDate dateSale = products.stream()
                .filter(one -> one.getProductName().equals(result.getProductName()))
                .map(ProductDto::getDateSale).max(LocalDate::compareTo).get();
        result.setDateSale(dateSale);
        return result;
    }
}
