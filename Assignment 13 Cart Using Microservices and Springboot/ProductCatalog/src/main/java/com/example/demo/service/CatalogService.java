package com.example.demo.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Price;
import com.example.demo.model.Product;
import com.example.demo.model.ProductCatalog;
import com.example.demo.model.Stock;

@Service
public class CatalogService {

    private final RestTemplate restTemplate;

    public CatalogService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ProductCatalog> getAllProducts() {
        List<ProductCatalog> result = new ArrayList<>();

        List<Product> products = restTemplate.exchange(
                "http://PRODUCT/products",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {
                }).getBody();

        if (products != null) {
            for (Product product : products) {
                ProductCatalog catalog = buildCatalog(product.getPid());
                if (catalog != null) {
                    result.add(catalog);
                }
            }
        }

        return result;
    }

    public ProductCatalog getById(Long id) {
        return buildCatalog(id);
    }

    public List<ProductCatalog> getByCategory(String category) {
        List<ProductCatalog> result = new ArrayList<>();

        List<Product> products = restTemplate.exchange(
                "http://PRODUCT/products/category/" + category,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {
                }).getBody();

        if (products != null) {
            for (Product product : products) {
                ProductCatalog catalog = buildCatalog(product.getPid());
                if (catalog != null) {
                    result.add(catalog);
                }
            }
        }

        return result;
    }

    private ProductCatalog buildCatalog(Long pid) {
        Product product = restTemplate.getForObject(
                "http://PRODUCT/products/" + pid,
                Product.class);

        Price price = restTemplate.getForObject(
                "http://PRICING/prices/" + pid,
                Price.class);

        Stock stock = restTemplate.getForObject(
                "http://INVENTORY/stocks/" + pid,
                Stock.class);

        if (product == null || price == null || stock == null) {
            return null;
        }

        ProductCatalog catalog = new ProductCatalog();
        catalog.setPid(product.getPid());
        catalog.setPname(product.getPname());
        catalog.setPcategory(product.getPcategory());
        catalog.setDiscountedPrice(price.getDiscountedPrice());
        catalog.setNoOfItems(stock.getNoOfItemsLeft());

        return catalog;
    }
}