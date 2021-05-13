package top.knpf.service.b;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.knpf.dao.b.SysAdminMapper;
import top.knpf.model.b.sys.Admin;

import javax.xml.ws.Action;
import java.util.List;

@Service
public class SysAdminServiceImpl extends ServiceImpl<SysAdminMapper, Admin> implements ISysAdminService{

    @Autowired
    SysAdminMapper adminMapper;

    @Override
    public Admin getAdminByUsername(String username) {
        LambdaQueryWrapper<Admin> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Admin::getUsername, username);
        return getOne(wrapper);
    }

    @Override
    public List<String> listAdminRoles(int adminId) {
        return adminMapper.listAdminRoles(adminId);
    }
}
