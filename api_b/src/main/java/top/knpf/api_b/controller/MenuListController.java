package top.knpf.api_b.controller;

import jdk.nashorn.internal.ir.LiteralNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.knpf.domain.b.output.BaseResult;
import top.knpf.model.b.MenuList;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/b/menu")
public class MenuListController {

    @GetMapping("/list")
    public BaseResult<List<MenuList>> getMenuList() {
        BaseResult<List<MenuList>> b = new BaseResult<>();
        List<MenuList> rootList = new ArrayList<>();

        //用户管理
        List<MenuList> userManageNodeChild = new ArrayList<>();
        userManageNodeChild.add(new MenuList(110, "用户列表", "users", new ArrayList<>(), "null"));

        MenuList userManageNode = new MenuList(125, "用户管理", "users", userManageNodeChild, "1");
        rootList.add(userManageNode);

        //权限管理
        List<MenuList> authManageNodeChild = new ArrayList<>();
        authManageNodeChild.add(new MenuList(111, "角色列表", "roles", new ArrayList<>(), "null"));
        authManageNodeChild.add(new MenuList(112, "权限列表", "rights", new ArrayList<>(), "null"));

        MenuList authManageNode = new MenuList(103, "权限管理", "rights", authManageNodeChild, "2");
        rootList.add(authManageNode);

        //商品管理
        List<MenuList> goodsManageNodeChild = new ArrayList<>();
        goodsManageNodeChild.add(new MenuList(104, "商品列表", "goods", new ArrayList<>(), "1"));
        goodsManageNodeChild.add(new MenuList(115, "分类参数", "params", new ArrayList<>(), "2"));
        goodsManageNodeChild.add(new MenuList(121, "商品分类", "categories", new ArrayList<>(), "3"));

        MenuList goodsManageNode = new MenuList(101, "商品管理", "goods", goodsManageNodeChild, "3");
        rootList.add(goodsManageNode);

        //订单管理
        List<MenuList> orderManageNodeChild = new ArrayList<>();
        orderManageNodeChild.add(new MenuList(107, "订单列表", "orders", new ArrayList<>(), "null"));

        MenuList orderManageNode = new MenuList(102, "订单管理", "orders", orderManageNodeChild, "4");
        rootList.add(orderManageNode);


        //数据统计
        List<MenuList> reportsManageNodeChild = new ArrayList<>();
        reportsManageNodeChild.add(new MenuList(146, "数据报表", "reports", new ArrayList<>(), "null"));

        MenuList reportsManageNode = new MenuList(145, "数据统计", "reports", reportsManageNodeChild, "5");
        rootList.add(reportsManageNode);





        return b.renderSuccess("登录成功","200", rootList);
    }
}
