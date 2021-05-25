package top.knpf.dao.b;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.knpf.model.b.Catalog;

import java.util.List;

@Mapper
public interface CatalogMapper extends BaseMapper<Catalog> {

    int batchDelete(@Param("ids") List<Integer> ids);
}
