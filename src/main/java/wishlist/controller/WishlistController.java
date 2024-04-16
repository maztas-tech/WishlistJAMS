package wishlist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wishlist.model.Wishlist;
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
        model.addAttribute("wishlist", wishlistService.showAllWIshlists());
        return "wish_list_frontpage";
    }

    @GetMapping("/{wishlistID}/wishes")
    public String wishItem(@PathVariable int wishlistID, Model model) {
        model.addAttribute("wishVariable", wishlistService.showWishes(wishlistID));
        return "wishes";
    }

    @GetMapping("/{wishlistID}/edit")
    public String searchToEditWishlist(@PathVariable int wishlistID, Model model) {
        model.addAttribute("wishlist", wishlistService.searchToEdit(wishlistID));
        return "edit_wishlist_page";
    }

    @PostMapping("/edit")
    public String editWishlist(@ModelAttribute Wishlist wishlist) {
        wishlistService.editWishlist(wishlist);
        return "redirect:/wish_list_frontpage";
    }

}
