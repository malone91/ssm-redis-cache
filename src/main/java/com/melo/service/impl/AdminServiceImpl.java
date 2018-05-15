package com.melo.service.impl;

import com.melo.dao.AdminMapper;
import com.melo.pojo.Admin;
import com.melo.service.IAdminService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 缓存机制说明：所有的查询结果都放进了缓存，也就是把MySQL查询的结果放到了redis中去
 * 第二次发起该条查询时就可以从redis中去读取查询的结果，从而不与MySQL交互，从而达到优化的效果
 * @Cacheable("a")注解的意义就是把该方法的查询结果放到redis中去，下一次再发起查询就去redis中去取，存在redis中的数据的key就是a
 * @CacheEvict(value={"a","b"},allEntries=true) 的意思就是执行该方法后要清除redis中key名称为a,b的数据
 * Created by Ablert
 * on 2018/5/10.
 * @author Ablert
 */
@Service
public class AdminServiceImpl implements IAdminService {

    @Resource
    private AdminMapper adminMapper;

    @Cacheable("getAdmin")
    @Override
    public Admin getAdmin(int id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    /**
     * 清空缓存，allEntries变量表示所有对象的缓存都清除
     * @param admin
     * @return
     */
    @CacheEvict(value = "getAdmin", allEntries = true)
    @Override
    public int insertAdmin(Admin admin) {
        return adminMapper.insert(admin);
    }
}
