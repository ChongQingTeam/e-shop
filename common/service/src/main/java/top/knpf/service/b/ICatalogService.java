package top.knpf.service.b;

import com.baomidou.mybatisplus.extension.service.IService;
import top.knpf.model.b.Catalog;

import java.util.List;

public interface ICatalogService extends IService<Catalog> {
    Boolean batchDelete(List<Integer> ids);
}
