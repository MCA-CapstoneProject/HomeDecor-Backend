package com.homedecor.rest.service;

import com.homedecor.rest.common.messages.BaseResponse;
import com.homedecor.rest.dto.ProductImagesDto;

import java.util.List;

public interface ProductImagesService {
    List<ProductImagesDto> getAllProductImages();

    ProductImagesDto findByProductImagesId(Long id);

    BaseResponse createOrUpdateProductImages(ProductImagesDto productImagesMasterDto);

    BaseResponse deleteProductImagesById(Long id);
}
