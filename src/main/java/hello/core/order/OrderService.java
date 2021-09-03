/**
 * 
 */
package hello.core.order;

/**
 * @author irvin
 *
 */
public interface OrderService {
	
	Order createOrder(Long memberId, String itemName, int itemPrice);

}
