package top.knpf.service.b;

import com.baomidou.mybatisplus.extension.service.IService;
import top.knpf.model.b.sys.Admin;

import java.util.List;

public interface ISysAdminService extends IService<Admin> {

    Admin getAdminByUsername(String username);

    List<String> listAdminRoles(int adminId);
}
