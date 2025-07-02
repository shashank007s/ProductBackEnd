package product.ProductJava;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class Productrepository {
    private List<Product> products = new ArrayList<>();
    private long currentId = 1;
    public Product Save( Product product) {
        product.setId(currentId++);
        products.add(product);
        return product;
    }

    public Optional<Product> FindById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    public List<Product> findall() {
        return new ArrayList<>(products);
    }
}
