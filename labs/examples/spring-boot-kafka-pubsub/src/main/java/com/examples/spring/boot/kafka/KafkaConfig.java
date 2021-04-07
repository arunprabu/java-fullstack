package com.examples.spring.boot.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
@EnableKafka
public class KafkaConfig {
	
	  @Value("${spring.kafka.bootstrap-servers}")
	  private String bootstrapServers;

	  @Bean
	  public Map<String, Object> producerConfigs() {
	    Map<String, Object> props = new HashMap<>();
	    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
	    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

	    return props;
	  }

	  @Bean
	  public ProducerFactory<String, String> producerFactory() {
	    return new DefaultKafkaProducerFactory<>(producerConfigs());
	  }

	  @Bean
	  public KafkaTemplate<String, String> kafkaTemplate() {
		  return new KafkaTemplate<>(producerFactory());
	  }
	  	  
	  
	  // Optional. Auto configured.
	  @Bean
	  public KafkaAdmin admin() {
	      Map<String, Object> configs = new HashMap<>();
	      configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
	      return new KafkaAdmin(configs);
	  }	  
	  
	  @Bean
	  public NewTopic orderCreated() {
	      return new NewTopic("spring-kafka-test", 1, (short) 1);
	  }
}
