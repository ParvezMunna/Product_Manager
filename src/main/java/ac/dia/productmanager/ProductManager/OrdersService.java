package ac.dia.productmanager.ProductManager;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrdersService {
 
    @Autowired
    private OrdersRepository repo;
     
    public List<Orders> listAll() {
        return (List<Orders>) repo.findAll();
    }
     
    public Orders save(Orders product) {
      return  repo.save(product);
    }
     
    public Orders get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
    public Long maxId() {
    	    	
    	return repo.max();
    }
}