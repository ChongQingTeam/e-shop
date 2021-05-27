package top.knpf.api_b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.knpf.domain.b.input.CatalogBO;
import top.knpf.domain.b.output.BaseResult;
import top.knpf.domain.b.output.CatalogDTO;
import top.knpf.model.b.Catalog;
import top.knpf.service.b.ICatalogService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/b/catalog")
public class CatalogController {

    @Autowired
    ICatalogService catalogService;

    Map<String, List<Catalog>> localCache = new HashMap<>();


    @GetMapping("/list")
    BaseResult<List<CatalogDTO>> list(@RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
                                @RequestParam(value = "pageIndex", defaultValue = "1", required = false) int pageIndex){
        BaseResult<List<CatalogDTO>> result = new BaseResult<>();
        List<Catalog> list = localCache.get("Catalogs");
        if(list == null || list.size() <= 0){
            list = catalogService.list();
            localCache.put("Catalogs", list);
        }
        List<CatalogDTO> resultDto = buildDto(list);
        List<CatalogDTO> collect = resultDto.stream().skip((pageIndex - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
        return result.renderSuccess(collect, resultDto.size());
    }

    @GetMapping("/delete")
    BaseResult<Boolean> delete(@RequestParam Integer id){
        BaseResult<Boolean> result = new BaseResult<>();
        Boolean flag = catalogService.delete(id);
        if(flag){
            localCache.remove("Catalogs");
        }
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
        if(flag){
            localCache.remove("Catalogs");
        }
        return result.renderSuccess(flag);
    }


    private List<CatalogDTO> buildDto(List<Catalog> list) {
        List<Catalog> collect = list.stream().filter(item -> item.getIsParent() == 1 && item.getParentId() == 0).collect(Collectors.toList());
        List<CatalogDTO> catalogDTOs = buildTreeData(collect, list);
        return catalogDTOs;
    }

    private List<CatalogDTO> buildTreeData(List<Catalog> collect, List<Catalog> list) {
        List<CatalogDTO> dtos = new ArrayList<>();
        collect.stream().forEach(item -> {
            CatalogDTO catalogDTO = new CatalogDTO();
            catalogDTO.setId(item.getId());
            catalogDTO.setName(item.getName());
            catalogDTO.setStatus(item.getStatus());
            catalogDTO.setSortOrder(item.getSortOrder());
            catalogDTO.setIcon(item.getIcon());
            catalogDTO.setRemark(item.getRemark());
            catalogDTO.setIsParent(item.getIsParent());
            catalogDTO.setParentId(item.getParentId());
            List<Catalog> nextCollect =
                    list.stream().filter(next -> next.getParentId() == item.getId()).collect(Collectors.toList());
            if(nextCollect != null && nextCollect.size() > 0) {
                List<CatalogDTO> childrenDTOs = buildTreeData(nextCollect, list);
                catalogDTO.setChildren(childrenDTOs);
            }

            dtos.add(catalogDTO);
        });
        return dtos;
    }
}
