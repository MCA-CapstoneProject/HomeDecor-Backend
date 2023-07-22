package com.homedecor.rest.service;

import com.homedecor.rest.common.messages.BaseResponse;
import com.homedecor.rest.dto.ProductMasterDto;

import java.util.List;

public interface ProductMasterService {
    List<ProductMasterDto> getAllProduct();

    ProductMasterDto findByProductId(Long id);

    BaseResponse deleteProductById(Long id);

    BaseResponse createOrUpdateProduct(ProductMasterDto productMasterDto);
}
