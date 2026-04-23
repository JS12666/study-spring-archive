package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>();
    private static long sequence = 0L;

    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id){
        return store.get(id);
    }

    public List<Item> findAll(){
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        /* 실제 설계에서는 updateParam용 Item클래스를 새로 만들어서 사용하는게 낫다.
            왜냐하면 같은 Item 클래스를 사용하면 상품을 수정할 때 사용하지 않는 변수(Ex. id)같은 경우에도
            set, get 메서드가 존재하기 떄문에 다른 개발자가 사용하지 않는 이유에 혼란을 받을 수 있기 때문 */
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore(){
        store.clear();
    }
}
