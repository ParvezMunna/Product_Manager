package ac.dia.productmanager.ProductManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
	@Autowired
    private CustomerService service;
	
	 // handler methods...
    @RequestMapping("/customer")
    public String viewHomePage(Model model) {
        List<Customer> listCustomers = service.listAll();
        model.addAttribute("listCustomers", listCustomers);
         
        return "customer_index";
    }
    
    @RequestMapping("/newCustomer")
    public String showNewProductPage(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
         
        return "new_Customer";
    }
    @RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("customer") Customer customer,Model model) {
        service.save(customer);
       List<Customer> listCustomers = service.listAll();
        model.addAttribute("listCustomers", listCustomers);
        return "redirect:/";
    }
    @RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
    public String updateCustomer(@ModelAttribute("customer") Customer customer,Model model) {
       
    	Customer c=service.get(customer.getId());
    	c.setFirstName(customer.getFirstName());
    	c.setLastName(customer.getLastName());
    	service.save(c);
    	 List<Customer> listCustomers = service.listAll();
        model.addAttribute("listCustomers", listCustomers);
        return "redirect:/";
    }
    
    @RequestMapping("/editCustomer/{id}")
    public ModelAndView showEditCustomerPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_customer");
        Customer customer = service.get(id);
        mav.addObject("customer", customer);
         
        return mav;
    }
    @RequestMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";       
    }
     
}
