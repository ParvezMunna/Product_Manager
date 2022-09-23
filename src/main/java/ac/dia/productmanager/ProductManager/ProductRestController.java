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
public class ProductRestController {

	@Autowired
	private ProductService service;

	@GetMapping("/products")
	List<Product> all() {
		return service.listAll();
	}

	@GetMapping("/products/{id}")
	Product one(@PathVariable Long id) {

		return service.get(id);

	}

	@RequestMapping(value = "/saleProduct", method = RequestMethod.POST, headers = "Accept=application/json")
	public Product saleProduct(@RequestBody Product product) {
		return service.save(product);
	}

	@RequestMapping(value = "/purchaseProduct", method = RequestMethod.POST, headers = "Accept=application/json")
	public Product purchaseProduct(@RequestBody Product product) {

		return service.save(product);
	}

}
