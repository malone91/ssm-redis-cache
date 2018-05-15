package com.melo.service;

import com.melo.pojo.Admin;

/**
 * Created by Ablert
 * on 2018/5/12.
 * @author Ablert
 */
public interface IAdminService {

    /**
     * 获取用户
     * @param id
     * @return
     */
    public Admin getAdmin(int id);

    /**
     * 插入用户
     * @param admin
     * @return
     */
    public int insertAdmin(Admin admin);
}
