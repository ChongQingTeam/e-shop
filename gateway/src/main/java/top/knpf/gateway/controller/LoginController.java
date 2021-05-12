package top.knpf.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import top.knpf.domain.b.input.BLoginFormParam;
import top.knpf.domain.b.output.BaseResult;
import top.knpf.security.utils.SecurityUtils;

@CrossOrigin
@RestController
@RequestMapping("/b/login")
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/success")
    public String success(){
        return "登录成功！";
    }

    @PostMapping("/do")
    public BaseResult<User> login(@RequestBody BLoginFormParam param)  {
        BaseResult<User> baseResult = new BaseResult<>();
        User user = SecurityUtils.login(param.getUsername(), param.getPassword(), authenticationManager);
        if(user == null){
            return baseResult.renderError("登陆失败","401");
        }
        return baseResult.renderSuccess("登录成功","200", user);
    }

}
