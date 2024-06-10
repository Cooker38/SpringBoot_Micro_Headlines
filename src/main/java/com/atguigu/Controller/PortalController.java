package com.atguigu.Controller;

import com.atguigu.Pojo.Type;
import com.atguigu.Pojo.Vo.PortalVo;
import com.atguigu.Utils.Result;
import com.atguigu.service.HeadlineService;
import com.atguigu.service.TypeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: PortalController
 * Package: com.atguigu.Controller
 * Description:
 *
 * @Author :Cooker38
 * @Create 2024/6/9 22:36
 * @Version 1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/portal")
public class PortalController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private HeadlineService headlineService;



    @RequestMapping("/findAllTypes")
    public Result findAllType(){
        List<Type> list=typeService.list();
        return Result.ok(list);
    }

    @RequestMapping("/findNewPage")
    public Result findNewPage(@RequestBody PortalVo portalVo){
        Result result=headlineService.findNewPage(portalVo);
        return result;
    }

    @PostMapping("/showHeadlineDetail")
    public Result showHeadlineDetail(@Param("hid") Integer hid){
        Result result=headlineService.showHeadlineDetail(hid);
        return result;
    }


}
