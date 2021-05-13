package top.knpf.dao.b;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.knpf.model.b.sys.Admin;

import java.util.List;

@Mapper
public interface SysAdminMapper extends BaseMapper<Admin> {

    List<String> listAdminRoles(@Param("adminId") int adminId);
}
