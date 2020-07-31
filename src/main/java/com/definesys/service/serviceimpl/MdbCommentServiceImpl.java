package com.definesys.service.serviceimpl;

import com.definesys.dao.MdbCommentMapper;
import com.definesys.pojo.MdbComment;
import com.definesys.service.MdbCommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class MdbCommentServiceImpl implements MdbCommentService {
@Resource
private MdbCommentMapper commentMapper;

    @Override
    public BigDecimal comment(MdbComment comment) {
        return commentMapper.comment(comment);
    }
}
