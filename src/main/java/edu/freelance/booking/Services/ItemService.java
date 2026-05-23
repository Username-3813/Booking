package edu.freelance.booking.Services;

import org.springframework.stereotype.Service;

import edu.freelance.booking.Dto.ItemDto;
import edu.freelance.booking.Models.Item;
import edu.freelance.booking.Repositories.ItemRepository;
import edu.freelance.booking.Utils.ImageUtil;

@Service
public class ItemService {
    private ItemRepository itemRepository;
    public ItemService(ItemRepository itemRepository){
        this.itemRepository=itemRepository;
    }

    public Item AddItem(ItemDto item) {
        Item newItem;
        if (item.getId() == 0) {
            newItem = new Item();
        } else {
            newItem = itemRepository.getReferenceById(item.getId());
        }
        newItem.setId(item.getId());
        newItem.setTitle(item.getTitle());
        newItem.setDuration(item.getDuration());
        newItem.setPrice(item.getPrice());
        newItem.setInfo(item.getInfo());
        newItem.setActive(item.isActive());
        
        if (item.getCover() != null && !item.getCover().isEmpty()) {
            ImageUtil util = new ImageUtil();
            String cover = util.UploadImage(item.getCover());
            newItem.setCover("/images/" + cover);
        }
        return itemRepository.save(newItem);
    }
}
