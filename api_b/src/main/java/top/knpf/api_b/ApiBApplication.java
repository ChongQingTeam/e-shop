package top.knpf.api_b;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {"top.knpf.api_b","top.knpf.security","top.knpf.service","top.knpf.dao"})
@EnableDiscoveryClient
@MapperScan("top.knpf.dao")
public class ApiBApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiBApplication.class, args);
    }

}
