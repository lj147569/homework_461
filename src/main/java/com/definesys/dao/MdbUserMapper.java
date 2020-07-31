package com.definesys.dao;

import com.definesys.mpaas.query.MpaasQueryFactory;
import com.definesys.pojo.MdbUser;
import org.springframework.stereotype.Repository;


import java.math.BigDecimal;
import java.util.List;

public interface MdbUserMapper {
    /**
     * 用户注册
     * @param user 用户对象
     */
    void register(MdbUser user);

    /**
     * 验证用户昵称，手机号是否存在
     * @param phone 电话号码
     * @param nickname 昵称
     */
    int validate(String phone,String nickname);

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

    //void delete(Integer id);

}