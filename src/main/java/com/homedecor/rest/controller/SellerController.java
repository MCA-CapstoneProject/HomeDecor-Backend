package com.homedecor.rest.controller;

import com.homedecor.rest.common.messages.BaseResponse;
import com.homedecor.rest.dto.SellerDto;
import com.homedecor.rest.dto.UserDto;
import com.homedecor.rest.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/secured/seller")
@CrossOrigin(origins = "*")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping(value = "/getAllSellers")
    public ResponseEntity<List<SellerDto>> getAllSellers() {
        List<SellerDto> list = sellerService.getAllSellers();
        return new ResponseEntity<List<SellerDto>>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/get/by-id")
    public ResponseEntity<SellerDto> getSellerById(@NotNull(message = "Id can't be null") @RequestParam Long id) {
        SellerDto list = sellerService.findBySellerId(id);
        return new ResponseEntity<SellerDto>(list, HttpStatus.OK);
    }

    @PostMapping(value = { "/add", "/update" })
    public ResponseEntity<BaseResponse> createOrUpdateSeller(@RequestBody SellerDto sellerDto) {
        BaseResponse response = sellerService.createOrUpdateSeller(sellerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<BaseResponse> deleteSellerById(@PathVariable("id") Long id) {
        BaseResponse response = sellerService.deleteSellerById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
