package top.knpf.api_b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
}
