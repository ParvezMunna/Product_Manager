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
public class OrderRestController {
	@Autowired
    private OrdersService service;
     
	@GetMapping("/orders" )
	  List<Orders> all() {
		
	    return service.listAll();
	  }
	
	 @GetMapping("/orders/{id}")
	 Orders one(@PathVariable Long id) {

	    return service.get(id);
	      
	  }
	 
	 @RequestMapping(value = "/saveOrder", method = RequestMethod.POST, headers = "Accept=application/json")
		public Orders saleProduct(@RequestBody Orders orders) {
			return service.save(orders);
		}

	 
	 
	 @GetMapping("/maxOrderNo")
	public	 long getMax() {

			return service.maxId()+1;

		}
}
