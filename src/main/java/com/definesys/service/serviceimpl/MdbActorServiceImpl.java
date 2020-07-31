package com.definesys.service.serviceimpl;

import com.definesys.dao.MdbActorMapper;
import com.definesys.dao.impl.MdbUserMapperImpl;
import com.definesys.pojo.Actor;
import com.definesys.pojo.MdbActor;
import com.definesys.service.MdbActorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MdbActorServiceImpl implements MdbActorService {

    @Resource
    private MdbActorMapper mdbActorMapper;

    @Override
    public void add(MdbActor actor) {
        mdbActorMapper.add(actor);
    }

    public int delete(String id) {
       return  mdbActorMapper.delete(id);
    }

    @Override
    public int update(MdbActor actor) {
        return mdbActorMapper.update(actor);
    }

    @Override
    public List<Actor> findByName(MdbActor actor) {
        return mdbActorMapper.findByName(actor);
    }


}
