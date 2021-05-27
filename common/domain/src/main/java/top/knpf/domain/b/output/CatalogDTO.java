package top.knpf.domain.b.output;

import lombok.Data;

import java.util.List;

@Data
public class CatalogDTO {
    private int id;
    private String name;
    private int status;
    private int sortOrder;
    private String icon;
    private String remark;
    private int parentId;
    private int isParent;
    private List<CatalogDTO> children;
}
