package ink.openmind.springbootsampleprofileproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringbootSampleProfileProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSampleProfileProjectApplication.class, args);
    }

}
