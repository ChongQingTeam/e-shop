package top.knpf.service.b;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.knpf.dao.b.RoleMapper;
import top.knpf.model.b.Role;

@Service
public class IRoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
}
