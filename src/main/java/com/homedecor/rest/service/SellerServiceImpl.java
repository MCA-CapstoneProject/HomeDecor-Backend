package com.homedecor.rest.service;


import com.homedecor.rest.common.exceptions.CustomDataIntegrityViolationException;
import com.homedecor.rest.common.exceptions.RecordNotFoundException;
import com.homedecor.rest.common.messages.BaseResponse;
import com.homedecor.rest.common.messages.CustomMessage;
import com.homedecor.rest.dto.SellerDto;
import com.homedecor.rest.entity.Seller;
import com.homedecor.rest.repo.SellerDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SellerServiceImpl implements SellerService{

    @Autowired
    private SellerDao sellerDao;

    public List<SellerDto> getAllSellers() {
        return sellerDao.findAllSellers().stream().map(this::copyEntityToDto).collect(Collectors.toList());
    }

    public SellerDto findBySellerId(Long sellerId) {
        if (sellerDao.existsById(sellerId)) {
            Seller seller = sellerDao.findBySellerId(sellerId);
            return copyEntityToDto(seller);
        } else {
            throw new RecordNotFoundException(CustomMessage.DOESNOT_EXIT + sellerId);
        }
    }

    public BaseResponse createOrUpdateSeller(SellerDto sellerDto) {
        try {
            Seller seller = copyDtoToEntity(sellerDto);
            sellerDao.save(seller);
        } catch (DataIntegrityViolationException ex) {
            throw new CustomDataIntegrityViolationException(ex.getCause().getCause().getMessage());
        }
        return new BaseResponse(CustomMessage.USER_SAVE_SUCCESS_MESSAGE);
    }

    public BaseResponse deleteSellerById(Long sellerId) {
        if (sellerDao.existsById(sellerId)) {
            sellerDao.deleteById(sellerId);
        } else {
            throw new RecordNotFoundException(CustomMessage.NO_RECOURD_FOUND + sellerId);
        }
        return new BaseResponse(CustomMessage.USER_DELETE_SUCCESS_MESSAGE);

    }

    @Override
    public SellerDto findByUserNameAndPassword(String userName,String email, String password) {

        Seller seller = sellerDao.findByUserNameOrEmail(userName,email);
        if (seller != null) {
            return copyEntityToDto(seller);
        } else {
            throw new RecordNotFoundException("Invalid username or password");
        }
    }

    @Override
    public boolean existsByUsername(String username) {
        return sellerDao.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return sellerDao.existsByEmail(email);
    }

    private SellerDto copyEntityToDto(Seller seller) {
        SellerDto sellerDto = new SellerDto();
        BeanUtils.copyProperties(seller, sellerDto);
        return sellerDto;
    }

    private Seller copyDtoToEntity(SellerDto sellerDto) {
        Seller seller = new Seller();
        BeanUtils.copyProperties(sellerDto, seller);
        return seller;
    }

}
