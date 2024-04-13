package wishlist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import wishlist.service.WishlistService;

@Controller
@RequestMapping("wish_list_frontpage")
public class WishlistController {
    private WishlistService wishlistService;
    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @GetMapping("")
    public String wishListFrontpage(Model model) {
        model.addAttribute("wishlist",wishlistService.showAllWIshlists());
        return "wish_list_frontpage";
    }

    @GetMapping("/{wishName}/wish")
    public String wishItem(@PathVariable String wishName, Model model) {
        model.addAttribute("wishName", wishlistService.showWishes(wishName));
        return "wish";
    }






}
