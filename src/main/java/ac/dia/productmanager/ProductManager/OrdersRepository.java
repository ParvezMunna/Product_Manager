package ac.dia.productmanager.ProductManager;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrdersRepository extends CrudRepository<Orders, Long>{
	
	@Query(value = "SELECT coalesce(max(orderId),0) FROM Orders")
	public Long max();
}
