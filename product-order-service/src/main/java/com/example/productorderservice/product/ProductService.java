package com.example.productorderservice.product;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class ProductService {
    private final ProductPort productPort;

    ProductService(ProductPort productPort) {
        this.productPort = productPort;
    }


    @Transactional
    public void addProduct(AddProductRequest request) {
        final Product product = new Product(request.name(), request.price(), request.discountPolicy());

        productPort.save(product);
    }

    public GetProductResponse getProduct(Long productId) {
        final Product product = productPort.getProduct(productId);

        return new GetProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getDiscountPolicy()
        );
    }

    public void updateProduct(Long productId, UpdateProductRequest request) {
        final Product product = productPort.getProduct(productId);
        product.update(request.name(), request.price(), request.discountPolicy());

        productPort.save(product);
    }
}
