package ac.dia.productmanager.ProductManager;



public class ProductNotFoundException extends  RuntimeException {

	public ProductNotFoundException(Long id) {
		super("Could not find employee " + id);
		// TODO Auto-generated constructor stub
	}

	
}
