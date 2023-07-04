package com.homedecor.rest.service;

import com.homedecor.rest.common.messages.BaseResponse;
import com.homedecor.rest.dto.UserDto;
import com.homedecor.rest.entity.User;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto findByUserId(Long userId);
    BaseResponse createOrUpdateUser(UserDto userDto);
    BaseResponse deleteUserById(Long userId);


}
