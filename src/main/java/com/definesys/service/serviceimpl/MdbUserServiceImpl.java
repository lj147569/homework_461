package com.definesys.service.serviceimpl;

import com.definesys.dao.impl.MdbUserMapperImpl;
import com.definesys.dao.impl.MovieSSOAuth;
import com.definesys.mpaas.common.exception.MpaasBusinessException;
import com.definesys.pojo.MdbUser;
import com.definesys.service.MdbUserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class MdbUserServiceImpl implements MdbUserService {

    @Resource
    private MdbUserMapperImpl mdbUserMapper;
    /**
     * 用户注册
     * @param user 用户对象
     */
  public void register(MdbUser user){
      if(mdbUserMapper.validate(user.getPhone(), user.getNickname())==0) {
          mdbUserMapper.register(user);
      }else{
          throw new MpaasBusinessException("昵称或者密码已经存在");
      }
  }
    /**
     * 用户登录
     * @param user 用户对象
     * @return 返回用户信息
     */
    @Override
    public MdbUser login(MdbUser user) {
        MovieSSOAuth.setUser(mdbUserMapper.login(user));
        return mdbUserMapper.login(user);
    }

    /**
     * 返回用户所有信息(除密码）
     * @param id 用户id
     * @return 返回id所对应得用户
     */
    @Override
    public List<MdbUser> findAll(Integer id) {
        return mdbUserMapper.findAll(id);
    }


}
