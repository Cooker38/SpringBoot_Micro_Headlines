package com.atguigu.mapper;

import com.atguigu.Pojo.Headline;
import com.atguigu.Pojo.Vo.PortalVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
* @author 25692
* @description 针对表【news_headline】的数据库操作Mapper
* @createDate 2024-06-08 21:05:10
* @Entity com.atguigu.Pojo.Headline
*/
public interface HeadlineMapper extends BaseMapper<Headline> {

    IPage<Map> selectPageMap(IPage<Headline> page,@Param("portalVo") PortalVo portalVo);
    Map selectDatailMap(Integer hid);


}




