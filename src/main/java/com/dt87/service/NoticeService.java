package com.dt87.service;

import com.dt87.entity.Notice;

import java.util.Date;
import java.util.List;

public interface NoticeService {
/**
 * @description:
 * @author: Mr.HuHang
 * @create: 2020-02-24 15:48
 **/
      //公告
      public List<Notice> findAllNotice(Notice notice);
      //公告加分页
      //public List<Notice> findAllNoticePage(Integer page,Integer limit,Notice notice);
      public List<Notice> findAllNoticePage(Integer page, Integer limit, String title, Date startTime,Date endTime);
      //公告加分页对应的总条数
      public int  findAllNoticePageCount(Integer page, Integer limit, String title, Date startTime,Date endTime);
      //根据id删除功能
      public int deleteNoticeById(int id);
      //添加公告
      public int addNotice(Notice notice);
      //修改公告
      public int updateNotice(Notice notice);
}
