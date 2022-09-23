package ac.dia.productmanager.ProductManager;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService {
 
    @Autowired
    private ProductRepository repo;
     
    public List<Product> listAll() {
        return (List<Product>) repo.findAll();
    }
     
    public Product save(Product product) {
        return repo.save(product);
      
    }
     
    public Product get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}