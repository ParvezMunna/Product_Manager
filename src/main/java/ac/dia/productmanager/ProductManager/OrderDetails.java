package ac.dia.productmanager.ProductManager;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class OrderDetails {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int orderDetailId;
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "orderId",insertable = false,updatable = false)
	    private Orders orders;
	    private int orderId;
	    private int pid;
	    private int qty;
	    private double price;
	    private double subTotal;

	    
	   
	    public OrderDetails() {
	    }

	    public OrderDetails(int orderDetailId, int orderId, int pid, int qty, double price, double subTotal) {
	        this.orderDetailId = orderDetailId;
	        this.orderId = orderId;
	        this.pid = pid;
	        this.qty = qty;
	        this.price = price;
	        this.subTotal = subTotal;
	    }

	    public int getOrderDetailId() {
	        return orderDetailId;
	    }

	    public void setOrderDetailId(int orderDetailId) {
	        this.orderDetailId = orderDetailId;
	    }
        @ManyToOne()
	    public int getOrderId() {
	        return orderId;
	    }

	    public void setOrderId(int orderId) {
	        this.orderId = orderId;
	    }

	    public int getPid() {
	        return pid;
	    }

	    public void setPid(int pid) {
	        this.pid = pid;
	    }

	    public int getQty() {
	        return qty;
	    }

	    public void setQty(int qty) {
	        this.qty = qty;
	    }

	    public double getPrice() {
	        return price;
	    }

	    public void setPrice(double price) {
	        this.price = price;
	    }

	    public double getSubTotal() {
	        return subTotal;
	    }

	    public void setSubTotal(double subTotal) {
	        this.subTotal = subTotal;
	    }

	    @Override
	    public String toString() {
	        return "OrderDetails{" + "orderDetailId=" + orderDetailId + ", orderId=" + orderId + ", pid=" + pid + ", qty=" + qty + ", price=" + price + ", subTotal=" + subTotal + '}';
	    }

}
