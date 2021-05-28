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
import java.util.stream.Collectors;

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

    @GetMapping("/list")
    BaseResult<List<CatalogDTO>> get(){
        BaseResult<List<CatalogDTO>> result = new BaseResult<>();
        List<Catalog> catalogs = catalogService.list();
        List<CatalogDTO> resultDto = buildDto(catalogs);
        return result.renderSuccess(resultDto);
    }

    private List<CatalogDTO> buildDto(List<Catalog> catalogs) {
        List<Catalog> list =
                catalogs.stream().filter(item -> item.getIsParent() == 1 && item.getParentId() == 0).collect(Collectors.toList());
        List<CatalogDTO> catalogDTOs = buildTreeData(list, catalogs);
        return catalogDTOs;
    }

    private List<CatalogDTO> buildTreeData(List<Catalog> collect, List<Catalog> list) {
        List<CatalogDTO> dtos = new ArrayList<>();
        collect.stream().forEach(item -> {
            CatalogDTO catalogDTO = new CatalogDTO();
            catalogDTO.setId(item.getId());
            catalogDTO.setName(item.getName());
            catalogDTO.setSortOrder(item.getSortOrder());
            catalogDTO.setIcon(item.getIcon());
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
