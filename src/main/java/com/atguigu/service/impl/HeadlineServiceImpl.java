package com.atguigu.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.atguigu.Pojo.User;
import com.atguigu.Pojo.Vo.PortalVo;
import com.atguigu.Utils.JwtHelper;
import com.atguigu.Utils.Result;
import com.atguigu.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.Pojo.Headline;
import com.atguigu.service.HeadlineService;
import com.atguigu.mapper.HeadlineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
* @author 25692
* @description 针对表【news_headline】的数据库操作Service实现
* @createDate 2024-06-08 21:05:10
*/
@Service
public class HeadlineServiceImpl extends ServiceImpl<HeadlineMapper, Headline>
    implements HeadlineService{
    @Autowired
    private HeadlineMapper headlineMapper;
    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Result findNewPage(PortalVo portalVo) {
        LambdaQueryWrapper<Headline> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(!StringUtils.isEmpty(portalVo.getKeyWords()),Headline::getTitle,portalVo.getKeyWords())
                .eq(portalVo.getType()!= null,Headline::getType,portalVo.getType());

        IPage<Headline> page=new Page<>(portalVo.getPageNum(), portalVo.getPageSize());
        headlineMapper.selectPageMap(page,portalVo);
        Map<String,Object> pageData=new HashMap<>();
        pageData.put("pageData",page.getRecords());
        pageData.put("pageNum",portalVo.getPageNum());
        pageData.put("pageSize",portalVo.getPageSize());
        pageData.put("totalpage",page.getPages());
        pageData.put("totalsize",page.getTotal());
        Map<String,Object> pageDataMap=new HashMap<>();
        pageDataMap.put("pageInfo",pageData);
        return Result.ok(pageDataMap);
    }

    @Override
    public Result showHeadlineDetail(Integer hid) {
        Map headlinemap = headlineMapper.selectDatailMap(hid);
        Headline headlineDetail = new Headline();
        headlineDetail.setPageViews((Integer) headlinemap.get("pageViews")+1);
        headlineDetail.setHid(hid);
        headlineDetail.setVersion((Integer) headlinemap.get("version"));
        headlineMapper.updateById(headlineDetail);
        Map<String,Object> headline = new HashMap<>();
        headline.put("headline", headlinemap);
        return Result.ok(headline);
    }

    @Override
    public Result publish(String token, Headline headline) {
        String userId= String.valueOf(jwtHelper.getUserId(token));
        headline.setPublisher(Integer.valueOf(userId));
        headline.setPageViews(0);
        headline.setCreateTime(new Date());
        headline.setUpdateTime(new Date());
        headlineMapper.insert(headline);
        return Result.ok(null);
    }

    @Override
    public Result findHeadlineByHid(Integer hid) {
        Headline headline=headlineMapper.selectById(hid);
        Map map = new HashMap();
        map.put("headline", headline);

        return Result.ok(map);
    }

    @Override
    public Result update(Headline headline) {
        int i;
        headline.setUpdateTime(new Date());
        headline.setVersion(headline.getVersion());
        i=headlineMapper.updateById(headline);
        if(i==0){
            return Result.build(null,507,"更新失败");
        }else {
            return Result.ok(null);
        }
    }
}




