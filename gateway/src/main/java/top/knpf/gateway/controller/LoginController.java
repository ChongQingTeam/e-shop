package top.knpf.gateway.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/b/login")
public class LoginController {

    @PostMapping("/success")
    public String success(){
        return "登录成功！";
    }
}
