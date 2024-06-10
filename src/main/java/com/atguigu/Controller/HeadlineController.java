package com.atguigu.Controller;

import com.atguigu.Pojo.Headline;
import com.atguigu.Utils.Result;
import com.atguigu.service.HeadlineService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: HeadlineController
 * Package: com.atguigu.Controller
 * Description:
 *
 * @Author :Cooker38
 * @Create 2024/6/10 13:56
 * @Version 1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/headline")
public class HeadlineController {
    @Autowired
    private HeadlineService headlineService;

    @RequestMapping("/publish")
    public Result publish(@RequestHeader String token, @RequestBody Headline headline) {
        Result result = headlineService.publish(token, headline);
        return result;
    }
    @RequestMapping("/findHeadlineByHid")
    public Result findHeadlineByHid(@Param("hid") Integer hid){
        Result result=headlineService.findHeadlineByHid(hid);
        return result;
    }

    @RequestMapping("/update")
    public Result update( @RequestBody Headline headline) {
        Result result = headlineService.update(headline);
        return result;
    }
    @PostMapping("removeByHid")
    public Result removeById(Integer hid){
        headlineService.removeById(hid);
        return Result.ok(null);
    }



}
