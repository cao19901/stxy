package com.bootdo.clouddoadmin.controller;


import com.bootdo.clouddoadmin.service.CardService;
import com.bootdo.clouddocommon.utils.R;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author 曹晓维
 *  icc 卡操作服务提供者
 */
@RestController
@Slf4j
@RequestMapping("/hellotest")
public class cardController extends BaseController {

    @Autowired
    private  CardService cardService ;

    @GetMapping("/hello")
    Object test() {
        log.debug("打印了的日志");
        return R.ok();
    }
    @GetMapping("/hello1")
    String test1() {
        log.debug("打印了的日志 hello");
        return "1111";
    }



    @GetMapping()
    Object list(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(1,10);


        List<Map<String, Object>> list = cardService.list();
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
        return pageInfo;
    }



}
