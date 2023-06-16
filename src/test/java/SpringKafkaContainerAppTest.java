import com.madadipouya.springkafkatest.SpringKafkaContainerApp;
import com.madadipouya.springkafkatest.kafka.KafkaTestContainerConfigurations;
import org.springframework.boot.SpringApplication;

public class SpringKafkaContainerAppTest {


    public static void main(String[] args) {
        SpringApplication.from(SpringKafkaContainerApp::main)
                .with(KafkaTestContainerConfigurations.class)
                .run(args);
    }
}
