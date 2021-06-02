package top.knpf.dao.b;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.knpf.model.b.Item;

@Mapper
public interface ItemMapper extends BaseMapper<Item> {
}
