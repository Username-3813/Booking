package edu.freelance.booking.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.freelance.booking.Models.User;
import edu.freelance.booking.Repositories.UserRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class SessionController {

    private UserRepository userRepository;

    public SessionController(UserRepository repo) {
        userRepository = repo;
    }
    

    @GetMapping("/login") 
        public String loginForm(HttpSession session, Model data) {
            String username = (String)session.getAttribute("username");
            if (username != null) {
                data.addAttribute("username", username);
                return "redirect:/profile";
            }
            return "auth/login";
    }
    
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model data, HttpSession session) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                //session.setAttribute("id", user.getId());
                session.setAttribute("username", user.getName());
                session.setMaxInactiveInterval(60);
                return "redirect:/profile";
            } else {
                data.addAttribute("error", "Неверный логин и/или пароль!");
            }

        } else {
        data.addAttribute("error", "Пользователь не найден!");
        }
        return "auth/login";
    }

    @GetMapping("/profile")
    public String profile(HttpSession session, Model data) {
        //String id = (String)session.getAttribute("id");
        String username = (String)session.getAttribute("username");
        if (username != null) {
            data.addAttribute("username", username);
            return "user/profile";
        }
        return "redirect:/login";
    }
    
}
