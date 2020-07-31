package com.definesys.dao;

import com.definesys.pojo.MdbMovie;
import com.definesys.pojo.MovieStar;

import java.math.BigDecimal;
import java.util.List;

public interface MdbMovieMapper {

       void addMovie(MdbMovie movie);

       int updateMovie(MdbMovie movie);

       void delete(String id);

       List<MovieStar> findById(String id);



}