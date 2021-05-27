package top.knpf.api_c.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.knpf.domain.b.output.BaseResult;
import top.knpf.domain.b.output.c.CatalogDTO;
import top.knpf.model.b.Catalog;
import top.knpf.service.b.ICatalogService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/c/catalog")
public class CatalogController {

    @Autowired
    ICatalogService catalogService;

    @GetMapping("/get_nav_catalog")
    BaseResult<List<CatalogDTO>> getNavCatalog(){
        BaseResult<List<CatalogDTO>> result = new BaseResult<>();
        List<Catalog> catalogs = catalogService.getNavCatalog();
        return result.renderSuccess(buildDTOs(catalogs));
    }

    private List<CatalogDTO> buildDTOs(List<Catalog> catalogs) {
        List<CatalogDTO> dtos = new ArrayList<>();
        catalogs.stream().forEach(item -> {
            CatalogDTO dto = new CatalogDTO();
            dto.setId(item.getId());
            dto.setName(item.getName());
            dto.setSortOrder(item.getSortOrder());
            dto.setIcon(item.getIcon());
            dtos.add(dto);
        });
        return dtos;
    }
}
