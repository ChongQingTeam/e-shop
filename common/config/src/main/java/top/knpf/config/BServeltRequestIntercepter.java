package top.knpf.config;

import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import top.knpf.domain.b.output.BaseResult;
import top.knpf.utils.security.TokenUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class BServeltRequestIntercepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String tokenKey = "token";
        boolean flag = false;

        String token=request.getHeader("token");
//        Cookie[] cookies = request.getCookies();
        if (StrUtil.isBlank(token)) {
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getOutputStream().write("{\"success\":\"false\",\"message\":\"请先登录\",\"code\":401}".getBytes());
            return false;
        }
//        Map<String, Cookie> cookiesMap = new HashMap(cookies.length);
//        for (Cookie cookie : cookies) {
//            cookiesMap.put(cookie.getName(), cookie);
//        }
//        if (cookiesMap.get(tokenKey) != null) {
//            token = cookiesMap.get(tokenKey).getValue();
//            if (!StrUtil.isBlank(token)) {
//                flag = true;
//            }
//        }
        BaseResult baseResult = TokenUtils.vaildToken(token);
        if(baseResult.isSuccess()){
            return true;
        }else {
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            String responseMsg = "{\"success\":\"false\",\"message\":\""+baseResult.getMsg()+"\",\"code\":401}";
            response.getOutputStream().write(responseMsg.getBytes());
            return false;
        }
    }
}
