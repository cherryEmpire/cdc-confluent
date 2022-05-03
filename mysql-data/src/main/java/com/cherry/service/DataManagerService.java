package com.cherry.service;

import com.cherry.common.dtos.CommonResult;

import java.util.List;

/**
 * @Author : 翁鑫豪
 * @Date : 2022/1/30 16:32
 * @Description: DataManagerService
 */
public interface DataManagerService {

    public CommonResult<List> listData(int page, int size);

    public CommonResult<String> initData();

}
