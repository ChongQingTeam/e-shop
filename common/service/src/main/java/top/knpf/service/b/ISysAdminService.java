package top.knpf.service.b;

import com.baomidou.mybatisplus.extension.service.IService;
import top.knpf.model.b.sys.Admin;

public interface ISysAdminService extends IService<Admin> {

    Admin getAdminByUsername(String username);
}
