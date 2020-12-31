package com.bwf.shop.custom.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.bwf.shop.custom.bean.po.User;
import com.bwf.shop.custom.mapper.UserMapper;
import com.bwf.shop.custom.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.sql.Date;

/**
 * User客户资源 业务逻辑层 实现类
 * */
@Service
public class UserService implements IUserService {

    // 依赖的数据访问层
    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional( rollbackFor = Exception.class )
    public boolean regist(User user) {

        // 验证 用户填写的 手机号码 和 电子邮箱 是否已经被注册
        if( userMapper.getUserByUsername( user.getUser_phone() ) != null ||
                userMapper.getUserByUsername( user.getUser_email() ) != null ){
            // 用户填写的 手机号码 或 电子邮箱  已经被注册了
            return false;
        }else{
            // 用户填写的 手机号码 和 电子邮箱  没有被注册  开始用户注册流程
            // 对 用户填写的密码 进行 md5 加密
            String pwd = DigestUtils.md5DigestAsHex( user.getUser_password().getBytes()  );
            // 使用 用户手机号码 作为 盐值
            String salt = DigestUtils.md5DigestAsHex( user.getUser_phone().getBytes() );
            user.setUser_salt( salt );
            // 对 用户密码 加盐 md5 加密
            user.setUser_password( DigestUtils.md5DigestAsHex( (pwd + salt).getBytes() ) );
            // 设置 默认安全等级
            user.setUser_securitylevel(2);
            // 设置 默认性别
            user.setUser_gender(0);
            // 设置 默认状态
            user.setUser_status( (byte)0 );
            // 设置 注册来源
            user.setUser_createfrom(0);
            // 设置 创建时间
            user.setCreatetime(new Date(System.currentTimeMillis()));
            // 添加用户到数据库
            int a = userMapper.addUser(user);
            return a > 0;
        }
    }

    @Override
    @Transactional( rollbackFor = Exception.class )
    public User login(String username, String password) {

        // 根据用户填写的账户名称 获取 用户对象
        User user = userMapper.getUserByUsername( username );

        // 判断 该 用户对象 是否存在
        if( user != null ){
            // 该 账户名称 的 用户对象 存在
            // 验证 密码是否正确
            // 将 用户填写的密码 进行 md5 加密
            password = DigestUtils.md5DigestAsHex( password.getBytes() );
            // 将 用户填写的密码 加盐 md5 加密
            password = DigestUtils.md5DigestAsHex( (password+user.getUser_salt()).getBytes() );
            // 验证 加密后的用户填写的密码 是否和 该账户名称 账户的密码 相同
            if( password.equals( user.getUser_password() ) ){
                // 用户填写的密码 正确
                // 为 当前登录的 用户 签发 token 令牌
                String token = JWT.create()
                        .withAudience( user.getId().toString() )   // 令牌的客户标识
                        .withIssuedAt( new java.util.Date(System.currentTimeMillis()) ) // 令牌的签发时间 有效期的开始时间
                        .withExpiresAt( new java.util.Date( System.currentTimeMillis() + 24*60*1000 ) ) // 令牌的到期时间 有效期的结束时间
                        .sign(Algorithm.HMAC256( user.getUser_password() ));
                // 设置 用户的 令牌
                user.setUser_token( token );
                // 设置 用户的 令牌到期时间
                user.setUser_expiretime( new Date( System.currentTimeMillis() + 24*60*1000 ) );
                // 设置 用户的 最后登录时间
                user.setUser_loggedtime( new Date( System.currentTimeMillis()) );
                // 当前登录的用户对象的信息修改 同步修改到数据库
                userMapper.updateUser(user);

            }else{
                // 用户密码填写错误 登录失败
                user = null;
            }
        }

        return user;
    }
}
