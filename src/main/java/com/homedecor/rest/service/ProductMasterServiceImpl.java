package com.homedecor.rest.service;

import com.homedecor.rest.common.exceptions.CustomDataIntegrityViolationException;
import com.homedecor.rest.common.exceptions.RecordNotFoundException;
import com.homedecor.rest.common.messages.BaseResponse;
import com.homedecor.rest.common.messages.CustomMessage;
import com.homedecor.rest.dto.BrandDto;
import com.homedecor.rest.dto.CategoryDto;
import com.homedecor.rest.dto.ProductMasterDto;
import com.homedecor.rest.dto.UserDto;
import com.homedecor.rest.entity.Brand;
import com.homedecor.rest.entity.Category;
import com.homedecor.rest.entity.ProductMaster;
import com.homedecor.rest.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductMasterServiceImpl implements ProductMasterService {
    @Autowired
    com.homedecor.rest.repo.ProductMasterDao ProductMasterDao;

    @Override
    public List<ProductMasterDto> getAllProduct() {
        return ProductMasterDao.findAllProducts().stream().map(this::copyEntityToDto).collect(Collectors.toList());
    }

    @Override
    public ProductMasterDto findByProductId(Long id) {
        if (ProductMasterDao.existsById(id)) {
            ProductMaster ProductMaster = ProductMasterDao.findById(id);
            return copyEntityToDto(ProductMaster);
        } else {
            throw new RecordNotFoundException(CustomMessage.DOESNOT_EXIT + id);
        }
    }

    @Override
    public BaseResponse deleteProductById(Long id) {
        if (ProductMasterDao.existsById(id)) {
            ProductMasterDao.deleteById(id);
        } else {
            throw new RecordNotFoundException(CustomMessage.NO_RECOURD_FOUND + id);
        }
        return new BaseResponse(CustomMessage.USER_DELETE_SUCCESS_MESSAGE);
    }

    @Override
    public BaseResponse createOrUpdateProduct(ProductMasterDto productMasterDto) {
        try {
            ProductMaster ProductMaster = copyDtoToEntity(productMasterDto);
            ProductMasterDao.save(ProductMaster);
        } catch (DataIntegrityViolationException ex) {
            throw new CustomDataIntegrityViolationException(ex.getCause().getCause().getMessage());
        }
        return new BaseResponse(CustomMessage.USER_SAVE_SUCCESS_MESSAGE);
    }

    private ProductMasterDto copyEntityToDto(ProductMaster productMaster) {
        ProductMasterDto ProductMasterDto = new ProductMasterDto();
        BeanUtils.copyProperties(productMaster, ProductMasterDto);

        if (productMaster.getCategory() != null) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setCategoryId(productMaster.getCategory().getCategoryId());
            categoryDto.setCategoryName(productMaster.getCategory().getCategoryName());
            ProductMasterDto.setCategoryDto(categoryDto);
        }
        if (productMaster.getBrand() != null) {
            BrandDto brandDto = new BrandDto();
            brandDto.setBrandId(productMaster.getBrand().getBrandId());
            brandDto.setBrandName(productMaster.getBrand().getBrandName());
            ProductMasterDto.setBrandDto(brandDto);
        }
        if (productMaster.getUserId() != null) {
            UserDto userDto = new UserDto();
            userDto.setUserId(productMaster.getUserId().getUserId());
            userDto.setUserName(productMaster.getUserId().getUserName());
            ProductMasterDto.setUserId(userDto);
        }
        return ProductMasterDto;
    }

    private ProductMaster copyDtoToEntity(ProductMasterDto productMasterDto) {
        ProductMaster productMaster = new ProductMaster();
        BeanUtils.copyProperties(productMasterDto, productMaster);
        if (productMasterDto.getCategoryDto() != null) {
            Category category = new Category();
            category.setCategoryId(productMasterDto.getCategoryDto().getCategoryId());
            productMaster.setCategory(category);
        }
        if (productMasterDto.getBrandDto() != null) {
            Brand brand = new Brand();
            brand.setBrandId(productMasterDto.getBrandDto().getBrandId());
            productMaster.setBrand(brand);
        }
        if (productMasterDto.getUserId() != null) {
            User user = new User();
            user.setUserId(productMasterDto.getUserId().getUserId());
            productMaster.setUserId(user);
        }

        return productMaster;
    }

}
