package product.ProductJava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final Productrepository productRepository;

    @Autowired
    public ProductService(Productrepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        if (product.getName() == null || product.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty.");
        }
        return productRepository.Save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findall();
    }
}
