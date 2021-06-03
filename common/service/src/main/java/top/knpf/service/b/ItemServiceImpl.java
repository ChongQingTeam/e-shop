package top.knpf.service.b;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.knpf.dao.b.ItemMapper;
import top.knpf.domain.b.input.ItemBO;
import top.knpf.domain.b.output.ItemDto;
import top.knpf.model.b.Item;

import java.util.List;

@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements IItemService {

    @Autowired
    ItemMapper mapper;

    @Override
    public List<ItemDto> conditionList(ItemBO bo) {
        int pageIndex = bo.getPageIndex();
        int pageSize = bo.getPageSize();
        int startPageNum = (pageIndex - 1) * pageSize;
        return mapper.conditionList(bo, startPageNum);
    }

    @Override
    public int countList(ItemBO bo) {
        int pageIndex = bo.getPageIndex();
        int pageSize = bo.getPageSize();
        int startPageNum = (pageIndex - 1) * pageSize;
        return mapper.countList(bo);
    }
}
