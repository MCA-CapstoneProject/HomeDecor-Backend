package com.homedecor.rest.service;

import com.homedecor.rest.common.exceptions.CustomDataIntegrityViolationException;
import com.homedecor.rest.common.exceptions.RecordNotFoundException;
import com.homedecor.rest.common.messages.BaseResponse;
import com.homedecor.rest.common.messages.CustomMessage;
import com.homedecor.rest.dto.CategoryDto;
import com.homedecor.rest.dto.UserDto;
import com.homedecor.rest.entity.Category;
import com.homedecor.rest.entity.User;
import com.homedecor.rest.repo.CategoryDao;
import com.homedecor.rest.repo.CategoryRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao categoryDao;

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryDao.findAllCategories().stream().map(this::copyEntityToDto).collect(Collectors.toList());
    }

    @Override
    public CategoryDto findByCategoryId(Long id) {
        if (categoryDao.existsById(id)) {
            Category category = categoryDao.findById(id);
            return copyEntityToDto(category);
        } else {
            throw new RecordNotFoundException(CustomMessage.DOESNOT_EXIT + id);
        }
    }

    @Override
    public BaseResponse createOrUpdateCategory(CategoryDto categoryDto) {
        try {
            Category category = copyDtoToEntity(categoryDto);
            categoryDao.save(category);
        } catch (DataIntegrityViolationException ex) {
            throw new CustomDataIntegrityViolationException(ex.getCause().getCause().getMessage());
        }
        return new BaseResponse(CustomMessage.USER_SAVE_SUCCESS_MESSAGE);
    }

    @Override
    public BaseResponse deleteCategoryById(Long id) {
        if (categoryDao.existsById(id)) {
            categoryDao.deleteById(id);
        } else {
            throw new RecordNotFoundException(CustomMessage.NO_RECOURD_FOUND + id);
        }
        return new BaseResponse(CustomMessage.USER_DELETE_SUCCESS_MESSAGE);
    }

    private CategoryDto copyEntityToDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        BeanUtils.copyProperties(category, categoryDto);
        return categoryDto;
    }

    private Category copyDtoToEntity(CategoryDto categoryDto) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto, category);
        return category;
    }
}
