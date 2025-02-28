package cerlace.tastetrack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    /**
     * Перенаправляет на начальную страницу.
     *
     * @return редирект на начальную страницу.
     */
    @GetMapping("/")
    public String redirectToHomePage() {
        return "redirect:/users";
    }
}
