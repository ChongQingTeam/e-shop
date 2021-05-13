package top.knpf.api_b.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.knpf.domain.b.input.BLoginFormParam;
import top.knpf.domain.b.output.BaseResult;
import top.knpf.security.utils.SecurityUtils;
import top.knpf.utils.security.TokenUtils;

@Slf4j
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
    public BaseResult<String> login(@RequestBody BLoginFormParam param)  {
        BaseResult<String> baseResult = new BaseResult<>();
        User user = SecurityUtils.login(param.getUsername(), param.getPassword(), authenticationManager);
        if(user == null){
            return baseResult.renderError("登陆失败","401");
        }
        String token = TokenUtils.buildJWT(param.getUsername());
        return baseResult.renderSuccess("登录成功","200", token);
    }

}
