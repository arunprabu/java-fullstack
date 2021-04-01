package com.examples.spring.hibernate;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.dialect.H2Dialect;
import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

@Configuration
public class HibernateConfiguration {

	@Value("#{dataSource}")
	private DataSource dataSource;
	
/*	@Bean
	public MysqlDataSource dataSource() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setDatabaseName("hibernate_training");
		dataSource.setUser("training");
		dataSource.setPassword("training");
		dataSource.setServerName("localhost");
		return dataSource;
	}*/
	
	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		Properties props = new Properties();
		props.put("hibernate.dialect", H2Dialect.class.getName());
//		props.put("hibernate.dialect", MySQL5Dialect.class.getName());
//		props.put("hibernate.format_sql", "true");
		props.put("hibernate.hbm2ddl.auto", "create");		

		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setAnnotatedClasses(new Class[]{Item.class, Order.class});		
		bean.setHibernateProperties(props);
//		bean.setDataSource(dataSource());
		bean.setDataSource(dataSource);
		return bean;
	}
	
	// equivalent xml configuration
	/*
	<beans:bean id="sessionFactoryBean"	class="org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean">
		<!-- datasource detail -->
		<beans:property name="dataSource" ref="dataSource" />
	
		<!-- hibernate properties -->
		<beans:property name="hibernateProperties">
			<beans:props>
				<beans:prop key="hibernate.dialect">org.hibernate.dialect.MySQLDialect
				</beans:prop>
				<beans:prop key="hibernate.show_sql">true</beans:prop>
				<beans:prop key="hibernate.hbm2ddl.auto">create</beans:prop>
			</beans:props>
		</beans:property>
		
		<beans:property name="annotatedClasses">
			<beans:list>
				<beans:value>com.examples.spring.hibernate.Order</beans:value>
				<beans:value>com.examples.spring.hibernate.Item</beans:value>					
			</beans:list>
		</beans:property>	
	</beans:bean>
	*/
	

	@Bean
	public HibernateTransactionManager transactionManager() {
		return new HibernateTransactionManager( sessionFactoryBean().getObject() );
	}
	
	// equivalent xml configuration
	/*
	<beans:bean id="transactionManager" class="org.springframework.orm.hibernate3.HibernateTransactionManager.HibernateTransactionManager">
			<beans:property name="sessionFactory" ref="sessionFactoryBean" />
		</beans:bean>	
	*/
}
