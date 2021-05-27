package top.knpf.service.b;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
        catalog.setId(catalogBO.getId());
        catalog.setParentId(catalogBO.getParentId());
        catalog.setName(catalogBO.getName());
        catalog.setStatus(catalogBO.getStatus());
        catalog.setSortOrder(catalogBO.getSortOrder());
        catalog.setIsParent(catalogBO.getIsParent());
        catalog.setIcon(catalogBO.getIcon());
        catalog.setRemark(catalogBO.getRemark());
        return catalogMapper.updateById(catalog)>0?true:false;
    }

    @Override
    public Boolean delete(Integer id) {
        Catalog catalog = catalogMapper.selectById(id);
        catalog.setStatus(0);
        int count = catalogMapper.updateById(catalog);
        return count>0?true:false;
    }

    @Override
    public List<Catalog> getNavCatalog() {
        LambdaQueryWrapper<Catalog> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Catalog::getParentId,0);
        wrapper.eq(Catalog::getStatus, 1);
        wrapper.ne(Catalog::getId, -1);
        wrapper.orderByAsc(Catalog::getSortOrder);
        return catalogMapper.selectList(wrapper);
    }
}
