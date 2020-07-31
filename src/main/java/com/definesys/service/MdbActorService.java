package com.definesys.service;

import java.math.BigDecimal;
import java.util.List;

import com.definesys.pojo.Actor;
import com.definesys.pojo.MdbActor;
public interface MdbActorService{

    void add(MdbActor actor);

    int  delete(String id);

    int update(MdbActor actor);

    List<Actor> findByName(MdbActor actor);
}
