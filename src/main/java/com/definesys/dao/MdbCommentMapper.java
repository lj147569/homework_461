package com.definesys.dao;

import com.definesys.pojo.MdbComment;
import java.math.BigDecimal;

public interface MdbCommentMapper {

    BigDecimal comment(MdbComment comment);
}