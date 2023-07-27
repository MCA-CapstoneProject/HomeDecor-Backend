package com.homedecor.rest.service;

import com.homedecor.rest.common.messages.BaseResponse;
import com.homedecor.rest.dto.SellerDto;

import java.util.List;

public interface SellerService {

    List<SellerDto> getAllSellers();

    SellerDto findBySellerId(Long sellerId);

    BaseResponse createOrUpdateSeller(SellerDto sellerDto);

    BaseResponse deleteSellerById(Long sellerId);

    SellerDto findByUserNameAndPassword(String userName,String email, String password);


    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
