package com.examples.spring.hibernate;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHibernateMain {
	
	private static SessionFactory sessionFactory;
	
	public static void main(String[] args)
	{
		SpringHibernateMain springHibernateMain = new SpringHibernateMain();
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");
		
		sessionFactory = (SessionFactory) ctx.getBean("sessionFactoryBean");
		
		// Create Order
		Order order1 = new Order();
		order1.setCustomer("Sunil");
		
		// Create Item
		Item item1 = new Item();
		item1.setProduct("Spring in Action Book");
		item1.setPrice(500);
		item1.setQuantity(50);
				
		// Add item to Order
		order1.setItems(Arrays.asList(item1));
		
		Long orderId1 = springHibernateMain.createOrder(order1);	
		//Long orderId2 = springHibernateMain.createOrder(order1);
		
		springHibernateMain.showOrders();
		
		springHibernateMain.updateOrder(orderId1, "Anil");
		
		springHibernateMain.showOrders();
		
		springHibernateMain.deleteOrder(orderId1);
		
		springHibernateMain.showOrders();
	}	

	private Long createOrder(Order order)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// persist order detail
		Long orderId = (Long) session.save(order);
		session.getTransaction().commit();
		System.out.println("Order added successfully. ID - " + orderId);

		session.close();
		return orderId;
	}
	
	private void updateOrder(Long orderId, String customerName)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// Fetch order detail for update
		Order orderForUpdate = (Order) session.get(Order.class, orderId);
		
		orderForUpdate.setCustomer(customerName);
		
		// Persist updated order detail
		session.update(orderForUpdate);
		session.getTransaction().commit();
		System.out.printf("Order %d updated successfully.\n", orderId);
		
		session.close();
	}
	
	private void deleteOrder(Long orderId)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();		
		// Fetch order detail for update
		Order orderForDelete = (Order) session.get(Order.class, orderId);
		
		// Delete order detail
		session.delete(orderForDelete);
		
		session.getTransaction().commit();		
		System.out.printf("Order %d deleted successfully.\n", orderId);
		
		session.close();
	}

	private void showOrders() {
		Session session = sessionFactory.openSession();
		List<Order> orders = session.createQuery("select o from Order o").list();
		
		// show order header
		if(orders.size() > 0)
			System.out.println("\n Order ID \t Customer");
		else
			System.out.println("No order found.");
		
		for(Order order : orders)
		{
			// print order detail
			System.out.printf("%d \t %s \n", order.getId(), order.getCustomer());
		
//			List<Item> items = session.createQuery("select i from Item i").list();
			Collection<Item> items = order.getItems();
			
			// print item header
			if(items.size() > 0)
				System.out.println("Item ID \t Product \t Quantity \t Price");
			else
				System.out.println("No Item found");
			
			// print item details
			for(Item item: items)
			{
				System.out.printf("\t %d \t %s \t %d \t %s \n", item.getId(), item.getProduct(), item.getQuantity(), item.getPrice());
			}
		}
		session.close();
	}

}
