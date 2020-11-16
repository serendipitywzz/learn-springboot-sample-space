package ink.openmind.springbootsamplecustomerrorpageproject;


import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringbootSampleCustomerrorpageProjectApplication{

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSampleCustomerrorpageProjectApplication.class, args);
    }
}
