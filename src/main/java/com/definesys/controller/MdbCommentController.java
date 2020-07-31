package com.definesys.controller;

import com.definesys.mpaas.common.http.Response;
import com.definesys.pojo.MdbComment;
import com.definesys.service.MdbCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class MdbCommentController {
    @Autowired
    private MdbCommentService service;

    @RequestMapping(value = "/addComment",method = RequestMethod.POST)
    public Response addComment(MdbComment comment){
        return Response.ok().data("评分:"+service.comment(comment));
    }
}
