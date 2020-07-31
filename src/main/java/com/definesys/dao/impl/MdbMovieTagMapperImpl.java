package com.definesys.dao.impl;

import com.definesys.dao.MdbMovieTagMapper;
import com.definesys.mpaas.query.MpaasQueryFactory;
import com.definesys.pojo.MdbMovie;
import com.definesys.pojo.MdbMovieTag;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
@Repository
public class MdbMovieTagMapperImpl implements MdbMovieTagMapper {
    @Resource
    private MpaasQueryFactory sw;

    @Override
    public void addMovie(MdbMovieTag movie) {
        sw.buildQuery().doInsert(movie);
    }

    @Override
    public int updateMovie(MdbMovieTag movie) {
        int a=sw.buildQuery()
                .rowid("id",String.valueOf(movie.getId()))
                .doUpdate(movie);
        return a;
    }

    @Override
    public void delete(String id) {
        sw.buildQuery()
                .rowid("id", id)
                .doDelete(MdbMovieTag.class);
    }
}
