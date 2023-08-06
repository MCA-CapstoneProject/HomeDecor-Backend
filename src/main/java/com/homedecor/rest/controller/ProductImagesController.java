package com.homedecor.rest.controller;

import com.homedecor.rest.common.messages.BaseResponse;
import com.homedecor.rest.dto.ProductImagesDto;
import com.homedecor.rest.service.ProductImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;


@RestController
@RequestMapping("/secured/ProductImages")
@CrossOrigin(origins = "*")
public class ProductImagesController {

    @Autowired
    private ProductImagesService productImagesService;

    @GetMapping(value = "/getAllProductImages")
    public ResponseEntity<List<ProductImagesDto>> getAllProductImages() {
        List<ProductImagesDto> list = productImagesService.getAllProductImages();
        return new ResponseEntity<List<ProductImagesDto>>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/get/by-id")
    public ResponseEntity<ProductImagesDto> getUserById(@NotNull(message = "Id can't be null") @RequestParam Long id) {
        ProductImagesDto list = productImagesService.findByProductImagesId(id);
        return new ResponseEntity<ProductImagesDto>(list, HttpStatus.OK);
    }

    @PostMapping(value = {"/add", "/update"})
    public ResponseEntity<BaseResponse> createOrUpdateProductImages(@RequestBody ProductImagesDto ProductImagesMasterDto) {
        BaseResponse response = productImagesService.createOrUpdateProductImages(ProductImagesMasterDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<BaseResponse> deleteUserById(@PathVariable("id") Long id) {
        BaseResponse response = productImagesService.deleteProductImagesById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
