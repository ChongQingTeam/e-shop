package top.knpf.service.b;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.knpf.dao.b.SysAdminMapper;
import top.knpf.model.b.sys.Admin;

@Service
public class SysAdminServiceImpl extends ServiceImpl<SysAdminMapper, Admin> implements ISysAdminService{

    @Override
    public Admin getAdminByUsername(String username) {
        LambdaQueryWrapper<Admin> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Admin::getUsername, username);
        return getOne(wrapper);
    }
}
