package wishlist.controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wishlist.model.Wish;
import wishlist.model.Wishlist;
import wishlist.service.WishlistService;

import java.util.List;

@Controller
@RequestMapping("wish_list_frontpage")
public class WishlistController {
    private Wishlist wishlist; //data objekt
    private Wish wish;



    private WishlistService wishlistService;
    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
        this.wishlist = new Wishlist();
        this.wish = new Wish();
    }

    @GetMapping("")
    public String wishListFrontpage(Model model) {
        model.addAttribute("wishlist", wishlistService.showAllWIshlists());
        return "wish_list_frontpage";
    }

    @GetMapping("/{wishlistID}/wishes")
    public String wishItem(@PathVariable int wishlistID, Model model) {
        model.addAttribute("wishVariable", wishlistService.showWishes(wishlistID));
        model.addAttribute("wishlistId", wishlistID);
        return "wishes";
    }

    @GetMapping("/{wishlistID}/delete")
    public String deleteWishlist(@PathVariable("wishlistID") int wishlistID){
        wishlistService.delete(wishlistID);
        return "redirect:/wish_list_frontpage";
    }
    // Create wish list
    @GetMapping("/wishlist_creation")
    public String wishItemCreationForm(Model model) {
        model.addAttribute("wishListObject", new Wishlist());
        return "wishlist_creation";
    }

    @PostMapping("/wishlist_creation")
    public String wishItemCreation(@ModelAttribute("wishListObject") Wishlist wishlist) {
        wishlistService.createWishlist(wishlist);
        return "redirect:/wish_list_frontpage";
    }

    @GetMapping("/{wishlistID}/edit")
    public String searchToEditWishlist(@PathVariable int wishlistID, Model model) {
        Wishlist wishlist = wishlistService.searchToEdit(wishlistID);
        model.addAttribute("wishlist", wishlist);
        return "edit_wishlist_form";

    }

    @PostMapping("/edit")
    public String editWishlist(@ModelAttribute Wishlist wishlist) {
        wishlistService.editWishlist(wishlist);
        return "redirect:/wish_list_frontpage";
    }

    @GetMapping("/{wishID}/remove")
    public String deleteWish(@PathVariable int wishID){
        int id = wishlistService.getListID(wishID);
        wishlistService.deleteWish(wishID);
        return "redirect:/wish_list_frontpage/"+ id + "/wishes";
    }

    @GetMapping("/{wishlistID}/edit_wish")
    public String editWishForm(@PathVariable int wishlistID, Wish wish, Model model){
        model.addAttribute("wishlistID",wishlistID);
        model.addAttribute("wish",wish);
        return "edit_wish";
    }

    @PostMapping("/edit_wish")
    public String editWish(@ModelAttribute Wish wish){
        wishlistService.editWish(wish);
        return "redirect:/wish_list_frontpage/"+ wish.getWishID() + "/wishes";
    }

    // Create wish
    @GetMapping("/{wishlistId}/wish_creation")
    public String wishCreationForm(@PathVariable int wishlistId, Model model){
        //wishlistService.getListID(wishID);
        model.addAttribute("wishlistId", wishlistId);
        model.addAttribute("wishObject", new Wish());
        return "wish_creation";
    }

    @PostMapping("/wish_creation")
    public String wishCreation(@ModelAttribute("wishObject") Wish wish){
        wishlistService.createWish(wish);

        return "redirect:/wish_list_frontpage/" + wish.getWishlistID() +"/wishes";
    }

}
