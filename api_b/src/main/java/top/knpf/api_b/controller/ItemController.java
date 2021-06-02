package top.knpf.api_b.controller;

import cn.hutool.core.bean.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.knpf.domain.b.output.BaseResult;
import top.knpf.domain.b.output.ItemDto;
import top.knpf.model.b.Item;
import top.knpf.service.b.IItemService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/b/item")
public class ItemController {

    @Autowired
    IItemService itemService;


    @GetMapping("/get/{id}")
    BaseResult<ItemDto> get(@PathVariable int id){
        BaseResult<ItemDto> baseResult = new BaseResult<>();
        return baseResult;
    }

    @PostMapping("/list")
    BaseResult<List<ItemDto>> list(){
        BaseResult<List<ItemDto>> baseResult = new BaseResult<>();
        List<Item> items = itemService.list();
        return baseResult.renderSuccess(toDtos(items));
    }

    @GetMapping("/delete/{id}")
    BaseResult<Boolean> delete(@PathVariable int id){
        BaseResult<Boolean> baseResult = new BaseResult<>();
        return baseResult;
    }

    @PostMapping("/add")
    BaseResult<ItemDto> add(){
        BaseResult<ItemDto> baseResult = new BaseResult<>();
        return baseResult;
    }

    private List<ItemDto> toDtos(List<Item> items) {
        List<ItemDto> dtos = new ArrayList<>();
        items.stream().forEach(item -> {
            ItemDto dto = new ItemDto();
            BeanUtil.copyProperties(item, dto);
            dtos.add(dto);
        });
        return dtos;
    }
}
