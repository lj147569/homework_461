package com.definesys.service;

import java.math.BigDecimal;
import com.definesys.pojo.MdbMovieTag;
public interface MdbMovieTagService{

    void addMovie(MdbMovieTag movie);

    int updateMovie(MdbMovieTag movie);

    void delete(String id);


}
