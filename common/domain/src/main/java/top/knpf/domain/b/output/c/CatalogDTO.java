package top.knpf.domain.b.output.c;

import lombok.Data;

import java.util.List;

@Data
public class CatalogDTO {
    private int id;
    private String name;
    private int sortOrder;
    private String icon;
    private List<CatalogDTO> children;
}
