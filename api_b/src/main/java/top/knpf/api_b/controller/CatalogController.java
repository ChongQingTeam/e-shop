package top.knpf.api_b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.knpf.domain.b.input.CatalogBO;
import top.knpf.domain.b.output.BaseResult;
import top.knpf.model.b.Catalog;
import top.knpf.service.b.ICatalogService;

import java.util.List;

@RestController
@RequestMapping("/b/catalog")
public class CatalogController {

    @Autowired
    ICatalogService catalogService;

    @GetMapping("/list")
    BaseResult<Object> list(@RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
                            @RequestParam(value = "pageIndex", defaultValue = "1", required = false) int pageIndex){
        BaseResult<Object> result = new BaseResult<>();
        List<Catalog> list = catalogService.list();
        return result.renderSuccess(list);
    }

    @GetMapping("/delete")
    BaseResult<Boolean> delete(@RequestParam List<Integer> ids){
        BaseResult<Boolean> result = new BaseResult<>();
        Boolean flag = catalogService.batchDelete(ids);
        return result.renderSuccess(flag);
    }

    @PostMapping("/add_or_update")
    BaseResult<Boolean> add(@RequestBody CatalogBO catalogBO){
        BaseResult<Boolean> result = new BaseResult<>();
        Boolean flag = false;
        if(catalogBO.getId() == null){
            flag = catalogService.add(catalogBO);
        }else {
            flag = catalogService.updateSelf(catalogBO);
        }
        return result.renderSuccess(flag);
    }
}
