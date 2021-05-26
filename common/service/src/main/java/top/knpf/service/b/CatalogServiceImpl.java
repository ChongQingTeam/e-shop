package top.knpf.service.b;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.knpf.dao.b.CatalogMapper;
import top.knpf.domain.b.input.CatalogBO;
import top.knpf.model.b.Catalog;

import java.util.List;

@Service
public class CatalogServiceImpl extends ServiceImpl<CatalogMapper, Catalog> implements ICatalogService{

    @Autowired
    CatalogMapper catalogMapper;

    @Override
    public Boolean batchDelete(List<Integer> ids) {
        int count = catalogMapper.batchDelete(ids);
        return count>0?true:false;
    }

    @Override
    public Boolean add(CatalogBO catalogBO) {
        Catalog catalog = new Catalog();
        catalog.setParentId(catalogBO.getParentId());
        catalog.setName(catalogBO.getName());
        catalog.setStatus(0);
        catalog.setSortOrder(catalogBO.getSortOrder());
        catalog.setIsParent(catalogBO.getIsParent());
        catalog.setIcon(catalogBO.getIcon());
        catalog.setRemark(catalogBO.getRemark());
        return catalogMapper.insert(catalog)>0?true:false;
    }

    @Override
    public Boolean updateSelf(CatalogBO catalogBO) {
        Catalog catalog = new Catalog();
        catalog.setId(catalog.getId());
        catalog.setParentId(catalogBO.getParentId());
        catalog.setName(catalogBO.getName());
        catalog.setStatus(0);
        catalog.setSortOrder(catalogBO.getSortOrder());
        catalog.setIsParent(catalogBO.getIsParent());
        catalog.setIcon(catalogBO.getIcon());
        catalog.setRemark(catalogBO.getRemark());
        return catalogMapper.updateById(catalog)>0?true:false;
    }
}
