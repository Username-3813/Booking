package edu.freelance.booking.Controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.freelance.booking.Models.Item;
import edu.freelance.booking.Repositories.ItemRepository;

@Controller
public class HomeController {

    private ItemRepository itemRepository;

    public HomeController(ItemRepository repo) {
        itemRepository = repo;
    }

    @GetMapping("/")
    public String home(Model data) {
        List<Item> items = itemRepository.findByActiveTrue();
        data.addAttribute("items", items);
        return "/home/index";
    }
}