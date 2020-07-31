package com.definesys.dao;

import com.definesys.pojo.MdbAttachment;
import java.math.BigDecimal;

public interface MdbAttachmentMapper {
    /**
     * 上传用户头像
     */
    void  uploadImg(MdbAttachment mdbAttachment);

    /**
     * 上传电影海报
     */
    void  upMovieImg(MdbAttachment mdbAttachment);
}