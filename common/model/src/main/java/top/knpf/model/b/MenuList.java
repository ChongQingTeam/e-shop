package top.knpf.model.b;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class MenuList {

    private int id;
    private String authName;
    private String path;
    private List<MenuList> children;
    private String order;
}
