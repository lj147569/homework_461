package com.definesys.dao.impl;

import com.definesys.dao.MdbMovieMapper;
import com.definesys.mpaas.query.MpaasQueryFactory;
import com.definesys.pojo.MdbActor;
import com.definesys.pojo.MdbMovie;
import com.definesys.pojo.MovieStar;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class MdbMovieMapperImpl implements MdbMovieMapper {
    @Resource
    private MpaasQueryFactory sw;

    @Override
    public void addMovie(MdbMovie movie) {
         sw.buildQuery().doInsert(movie);
    }

    @Override
    public int updateMovie(MdbMovie movie) {
        int a=sw.buildQuery()
                .rowid("id",String.valueOf(movie.getId()))
                .doUpdate(movie);
        return a;
    }

    @Override
    public void delete(String id) {
        sw.buildQuery()
                .rowid("id", id)
                .doDelete(MdbMovie.class);
    }

    @Override
    public List<MovieStar> findById( String id) {
       return sw.buildViewQuery("find_score")
                .like("id",id)
                .doQuery(MovieStar.class);
    }
}
