package top.knpf.api_b.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.knpf.domain.b.output.AdminInfo;
import top.knpf.domain.b.output.BaseResult;
import top.knpf.model.b.sys.Admin;
import top.knpf.service.b.ISysAdminService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/b/admin")
public class AdminController {

    @Autowired
    ISysAdminService adminService;

    @GetMapping("/info/get")
    public BaseResult<AdminInfo> getAdminInfo(@RequestParam(value = "username",required = false,
            defaultValue = "admin") String username){
        BaseResult<AdminInfo> adminInfo = new BaseResult<>();
        Admin baseInfo = adminService.getAdminByUsername(username);
        List<String> roles = adminService.listAdminRoles(baseInfo.getId());
        return adminInfo.renderSuccess(toAdminInfo(baseInfo, roles));
    }

    private AdminInfo toAdminInfo(Admin baseInfo, List<String> roles) {
        AdminInfo info = new AdminInfo();
        info.setAdminId(baseInfo.getId());
        info.setAdminName(baseInfo.getFullName());
        info.setMobile(baseInfo.getMobile());
        info.setAvatar(baseInfo.getAvatar());
        info.setRoles(roles);
        return info;
    }

}
