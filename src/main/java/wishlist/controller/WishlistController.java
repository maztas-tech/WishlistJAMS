package wishlist.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wishlist.model.Wishlist;
import wishlist.service.WishlistService;

@Controller
@RequestMapping("wish_list")
public class WishlistController {
    private WishlistService wishlistService;
    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @GetMapping("")
    public ResponseEntity<String>helloMessage(){
        String msg = wishlistService.helloWorld();
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }


}
