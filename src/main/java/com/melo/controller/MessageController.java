package com.melo.controller;

import com.melo.pojo.Admin;
import com.melo.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Ablert
 * on 2018/5/11.
 * @author Ablert
 */
@Controller
public class MessageController {

    @Autowired
    private IAdminService adminService;

    /**
     * 直接返回字符串
     * @return
     */
    @RequestMapping(value = "/")
    @ResponseBody
    public String index() {
        return "hello mello";
    }

    /**
     * 进入hello页面
     * @return
     */
    @RequestMapping(value = "entryHello")
    public String entryHello() {
        return "hello";
    }

    /**
     * 持久化用户
     * @param admin
     * @return
     */
    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    @ResponseBody
    public int InsertAdmin(Admin admin) {
        return adminService.insertAdmin(admin);
    }

    /**
     * 获取admin
     * @param id
     * @return
     */
    @RequestMapping(value = "/admin/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Admin getAdmin(@PathVariable Integer id) {
        return adminService.getAdmin(id);
    }
}
