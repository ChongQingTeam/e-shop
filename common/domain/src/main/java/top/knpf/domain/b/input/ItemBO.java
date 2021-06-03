package top.knpf.domain.b.input;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemBO {
    private String title;
    private String sellPoint;
    private BigDecimal beginPrice;
    private BigDecimal endPrice;
    private String catalog;
    private String itemDesc;
    private int pageIndex;
    private int pageSize;
}
