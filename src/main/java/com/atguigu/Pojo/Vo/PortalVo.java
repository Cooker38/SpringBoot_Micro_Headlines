package com.atguigu.Pojo.Vo;

import lombok.Data;

/**
 * ClassName: PotalVo
 * Package: com.atguigu.Pojo.Vo
 * Description:
 *
 * @Author :Cooker38
 * @Create 2024/6/9 22:48
 * @Version 1.0
 * "keyWords":"马斯克", // 搜索标题关键字
 *     "type":0,           // 新闻类型
 *     "pageNum":1,        // 页码数
 *     "pageSize":10     // 页大小
 */
@Data
public class PortalVo {
    private String KeyWords;
    private Integer type=0;
    private Integer pageNum=0;
    private Integer pageSize=10;
}
