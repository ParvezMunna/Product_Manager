package ac.dia.productmanager.ProductManager;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderDetailsService {
 
    @Autowired
    private OrderDetailsRepository repo;
     
    public List<OrderDetails> listAll() {
        return (List<OrderDetails>) repo.findAll();
    }
     
    public OrderDetails save(OrderDetails orderDetails) {
        return repo.save(orderDetails);
    }
     
    public OrderDetails get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}