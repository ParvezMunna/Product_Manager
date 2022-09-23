package ac.dia.productmanager.ProductManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestController {
	@Autowired
    private CustomerService service;
     
	@GetMapping("/customers" )
	  List<Customer> all() {
	    return service.listAll();
	  }
	
	 @GetMapping("/customers/{id}")
	 Customer one(@PathVariable Long id) {

	    return service.get(id);
	      
	  }
}
