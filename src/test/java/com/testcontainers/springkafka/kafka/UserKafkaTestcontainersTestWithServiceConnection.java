package com.testcontainers.springkafka.kafka;

import com.testcontainers.springkafka.dto.User;
import com.testcontainers.springkafka.kafka.producer.UserKafkaProducer;
import com.testcontainers.springkafka.service.UserService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

@Testcontainers
@SpringBootTest
class UserKafkaTestcontainersTestWithServiceConnection {

    @Container
    @ServiceConnection
    static KafkaContainer kafkaContainer = new KafkaContainer(DockerImageName
            .parse("confluentinc/cp-kafka:latest"));

    @AfterAll
    static void tearDown() {
        kafkaContainer.stop();

    }

    @Autowired
    private UserKafkaProducer userKafkaProducer;

    @MockBean
    private UserService userService;

    @Test
    void testProduceAndConsumeKafkaMessage() {
        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
        User user = new User("11111", "John", "Wick");

        userKafkaProducer.writeToKafka(user);

        verify(userService, timeout(5000)).save(captor.capture());
        assertNotNull(captor.getValue());
        assertEquals("11111", captor.getValue().getUuid());
        assertEquals("John", captor.getValue().getFirstName());
        assertEquals("Wick", captor.getValue().getLastName());
    }
}
