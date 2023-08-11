package com.homedecor.rest.service;

import com.homedecor.rest.common.exceptions.CustomDataIntegrityViolationException;
import com.homedecor.rest.common.exceptions.RecordNotFoundException;
import com.homedecor.rest.common.messages.BaseResponse;
import com.homedecor.rest.common.messages.CustomMessage;
import com.homedecor.rest.dto.ProductImagesDto;
import com.homedecor.rest.dto.ProductMasterDto;
import com.homedecor.rest.entity.ProductImages;
import com.homedecor.rest.entity.ProductMaster;
import com.homedecor.rest.repo.ProductImagesDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductImagesServiceImpl implements ProductImagesService {
    @Autowired
    ProductImagesDao productImagesDao;

    @Override
    public List<ProductImagesDto> getAllProductImages() {
        return productImagesDao.findAllProductImages().stream().map(this::copyEntityToDto).collect(Collectors.toList());
    }

    @Override
    public ProductImagesDto findByProductImagesId(Long id) {
        if (productImagesDao.existsById(id)) {
            ProductImages productImages = productImagesDao.findById(id);
            return copyEntityToDto(productImages);
        } else {
            throw new RecordNotFoundException(CustomMessage.DOESNOT_EXIT + id);
        }
    }

    @Override
    public BaseResponse deleteProductImagesById(Long id) {
        if (productImagesDao.existsById(id)) {
            productImagesDao.deleteById(id);
        } else {
            throw new RecordNotFoundException(CustomMessage.NO_RECOURD_FOUND + id);
        }
        return new BaseResponse(CustomMessage.USER_DELETE_SUCCESS_MESSAGE);
    }

    @Override
    public BaseResponse createOrUpdateProductImages(ProductImagesDto productImagesDto) {
        try {
            ProductImages productImagesMaster = copyDtoToEntity(productImagesDto);
            productImagesDao.save(productImagesMaster);
        } catch (DataIntegrityViolationException ex) {
            throw new CustomDataIntegrityViolationException(ex.getCause().getCause().getMessage());
        }
        return new BaseResponse(CustomMessage.PRODUCTIMAGES_SAVE_SUCCESS_MESSAGE);
    }

    private ProductImagesDto copyEntityToDto(ProductImages productImages) {
        ProductImagesDto productImagesDto = new ProductImagesDto();
        BeanUtils.copyProperties(productImages, productImagesDto);
        if (productImages.getProductMaster()!= null) {
            ProductMasterDto productMasterDto = new ProductMasterDto();
            productMasterDto.setProductId(productImages.getProductMaster().getProductId());
            productMasterDto.setProductName(productImages.getProductMaster().getProductName());
            productImagesDto.setProductMasterDto(productMasterDto);
        }

        return productImagesDto;
    }

    private ProductImages copyDtoToEntity(ProductImagesDto productImagesDto) {
        ProductImages productImages = new ProductImages();
        BeanUtils.copyProperties(productImagesDto, productImages);
        if (productImagesDto.getProductMasterDto() != null) {
            ProductMaster productMaster = new ProductMaster();
            productMaster.setProductId(productImagesDto.getProductMasterDto().getProductId());
            productMaster.setProductName(productImagesDto.getProductMasterDto().getProductName());
            productImages.setProductMaster(productMaster);
        }
        return productImages;
    }

}
