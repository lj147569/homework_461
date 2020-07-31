package com.definesys.controller;

import com.definesys.mpaas.common.exception.MpaasBusinessException;
import com.definesys.mpaas.common.http.Response;
import com.definesys.pojo.*;
import com.definesys.service.MdbAttachmentService;
import com.definesys.service.MdbMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("movie")
public class MdnMovieController {
    @Autowired
    MdbMovieService service;
    @Autowired
    MdbAttachmentService attachmentService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Response add(MdbMovie movie ){
        service.addMovie(movie);
        return Response.ok();
    }


    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public Response delete(@RequestParam(value = "rowId") String id){
        service.delete(id);
        return Response.ok();
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Response update(@RequestBody MdbMovie movie){
        if(service.updateMovie(movie)==0){
            throw new MpaasBusinessException("修改失败");
        }
        return Response.ok();
    }

    @RequestMapping(value = "/upImg",method = RequestMethod.POST)
    @ResponseBody
    public Response upMovieImg(MultipartFile uploadFile, HttpServletRequest req){
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
            attachmentService.upMovieImg(mdbAttachment);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Response.ok();
    }

    @RequestMapping(value = "/findById",method = RequestMethod.GET)
    public Response findByName(String id){
        List<MovieStar> list=service.findById(id);
        return Response.ok().data(list.get(0));
    }
}
