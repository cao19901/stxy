package com.bootdo.clouddoadmin.controller;


import com.bootdo.clouddoadmin.dto.FlowPackageDTO;
import com.bootdo.clouddoadmin.service.FlowPackageService;
import com.bootdo.clouddocommon.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author 曹晓维
 */
@RestController
@Slf4j
@RequestMapping("/flowPackage")
public class FlowPackageController extends BaseController {

    @Autowired
    private FlowPackageService flowPackageService ;

    @GetMapping
    public PageInfo<FlowPackageDTO> list(@RequestParam Map<String, Object> params) {
        // 设置分页
        PageHelper.offsetPage(PageUtils.getOffset(params),PageUtils.getLimit(params));
        List<FlowPackageDTO> list = flowPackageService.list();
        return new PageInfo<>(list);
    }





}
