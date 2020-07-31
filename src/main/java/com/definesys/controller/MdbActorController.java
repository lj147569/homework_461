package com.definesys.controller;

import com.definesys.mpaas.common.exception.MpaasBusinessException;
import com.definesys.mpaas.common.http.Response;
import com.definesys.mpaas.query.annotation.RowID;
import com.definesys.pojo.Actor;
import com.definesys.pojo.MdbActor;
import com.definesys.service.MdbActorService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/actor")
public class MdbActorController {
    @Resource
    MdbActorService service;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Response add(MdbActor actor){
        service.add(actor);
        return Response.ok();
    }


    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public Response delete(@RequestParam(value = "rowId") String id){
        if(service.delete(id)==0){
            throw new MpaasBusinessException("删除失败");
        }
        return Response.ok();
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Response update(@RequestBody  MdbActor mdbActor){
        if(service.update(mdbActor)==0){
            throw new MpaasBusinessException("修改失败");
        }
        return Response.ok();
    }

    @RequestMapping(value = "/findByName",method = RequestMethod.GET)
    public Response findByName(MdbActor actor){
       List<Actor> list=service.findByName(actor);
        return Response.ok().table(list);
    }
}
