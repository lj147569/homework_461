package com.definesys.service;

import java.math.BigDecimal;
import java.util.List;

import com.definesys.pojo.MdbMovie;
import com.definesys.pojo.MovieStar;

public interface MdbMovieService{

    void addMovie(MdbMovie movie);

    int updateMovie(MdbMovie movie);

    void delete(String id);

    List<MovieStar> findById(String id);


}
