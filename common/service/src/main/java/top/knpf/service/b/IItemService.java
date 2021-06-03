package top.knpf.service.b;

import com.baomidou.mybatisplus.extension.service.IService;
import top.knpf.domain.b.input.ItemBO;
import top.knpf.domain.b.output.ItemDto;
import top.knpf.model.b.Item;

import java.util.List;

public interface IItemService extends IService<Item> {

    List<ItemDto> conditionList(ItemBO bo);

    int countList(ItemBO bo);
}
