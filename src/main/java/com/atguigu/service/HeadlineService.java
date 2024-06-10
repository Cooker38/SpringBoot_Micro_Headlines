package com.atguigu.service;

import com.atguigu.Pojo.Headline;
import com.atguigu.Pojo.Vo.PortalVo;
import com.atguigu.Utils.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 25692
* @description 针对表【news_headline】的数据库操作Service
* @createDate 2024-06-08 21:05:10
*/
public interface HeadlineService extends IService<Headline> {

    Result findNewPage(PortalVo portalVo);

    Result showHeadlineDetail(Integer hid);

    Result publish(String token, Headline headline);

    Result findHeadlineByHid(Integer hid);

    Result update(Headline headline);
}
