package com.examples.spring.jpa;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHibernateJpaMain {
	
	private static EntityManagerFactory entityManagerFactory;
	
	public static void main(String[] args)
	{
		SpringHibernateJpaMain springHibernateMain = new SpringHibernateJpaMain();
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");
		
		entityManagerFactory = (EntityManagerFactory) ctx.getBean("localContainerEntityManagerFactoryBean");
		
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
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		// persist order detail
		entityManager.persist(order);
		entityManager.getTransaction().commit();
		System.out.println("\nOrder added successfully. ID - " + order.getId());

		entityManager.close();
		return order.getId();
	}
	
	private void updateOrder(Long orderId, String customerName)
	{
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		// Fetch order detail for update
		Order orderForUpdate = (Order) entityManager.find(Order.class, orderId);
		
		orderForUpdate.setCustomer(customerName);
		
		// Persist updated order detail
		entityManager.persist(orderForUpdate);
		entityManager.getTransaction().commit();
		System.out.printf("\nOrder %d updated successfully.\n", orderId);
		
		entityManager.close();
	}
	
	private void deleteOrder(Long orderId)
	{
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();		
		// Fetch order detail for update
		Order orderForDelete = (Order) entityManager.find(Order.class, orderId);
		
		// Delete order detail
		entityManager.remove(orderForDelete);
		
		entityManager.getTransaction().commit();		
		System.out.printf("\nOrder %d deleted successfully.\n", orderId);
		
		entityManager.close();
	}

	private void showOrders() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<Order> orders = entityManager.createQuery("select o from Order o").getResultList();
		
		// show order header
		if(orders.size() > 0)
			System.out.println("Order ID \t Customer");
		else
			System.out.println("No order found.");
		
		for(Order order : orders)
		{
			// print order detail
			System.out.printf("%d \t %s \n", order.getId(), order.getCustomer());
		
//			List<Item> items = session.createQuery("select i from Item i").list();
//			Collection<Item> items = order.getItems();
//			
//			// print item header
//			if(items.size() > 0)
//				System.out.println("Item ID \t Product \t Quantity \t Price");
//			else
//				System.out.println("No Item found");
//			
//			// print item details
//			for(Item item: items)
//			{
//				System.out.printf("\t %d \t %s \t %d \t %s \n", item.getId(), item.getProduct(), item.getQuantity(), item.getPrice());
//			}
		}
		entityManager.close();
	}

}
