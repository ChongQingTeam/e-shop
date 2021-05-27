package top.knpf.api_b.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.knpf.domain.b.input.CatalogBO;
import top.knpf.domain.b.output.BaseResult;
import top.knpf.model.b.Role;
import top.knpf.service.b.IRoleService;

import java.util.List;

@RestController
@RequestMapping("/b/role")
public class RoleController {

    @Autowired
    IRoleService roleService;

    /**
     * 查询所有角色
     * @return
     */
    @GetMapping(value = "/list")
    BaseResult<List<Role>> getRoleList(){
        BaseResult<List<Role>> result = new BaseResult<>();
        List<Role> roleList = roleService.list();
        return result.renderSuccess(roleList);
    }

    /**
     * 增加角色
     * @param Role
     * @return
     */
    @PostMapping("/role")
    BaseResult<Boolean> add(@RequestBody Role Role){
        BaseResult<Boolean> result = new BaseResult<>();
        Boolean flag = false;
        flag = roleService.save(Role);
        return result.renderSuccess(flag);
    }

    /**
     * 根据id删除角色
     * @param id
     * @return
     */
    @DeleteMapping("/role/{id}")
    BaseResult<Boolean> deleteRoleById(@PathVariable int id){
        BaseResult<Boolean> result = new BaseResult<>();
        Boolean flag = false;
        flag = roleService.removeById(id);
        return result.renderSuccess(flag);
    }

    /**
     * 根据id查询角色
     * @param id
     * @return
     */
    @GetMapping("/role/{id}")
    BaseResult<Role> getRoleById(@PathVariable int id){
        BaseResult<Role> result = new BaseResult<>();
        Role role = roleService.getById(id);
        return result.renderSuccess(role);
    }

    @PutMapping("/role/{id}")
    BaseResult<Boolean> updateRoleById(@RequestBody Role role, @PathVariable("id") int id){
        BaseResult<Boolean> result = new BaseResult<>();
        role.setId(id);
        boolean flag = roleService.updateById(role);
        if(flag){
            return result.renderSuccess();
        }
        return result.renderError();
    }
}
