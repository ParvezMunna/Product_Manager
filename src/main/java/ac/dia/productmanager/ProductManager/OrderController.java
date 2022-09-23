package ac.dia.productmanager.ProductManager;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

	 // handler methods...
    @RequestMapping("/order")
    public String viewHomePage(Model model) {
        //List<Customer> listCustomers = service.listAll();
        //model.addAttribute("listCustomers", listCustomers);
         
        return "myOrder";
    }
	
}
