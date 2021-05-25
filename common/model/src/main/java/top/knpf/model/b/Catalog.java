package top.knpf.model.b;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("e_item_catalog")
public class Catalog {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    @TableField("parent_id")
    private int parentId;
    @TableField("name")
    private String name;
    @TableField("status")
    private int status;
    @TableField("sort_order")
    private int sortOrder;
    @TableField("is_parent")
    private int isParent;
    @TableField("icon")
    private String icon;
    @TableField("remark")
    private String remark;
    @TableField("created")
    private Date created;
    @TableField("updated")
    private Date updated;
}
