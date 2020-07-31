package com.definesys.service;

import java.math.BigDecimal;
import java.util.List;

import com.definesys.pojo.MdbUser;
public interface MdbUserService{

     /**
      * 用户注册
      * @param user 用户对象
      */
     void register(MdbUser user);


     /**
      * 用户登录
      * @param user 用户对象
      * @return 返回用户信息
      */
     MdbUser login(MdbUser user);

     /**
      * 返回用户所有信息(除密码）
      * @param id 用户id
      * @return 返回id所对应得用户
      */
     List<MdbUser> findAll(Integer id);

}
