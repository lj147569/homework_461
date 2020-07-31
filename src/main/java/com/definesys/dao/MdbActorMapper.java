package com.definesys.dao;

import com.definesys.pojo.Actor;
import com.definesys.pojo.MdbActor;
import java.math.BigDecimal;
import java.util.List;

public interface MdbActorMapper {
        void add(MdbActor actor);

       int delete(String id);

       int update(MdbActor actor);

       List<Actor> findByName(MdbActor actor);


}