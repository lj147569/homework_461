package com.definesys.controller;

import com.definesys.mpaas.common.adapter.UserProfile;
import com.definesys.mpaas.common.exception.MpaasBusinessException;
import com.definesys.mpaas.common.http.Response;
import com.definesys.mpaas.query.session.MpaasSession;
import com.definesys.pojo.MdbAttachment;
import com.definesys.pojo.MdbUser;
import com.definesys.service.MdbAttachmentService;
import com.definesys.service.MdbUserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class MovieController {
    @Resource
    MdbUserService service;
    @Resource
    MdbAttachmentService services;
    /**
     * 用户注册
     * @param user 用户对象
     */
    @RequestMapping(value = "/Register",method = RequestMethod.POST)
    public Response register(MdbUser user){
         service.register(user);
         return Response.ok();
    }
    /**
     * 用户登录
     * @param user 用户对象
     */
    @RequestMapping(value = "/Login",method = RequestMethod.POST)
    public Response login( MdbUser user){
        service.login(user);
        return Response.ok().data(MpaasSession.getUserProfile());
    }
    /**
     * 用户头像上传
     * @param uploadFile 用户上传文件
     */
    @RequestMapping(value = "/FileUpload",method = RequestMethod.POST)
    @ResponseBody
    public Response upload(MultipartFile uploadFile, HttpServletRequest req){
        MdbAttachment mdbAttachment=new MdbAttachment();
        String realPath = "G://upload";
        System.out.println(realPath);
        File file = new File(realPath);
        if (!file.isDirectory()){
            file.mkdirs();
        }
        String oldName = uploadFile.getOriginalFilename();
        System.out.println(oldName);
       String path=realPath+oldName;
            try {
                uploadFile.transferTo(new File(path));
                mdbAttachment.setUuid(path);
               services.uploadImg(mdbAttachment);
            } catch (IOException e) {
                e.printStackTrace();
            }
       return Response.ok();
    }

    /**
     * 返回用户所有信息(除密码）
     * @param id 用户id
     *
     */
    @RequestMapping(value = "/findAll",method = RequestMethod.POST)
    public Response findALl( Integer id){
        if(service.findAll(id).size()==0) {
          throw new MpaasBusinessException("所查用户不存在");
        }
        return Response.ok().table(service.findAll(id));
    }

}
