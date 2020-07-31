package com.definesys.dao;

import com.definesys.pojo.MdbMovie;
import com.definesys.pojo.MdbMovieTag;
import java.math.BigDecimal;

public interface MdbMovieTagMapper {
    void addMovie(MdbMovieTag movie);

    int updateMovie(MdbMovieTag movie);

    void delete(String id);
}