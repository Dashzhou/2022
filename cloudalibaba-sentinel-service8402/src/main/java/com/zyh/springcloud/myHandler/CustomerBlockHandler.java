package com.zyh.springcloud.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import zyh.springcloud.entities.CommonResult;

/**
 *
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException e) {
        return new CommonResult(444, "客服错误处理");
    }

    public static CommonResult handlerException2(BlockException e) {
        return new CommonResult(444, "客服错误处理");
    }
}
