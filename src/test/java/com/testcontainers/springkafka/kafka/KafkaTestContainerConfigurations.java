package com.testcontainers.springkafka.kafka;

import org.springframework.boot.devtools.restart.RestartScope;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.utility.DockerImageName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@TestConfiguration(proxyBeanMethods = false)
public class KafkaTestContainerConfigurations {


	@Bean
	@ServiceConnection
	@RestartScope
	public KafkaContainer kafkaContainer() {
		return new KafkaContainer(
				DockerImageName.parse("confluentinc/cp-kafka:latest"))
				.withKraft()
				.withReuse(true);
	}

}
