package top.knpf.domain.b.output;

import lombok.Data;

import java.util.List;

@Data
public class AdminInfo {

    private int adminId;
    private String adminName;
    private String mobile;
    private String avatar;
    private List<String> roles;

}
