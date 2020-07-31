package com.definesys.service.serviceimpl;

import com.definesys.dao.MdbMovieMapper;
import com.definesys.pojo.MdbMovie;
import com.definesys.pojo.MovieStar;
import com.definesys.service.MdbMovieService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MdbMovieServiceImpl implements MdbMovieService {

    @Resource
    private MdbMovieMapper mdbMovieMapper;


    @Override
    public void addMovie(MdbMovie movie) {
        mdbMovieMapper.addMovie(movie);
    }

    @Override
    public int updateMovie(MdbMovie movie) {
        return mdbMovieMapper.updateMovie(movie);
    }

    @Override
    public void delete(String id) {
        mdbMovieMapper.delete(id);
    }

    @Override
    public List<MovieStar> findById(String id) {
        return  mdbMovieMapper.findById(id);
    }
}
