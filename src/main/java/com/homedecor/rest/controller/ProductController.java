package com.homedecor.rest.controller;

import com.homedecor.rest.common.messages.BaseResponse;
import com.homedecor.rest.dto.ProductMasterDto;
import com.homedecor.rest.dto.WishlistDto;
import com.homedecor.rest.dto.WishlistProductDTO;
import com.homedecor.rest.entity.ProductMaster;
import com.homedecor.rest.entity.Wishlist;
import com.homedecor.rest.service.ProductMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;


@RestController
@RequestMapping("/secured/product")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductMasterService productMasterService;

    @GetMapping(value = "/getAllProduct")
    public ResponseEntity<List<ProductMasterDto>> getAllProduct() {
        List<ProductMasterDto> list = productMasterService.getAllProduct();
        return new ResponseEntity<List<ProductMasterDto>>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/getProductByUserId")
    public ResponseEntity<List<ProductMasterDto>> getProductByUserId(@NotNull(message = "userId can't be null") @RequestParam Long userid) {

        List<ProductMasterDto> list = productMasterService.getProductByUserId(userid);
        return new ResponseEntity<List<ProductMasterDto>>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/get/by-id")
    public ResponseEntity<ProductMasterDto> getUserById(@NotNull(message = "Id can't be null") @RequestParam Long id) {
        ProductMasterDto list = productMasterService.findByProductId(id);
        return new ResponseEntity<ProductMasterDto>(list, HttpStatus.OK);
    }

    @PostMapping(value = {"/add", "/update"})
    public ResponseEntity<BaseResponse> createOrUpdateProduct(@RequestBody ProductMasterDto productMasterDto) {
        BaseResponse response = productMasterService.createOrUpdateProduct(productMasterDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<BaseResponse> deleteUserById(@PathVariable("id") Long id) {
        BaseResponse response = productMasterService.deleteProductById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping(value = {"/addWishlistProduct"})
    public ResponseEntity<Wishlist> saveWishlist(@RequestBody WishlistDto wishlistDto) {
        Wishlist savedWishlist = productMasterService.saveWishlist(wishlistDto);
        return ResponseEntity.ok(savedWishlist);
    }

    @GetMapping(value = "/getWishlistProduct")
    public ResponseEntity<List<WishlistProductDTO>> getWishlistProductsByUserId(@NotNull(message = "userId can't be null") @RequestParam Long userId) {
        List<WishlistProductDTO> wishlistProducts = productMasterService.getWishlistProductsByUserId(userId);
        return ResponseEntity.ok(wishlistProducts);
    }
    @DeleteMapping("/deleteWishlistProduct")
    public ResponseEntity<String> deleteWishlistByProductId(@NotNull(message = "productId can't be null") @RequestParam Long productId) {
        productMasterService.deleteWishlistByProductId(productId);
        return ResponseEntity.ok("Wishlist items for product with ID " + productId + " deleted.");
    }
}
