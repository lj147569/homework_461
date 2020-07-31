package com.definesys.service.serviceimpl;

import com.definesys.dao.MdbAttachmentMapper;
import com.definesys.pojo.MdbAttachment;
import com.definesys.service.MdbAttachmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MdbAttachmentServiceImpl implements MdbAttachmentService {
      @Resource
    MdbAttachmentMapper mdbAttachmentMapper;
    public void uploadImg(MdbAttachment mdbAttachment) {
        mdbAttachmentMapper.uploadImg(mdbAttachment);
    }

    @Override
    public void upMovieImg(MdbAttachment mdbAttachment) {
        mdbAttachmentMapper.upMovieImg(mdbAttachment);
    }


}
