package ac.dia.productmanager.ProductManager;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerService {
	@Autowired
    private CustomerRepository repo;
     
    public List<Customer> listAll() {
        return (List<Customer>) repo.findAll();
    }
     
    public void save(Customer customer) {
        repo.save(customer);
    }
     
    public Customer get(long id) {
        return repo.findById(id);
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }

}
