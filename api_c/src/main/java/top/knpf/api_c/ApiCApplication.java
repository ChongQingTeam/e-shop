package top.knpf.api_c;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"top.knpf.api_c","top.knpf.security","top.knpf.service","top.knpf.dao",
        "top.knpf.config"})
@MapperScan("top.knpf.dao")
public class ApiCApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiCApplication.class, args);
    }

}
