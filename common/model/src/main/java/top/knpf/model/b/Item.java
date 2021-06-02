package top.knpf.model.b;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@TableName("e_item")
public class Item {

    @TableId(value = "id", type = IdType.INPUT)
    private String id;
    @TableField("title")
    private String title;
    @TableField("sell_point")
    private String sellPoint;
    @TableField("price")
    private BigDecimal price;
    @TableField("num")
    private int num;
    @TableField("limit_num")
    private int limitNum;
    @TableField("image")
    private List<String> image;
    @TableField("cid")
    private int cid;
    @TableField("status")
    private int status;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;
}
