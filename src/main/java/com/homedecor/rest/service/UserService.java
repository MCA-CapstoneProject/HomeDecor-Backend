package com.homedecor.rest.service;

import java.util.List;
import java.util.stream.Collectors;

import com.homedecor.rest.common.exceptions.CustomDataIntegrityViolationException;
import com.homedecor.rest.common.exceptions.RecordNotFoundException;
import com.homedecor.rest.common.messages.BaseResponse;
import com.homedecor.rest.common.messages.CustomMessage;
import com.homedecor.rest.entity.User;
import com.homedecor.rest.repo.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.homedecor.rest.dto.UserDto;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<UserDto> getAllUsers() {
        return userRepo.findAll().stream().map(this::copyEntityToDto).collect(Collectors.toList());
    }

    public UserDto findByUserId(Long userId) {
        if (userRepo.existsById(userId)) {
            User user = userRepo.findByUserId(userId);
            return copyEntityToDto(user);
        } else {
            throw new RecordNotFoundException(CustomMessage.DOESNOT_EXIT + userId);
        }
    }

    public BaseResponse createOrUpdateUser(UserDto userDto) {
        try {
            User user = copyDtoToEntity(userDto);
            userRepo.save(user);
        } catch (DataIntegrityViolationException ex) {
            throw new CustomDataIntegrityViolationException(ex.getCause().getCause().getMessage());
        }
        return new BaseResponse(CustomMessage.USER_SAVE_SUCCESS_MESSAGE);
    }

    public BaseResponse deleteUserById(Long userId) {
        if (userRepo.existsById(userId)) {
            userRepo.deleteById(userId);
        } else {
            throw new RecordNotFoundException(CustomMessage.NO_RECOURD_FOUND + userId);
        }
        return new BaseResponse(CustomMessage.USER_DELETE_SUCCESS_MESSAGE);

    }

    private UserDto copyEntityToDto(User user) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    private User copyDtoToEntity(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }

}
