package com.bwf.shop.custom.service.impl;

import com.bwf.shop.custom.bean.po.UserAddress;
import com.bwf.shop.custom.mapper.UserAddressMapper;
import com.bwf.shop.custom.service.IUserAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * UserAddress 客户收货信息 业务逻辑层 实现类
 * */
@Service
public class UserAddressService implements IUserAddressService {

    // 依赖的数据访问层
    @Resource
    private UserAddressMapper userAddressMapper;

    @Override
    public boolean addUserAddress(UserAddress userAddress) {
        return userAddressMapper.addUserAddress(userAddress) > 0;
    }

    @Override
    public boolean updateUserAddress(UserAddress userAddress) {
        return userAddressMapper.updateUserAddress(userAddress) > 0;
    }

    @Override
    public boolean deleteUserAddress(Integer id) {
        return userAddressMapper.deleteUserAddress(id) > 0;
    }

    @Override
    public List<UserAddress> getUserAddressByUserId(Integer user_id) {
        return userAddressMapper.getUserAddressByUserId(user_id);
    }
}
