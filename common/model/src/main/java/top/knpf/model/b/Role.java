package top.knpf.model.b;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("sys_role")
public class Role {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    @TableField("role_name")
    private String roleName;
    @TableField("role_desc")
    private String roleDesc;
    @TableField("is_delete")
    private int isDelete;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;
}
