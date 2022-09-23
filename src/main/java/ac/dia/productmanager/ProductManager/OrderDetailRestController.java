package ac.dia.productmanager.ProductManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderDetailRestController {
	@Autowired
    private OrderDetailsService service;
     
	@GetMapping("/orderDetails" )
	  List<OrderDetails> all() {
		
	    return service.listAll();
	  }
	
	 @GetMapping("/orderDetails/{id}")
	 OrderDetails one(@PathVariable Long id) {

	    return service.get(id);
	      
	  }
	 
	 @RequestMapping(value = "/saveOrderDetails", method = RequestMethod.POST, headers = "Accept=application/json")
		public OrderDetails saleProduct(@RequestBody OrderDetails orders) {
			return service.save(orders);
		}

	 
	 
	 
}
