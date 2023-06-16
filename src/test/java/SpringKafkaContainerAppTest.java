import com.testcontainers.springkafka.SpringKafkaContainerApp;
import com.testcontainers.springkafka.kafka.KafkaTestContainerConfigurations;
import org.springframework.boot.SpringApplication;

public class SpringKafkaContainerAppTest {


    public static void main(String[] args) {
        SpringApplication.from(SpringKafkaContainerApp::main)
                .with(KafkaTestContainerConfigurations.class)
                .run(args);
    }
}
