package app;

import java.util.Date;

import entities.enums.OrderStatus;
import entitties.Order;

public class ProgramOrder {

	public static void main(String[] args) {
		
		/*
		 * Teste de instância da Classe Order 
		 * para impressão da situação de pedidos
		 */

		Order order = new Order(1080, new Date(), OrderStatus.PENDING_PAYMENT);
		
		System.out.println(order);
		
		OrderStatus os1 = OrderStatus.DELIVERED;
		
		OrderStatus os2 = OrderStatus.valueOf("DELIVERED");
		
		System.out.println(os1);
		System.out.println(os2);
	}

}
