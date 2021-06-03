package top.knpf.api_b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.knpf.domain.b.input.ItemBO;
import top.knpf.domain.b.output.BaseResult;
import top.knpf.domain.b.output.ItemDto;
import top.knpf.service.b.IItemService;

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
    BaseResult<List<ItemDto>> list(@RequestBody ItemBO bo){
        BaseResult<List<ItemDto>> baseResult = new BaseResult<>();
        List<ItemDto> items = itemService.conditionList(bo);
        int count = itemService.countList(bo);
        return baseResult.renderSuccess(items, count);
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

}
