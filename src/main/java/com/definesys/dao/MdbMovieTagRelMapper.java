package com.definesys.dao;

import com.definesys.pojo.MdbMovieTagRel;
import java.math.BigDecimal;

public interface MdbMovieTagRelMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(MdbMovieTagRel record);

    int insertSelective(MdbMovieTagRel record);

    MdbMovieTagRel selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(MdbMovieTagRel record);

    int updateByPrimaryKey(MdbMovieTagRel record);
}