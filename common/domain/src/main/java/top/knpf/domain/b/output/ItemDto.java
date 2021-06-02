package top.knpf.domain.b.output;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ItemDto {
    private String id;
    private String title;
    private String sellPoint;
    private BigDecimal price;
    private int num;
    private int limitNum;
    private List<String> image;
    private String catalog;
    private String itemDesc;
    private int status;
}
