package top.knpf.service.b;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.knpf.dao.b.ItemMapper;
import top.knpf.model.b.Item;

@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements IItemService {
}
