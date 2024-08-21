package com.shivam.fistspringapi.services;

import com.shivam.fistspringapi.exceptions.ProductNotFoundException;
import com.shivam.fistspringapi.models.Product;
import com.shivam.fistspringapi.dtos.FakeStoreProductDto;
import com.shivam.fistspringapi.models.Category;
import com.shivam.fistspringapi.models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate;

    FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreDtoToProduct(FakeStoreProductDto dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setImage(dto.getImage());

        Category category = new Category();
        category.setDesc(dto.getCategory());
        product.setCategory(category);

        return product;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        //Call FakeStore API here to get the Product with given id.
        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                        FakeStoreProductDto.class);
        //1st param -> URL
        //2nd param -> Response

        if (fakeStoreProductDto == null) {
            throw new ProductNotFoundException("Product with this" + id + "is not found");
            //return null;
        }

        //Convert FakeStore DTO into Product object.
        return convertFakeStoreDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtos=
                restTemplate.getForObject("https://fakestoreapi.com/products",
                        FakeStoreProductDto[].class);

        //convert list of FakeStoreProductDto to list of product
        List<Product> response=new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            response.add(convertFakeStoreDtoToProduct(fakeStoreProductDto));
        }
        return response;
    }

    @Override
    public Product replaceProduct(Long id ,Product product) {
        FakeStoreProductDto fakeStoreProductDto=new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setImage(product.getImage());
        fakeStoreProductDto.setDescription(product.getDescription());


        RequestCallback requestCallback= restTemplate.httpEntityCallback(product,FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor=
              new HttpMessageConverterExtractor<>(FakeStoreProductDto.class,
                                        restTemplate.getMessageConverters());
        FakeStoreProductDto response=
         restTemplate.execute("https://fakestoreapi.com/products/" + id,
                HttpMethod.PUT,requestCallback,responseExtractor);

        return convertFakeStoreDtoToProduct(response);
    }
}

