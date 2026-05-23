package edu.freelance.booking.Controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.freelance.booking.Dto.ItemDto;
import edu.freelance.booking.Models.Item;
import edu.freelance.booking.Repositories.ItemRepository;
import edu.freelance.booking.Services.ItemService;

@Controller
public class ItemController {

    private ItemRepository itemRepository;
    private ItemService itemService;


    public ItemController(ItemRepository repo, ItemService service) {
        itemRepository = repo;
        itemService = service;
    }

    @GetMapping("/items")
    public String getAll(Model data) {
        List<Item> items = itemRepository.findAll();
        data.addAttribute("items", items);
        return "item/items";
    }

    @GetMapping("/item/add")
    public String formItem(Model data) {
        data.addAttribute("item", new Item());
        return "item/add";
    }

    @PostMapping("/items/save")
    public String saveItem(@ModelAttribute ItemDto item) {
        item.setActive(true);
        itemService.AddItem(item);
        //itemRepository.save(item);
        return "redirect:/items";
    }

    @GetMapping("/items/edit/{id}")
    public String editItem(@PathVariable Long id, Model data) {
        Item item = itemRepository.findById(id).orElseThrow();
        data.addAttribute("item", item);
        return "item/add";
    }

    @GetMapping("/items/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        Item item = itemRepository.findById(id).orElseThrow();
        item.setActive(false);
        itemRepository.save(item);
        return "redirect:/items";
    }

    @GetMapping("/items/restore/{id}")
    public String restoreItem(@PathVariable Long id) {
        Item item = itemRepository.findById(id).orElseThrow();
        item.setActive(true);
        itemRepository.save(item);
        return "redirect:/items";
    }
}