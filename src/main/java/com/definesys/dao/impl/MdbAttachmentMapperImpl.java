package com.definesys.dao.impl;

import com.definesys.dao.MdbAttachmentMapper;
import com.definesys.mpaas.query.MpaasQueryFactory;
import com.definesys.pojo.MdbAttachment;
import com.definesys.pojo.MdbUser;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
@Repository
public class MdbAttachmentMapperImpl implements MdbAttachmentMapper {
    @Resource
    private MpaasQueryFactory sw;

    @Override
    public void uploadImg(MdbAttachment mdbAttachment) {
         sw.buildQuery().doInsert(mdbAttachment);
        sw.buildQuery()
                .update("avatar",mdbAttachment.getId())
                .table("mdb_user")
                .eq("id", 10001)
                .doUpdate();
    }

    @Override
    public void upMovieImg(MdbAttachment mdbAttachment) {
        sw.buildQuery().doInsert(mdbAttachment);
    }
}
