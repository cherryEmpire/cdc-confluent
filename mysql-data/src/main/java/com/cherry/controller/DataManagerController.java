package com.cherry.controller;

import com.cherry.common.dtos.CommonResult;
import com.cherry.service.DataManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author : 翁鑫豪
 * @Date : 2022/1/30 16:32
 * @Description: DataManagerController
 */
@RestController
@RequestMapping({"/datamgr"})
public class DataManagerController {

    @Autowired
    private DataManagerService dataManagerService;

    @RequestMapping(value = {"/listData"}, method = {RequestMethod.GET})
    public CommonResult<List> listData(@RequestParam(value = "page", required = false, defaultValue = "1") String page,
                                       @RequestParam(value = "size", required = false, defaultValue = "20") String size) {

        return dataManagerService.listData(Integer.valueOf(page), Integer.valueOf(size));
    }

    @RequestMapping(value = {"/initData"}, method = {RequestMethod.GET})
    public CommonResult<String> initData() {
        return dataManagerService.initData();
    }
}
