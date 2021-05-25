package top.knpf.service.b;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.knpf.dao.b.CatalogMapper;
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
}
