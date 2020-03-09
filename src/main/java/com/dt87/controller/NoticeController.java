package com.dt87.controller;

import com.dt87.entity.JsonData;
import com.dt87.entity.Notice;
import com.dt87.entity.User;
import com.dt87.service.impl.NoticeServiceImpl;
import com.dt87.vo.NoticeVo;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {
    /**
     * @description:
     * @author: Mr.HuHang
     * @create: 2020-02-24 15:46
     **/

    private Log log = LogFactory.getLog(NoticeController.class);


    @Autowired
    @Resource
    private NoticeServiceImpl noticeService;


    /**
     * 全查询
     *
     * @param
     * @return
     */
    //公告
    @RequestMapping("/loadAllNotice")
    @ResponseBody
    public JsonData loadAllNotice(Notice notice) {
        return JsonData.buildSuccess(noticeService.findAllNotice(notice), 0);
    }

    //系统公告带分页
    @RequestMapping("/findAllNoticePage")
    @ResponseBody
    public String findAllNoticePage(Integer page, Integer limit, String title, String startTime, String endTime) throws ParseException {
        /*System.out.println(title);
        System.out.println(startTime);
        System.out.println(endTime);*/

        Date startTime1 = null;
        Date endTime1 = null;
        if (startTime != null && startTime != "") {
            startTime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startTime);
        }
        if (endTime != null && endTime != "") {
            endTime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endTime);
        }
        System.out.println("***********************************");
       /* System.out.println(startTime1 instanceof Date);
        System.out.println(endTime1 instanceof Date);*/
        JSONObject jsonObject = new JSONObject();
        int start = (page - 1) * limit;
        jsonObject.put("code", 0);
        jsonObject.put("msg", "");
        jsonObject.put("count", noticeService.findAllNoticePageCount(start, limit, title, startTime1, endTime1));
        jsonObject.put("data", noticeService.findAllNoticePage(start, limit, title, startTime1, endTime1));
       /* return JsonData.buildSuccess(jsonObject.toString(),0);*/
        return jsonObject.toString();
    }

    //删除公告(单条)
    @RequestMapping("/deleteNotice")
    @ResponseBody
    public JsonData deleteNoticeById(int id) {
        return JsonData.buildSuccess(noticeService.deleteNoticeById(id), 0);
    }

    //批量删除公告
    @RequestMapping("/deleteSelectNotice")
    @ResponseBody
    public JsonData deleteSelectNotice(String params) {
        //System.out.println(params);
        String[] ids = params.split(",");
        for (int i = 0; i < ids.length; i++) {
            noticeService.deleteNoticeById(Integer.parseInt(ids[i]));
        }
        return JsonData.buildSuccess(0);
    }

    //添加公告
    @RequestMapping("/addNotice")
    @ResponseBody
    public JsonData addNotice(Notice notice, HttpSession session) {
        User user = (User) session.getAttribute("user");
        String opername = user.getName();
        notice.setOpername(opername);
        //System.out.println("******"+opername);
        notice.setCreatetime(new Date());
        try {
            int i = noticeService.addNotice(notice);
            if(i>0){
                return JsonData.buildSuccess(null,"添加成功");
                /*默认code就是0*/
            }else {
                return JsonData.buildError("添加失败",-1);
            }
        } catch (Exception e) {
            return JsonData.buildError("添加失败",-1);
        }
    }
    //修改公告
    @RequestMapping("/updateNotice")
    @ResponseBody
    public JsonData updateNotice(Notice notice){
        System.out.println(notice);
        if(notice.getTitle()!=null&&notice.getTitle()!=""&&notice.getContent()!=null&&notice.getContent()!=""){
            try {
                noticeService.updateNotice(notice);
                return JsonData.buildSuccess(null,"修改成功");
            }catch (Exception e){
                return JsonData.buildError("修改失败",-1);
            }
        }else {
            return JsonData.buildError("标题或内容不能为空",-1);
        }
    }
}
