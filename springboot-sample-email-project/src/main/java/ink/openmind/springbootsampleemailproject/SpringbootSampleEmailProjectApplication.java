package ink.openmind.springbootsampleemailproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringbootSampleEmailProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSampleEmailProjectApplication.class, args);
    }

}
