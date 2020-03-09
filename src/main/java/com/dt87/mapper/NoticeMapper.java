package com.dt87.mapper;

import com.dt87.entity.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface NoticeMapper {
    /**
     * @description:
     * @author: Mr.HuHang
     * @create: 2020-02-24 15:41
     **/
    //查询公告
    public List<Notice> findAllNotice(@Param("notice") Notice notice);

    //查询所有公告加分页
    //public List<Notice> findAllNoticePage(@Param("page") Integer page ,@Param("limit") Integer limit,@Param("notice") Notice notice);
    public List<Notice> findAllNoticePage(@Param("page") Integer page, @Param("limit") Integer limit, @Param("title") String title, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    //查询所有公告加分页 对应的总条数
    public int findAllNoticePageCount(@Param("page") Integer page, @Param("limit") Integer limit, @Param("title") String title, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    //根据id删除功能
    public int deleteNoticeById(@Param("id") int id);
    //添加公告
    public int addNotice(@Param("notice") Notice notice);
    //修改公告
    public int updateNotice(@Param("notice") Notice notice);
}
