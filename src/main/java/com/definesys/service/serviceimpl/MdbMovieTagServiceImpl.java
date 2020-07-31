package com.definesys.service.serviceimpl;

import com.definesys.dao.MdbMovieTagMapper;
import com.definesys.mpaas.query.MpaasQueryFactory;
import com.definesys.pojo.MdbMovie;
import com.definesys.pojo.MdbMovieTag;
import com.definesys.service.MdbMovieTagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MdbMovieTagServiceImpl implements MdbMovieTagService {

    @Resource
    private MdbMovieTagMapper mdbMovieTagMapper;


    @Override
    public void addMovie(MdbMovieTag movie) {
        mdbMovieTagMapper.addMovie(movie);
    }

    @Override
    public int updateMovie(MdbMovieTag movie) {
        return mdbMovieTagMapper.updateMovie(movie);
    }

    @Override
    public void delete(String id) {
        mdbMovieTagMapper.delete(id);
    }
}
