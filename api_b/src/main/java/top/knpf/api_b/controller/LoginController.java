package top.knpf.api_b.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import top.knpf.domain.b.input.BLoginFormParam;
import top.knpf.domain.b.output.AdminInfo;
import top.knpf.domain.b.output.BaseResult;
import top.knpf.security.utils.SecurityUtils;
import top.knpf.utils.security.TokenUtils;

@Slf4j
//@CrossOrigin
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
    public BaseResult<AdminInfo> login(@RequestBody BLoginFormParam param)  {
        BaseResult<AdminInfo> baseResult = new BaseResult<>();
        User user = SecurityUtils.login(param.getUsername(), param.getPassword(), authenticationManager);
        if(user == null){
            return baseResult.renderError("登陆失败","401");
        }
        String token = TokenUtils.buildJWT(param.getUsername());
        AdminInfo adminInfo = new AdminInfo();
        adminInfo.setAdminName(user.getUsername());
        adminInfo.setToken(token);
        return baseResult.renderSuccess("登录成功","200", adminInfo);
    }

}
