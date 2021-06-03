package top.knpf.dao.b;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.knpf.domain.b.input.ItemBO;
import top.knpf.domain.b.output.ItemDto;
import top.knpf.model.b.Item;

import java.util.List;

@Mapper
public interface ItemMapper extends BaseMapper<Item> {

    List<ItemDto> conditionList(@Param("bo") ItemBO bo,@Param("startPageNum") int startPageNum);

    int countList(@Param("bo") ItemBO bo);
}
