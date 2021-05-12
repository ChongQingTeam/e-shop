package top.knpf.gateway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 网关
 */
@SpringBootApplication(scanBasePackages = {"top.knpf.gateway","top.knpf.security","top.knpf.service","top.knpf.dao"})
@EnableDiscoveryClient
@MapperScan("top.knpf.dao")
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

}
