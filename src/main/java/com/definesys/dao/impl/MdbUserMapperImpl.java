package com.definesys.dao.impl;

import com.definesys.dao.MdbUserMapper;
import com.definesys.mpaas.common.exception.MpaasBusinessException;

import com.definesys.mpaas.query.MpaasQueryFactory;
import com.definesys.mpaas.query.util.MD5Util;
import com.definesys.pojo.MdbUser;
import org.springframework.stereotype.Repository;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class MdbUserMapperImpl implements MdbUserMapper{
    @Resource
    private MpaasQueryFactory sw;

    /**
     * 用户注册
     * @param user 用户对象
     */
    public void register(MdbUser user) {
        user.setPassword(DigestUtils.md5DigestAsHex((user.getPassword()).getBytes()));
        sw.buildQuery().doInsert(user);
    }
    /**
     * 验证用户昵称，手机号是否存在
     * @param phone 电话号码
     * @param nickname 昵称
     */
    @Override
    public int validate(String phone, String nickname) {
        List<MdbUser> table = sw.buildQuery()
                .or()
                .eq("phone", phone)
                .eq("nickname", nickname).doQuery(MdbUser.class);
        return table.size();
    }
    /**
     * 用户登录
     * @param user 用户对象
     * @return 返回用户信息
     */
    @Override
    public MdbUser login(MdbUser user) {
        /*String pwd=DigestUtils.md5DigestAsHex((user.getPassword()).getBytes());*/
        List<MdbUser> list=sw.buildQuery()
                .eq("account",user.getAccount())
                .doQuery(MdbUser.class);
        if(list.size()==0){
            throw new MpaasBusinessException("用户不存在");
        }
        return list.get(0);
    }
    /**
     * 返回用户所有信息(除密码）
     * @param id 用户id
     * @return 返回id所对应得用户
     */
    @Override
    public List<MdbUser> findAll(Integer id) {
        List<MdbUser> list=sw.buildQuery()
                .select("id,account,phone,nickname,role,avatar")
                .eq("id",id)
                .doQuery(MdbUser.class);
        return list;
    }


}
