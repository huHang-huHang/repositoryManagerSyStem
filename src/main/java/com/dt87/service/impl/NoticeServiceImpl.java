package com.dt87.service.impl;

import com.dt87.entity.Notice;
import com.dt87.mapper.NoticeMapper;
import com.dt87.service.NoticeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class NoticeServiceImpl implements NoticeService {
    /**
     * @description:
     * @author: Mr.HuHang
     * @create: 2020-02-24 15:48
     **/
    @Resource
    private NoticeMapper noticeMapper;
    //查询所有公告
    public List<Notice> findAllNotice(Notice notice) {

        return noticeMapper.findAllNotice(notice);
    }

    //公告加分页
    public List<Notice> findAllNoticePage(Integer page, Integer limit, String title, Date startTime, Date endTime) {
        return noticeMapper.findAllNoticePage(page, limit, title, startTime, endTime);
    }

    //公告加分页 对应总条数
    public int findAllNoticePageCount(Integer page, Integer limit, String title, Date startTime, Date endTime) {
        return noticeMapper.findAllNoticePageCount(page, limit, title, startTime, endTime);
    }



    //根据id删除公告
    @Transactional
    public int deleteNoticeById(int id) {
        return  noticeMapper.deleteNoticeById(id);
    }

    //添加公告
    public int addNotice(Notice notice) {
        return noticeMapper.addNotice(notice);
    }

    //修改公告
    public int updateNotice(Notice notice) {
        return noticeMapper.updateNotice(notice);
    }

}
