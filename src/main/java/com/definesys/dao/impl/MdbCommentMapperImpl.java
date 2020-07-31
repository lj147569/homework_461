package com.definesys.dao.impl;

import com.definesys.dao.MdbCommentMapper;
import com.definesys.mpaas.query.MpaasQueryFactory;
import com.definesys.pojo.MdbComment;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Repository
public class MdbCommentMapperImpl implements MdbCommentMapper {
    @Resource
    private MpaasQueryFactory sw;
    @Override
    public BigDecimal comment(MdbComment comment) {
        System.out.println(comment.getMovieId());
        sw.buildQuery().doInsert(comment);
       return (BigDecimal)sw.buildQuery()
                .sql("select avg(star)score from mdb_comment where movie_id="+comment.getMovieId())
                .doQuery().get(0).get("SCORE");
    }
}
