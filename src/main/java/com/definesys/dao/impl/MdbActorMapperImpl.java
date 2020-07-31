package com.definesys.dao.impl;

import com.definesys.dao.MdbActorMapper;
import com.definesys.mpaas.query.MpaasQueryFactory;
import com.definesys.pojo.Actor;
import com.definesys.pojo.MdbActor;
import com.definesys.pojo.MdbMovieActorRel;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class MdbActorMapperImpl implements MdbActorMapper {
    @Resource
    private MpaasQueryFactory sw;

    @Override
    public void add(MdbActor actor) {
        sw.buildQuery().doInsert(actor);
    }

    @Override
    public int delete(String id) {
        int a=sw.buildQuery()
                .rowid("id", id)
                .doDelete(MdbActor.class);
        sw.buildQuery()
                .eq("actor_id",id)
                .doDelete(MdbMovieActorRel.class);
       return a;
    }



    @Override
    public int update(MdbActor actor) {
        int a=sw.buildQuery()
                .rowid("id",String.valueOf(actor.getId()))
                .doUpdate(actor);
        return a;
    }

    @Override
    public List<Actor> findByName(MdbActor actor) {
        List<Actor> table = sw.buildViewQuery("find_actor")
                .or()
                .like("name",actor.getName())
                .like("pinyin",actor.getPinyin())
                .doQuery(Actor.class);
        return table;
    }


}
