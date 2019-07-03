package org.alan.learn.multi.controller;

import lombok.extern.slf4j.Slf4j;
import org.alan.commons.model.ResultData;
import org.alan.learn.multi.service.LogServiceHolder;
import org.alan.learn.multi.service.impl.AdminUserLogMultiService;
import org.alan.utils.ResultDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: learn-mybatis-plus
 * @ClassName: LogController
 * @description: 日志调用
 * @author: AlanMa
 * @create: 2019-05-13 11:29
 */
@Slf4j
@RestController
@RequestMapping(value = "/log")
public class LogController {

    @Autowired
    private LogServiceHolder logServiceHolder;


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResultData<String> userLog(@RequestParam(value = "type") String type,
                              @RequestParam(value = "str") String str){

        logServiceHolder.findLogService(type).logPrint(type,str);

        return ResultDataUtil.setSuccessResult(logServiceHolder.findLogService(type).test(str));
    }
}