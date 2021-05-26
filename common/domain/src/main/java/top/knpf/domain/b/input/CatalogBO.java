package top.knpf.domain.b.input;

import lombok.Data;

@Data
public class CatalogBO {

    private Integer id;
    private int parentId;
    private String name;
    private int status;
    private int sortOrder;
    //叶子节点传0
    private int isParent;
    private String icon;
    private String remark;
}
