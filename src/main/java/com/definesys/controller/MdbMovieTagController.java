package com.definesys.controller;

import com.definesys.mpaas.common.exception.MpaasBusinessException;
import com.definesys.mpaas.common.http.Response;
import com.definesys.pojo.MdbMovie;
import com.definesys.pojo.MdbMovieTag;
import com.definesys.service.MdbMovieTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tag")
public class MdbMovieTagController {
    @Autowired
    private MdbMovieTagService service;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Response add(MdbMovieTag movie){
        service.addMovie(movie);
        return Response.ok();
    }


    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public Response delete(@RequestParam(value = "rowId") String id){
        service.delete(id);
        return Response.ok();
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Response update(@RequestBody MdbMovieTag movie){
        if(service.updateMovie(movie)==0){
            throw new MpaasBusinessException("修改失败");
        }
        return Response.ok();
    }
}
