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
public class ProductController {
 
    @Autowired
    private ProductService service;
     
    // handler methods...
    @RequestMapping("/product")
    public String viewHomePage(Model model) {
        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);
         
        return "product_index";
    }
    
    @RequestMapping("/newProduct")
    public String showNewProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
         
        return "new_product";
    }
    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        service.save(product);
         
        return "redirect:/";
    }
    
    @RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
    public String updateProduct(@ModelAttribute("product") Product product) {
    	
    	Product p=service.get(product.getId());
    	p.setName(product.getName());
    	p.setBrand(product.getBrand());
    	p.setMadein(product.getMadein());
    	p.setPrice(product.getPrice());
        service.save(p);
         
        return "redirect:/";
    }
    
    
    
    @RequestMapping("/editProduct/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_product");
        Product product = service.get(id);
        mav.addObject("product", product);
         
        return mav;
    }
    @RequestMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";       
    }
}