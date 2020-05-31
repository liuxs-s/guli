package com.cumt.guli.handler;

import com.cumt.guli.constant.ResultCodeEnum;
import com.cumt.guli.exception.GuliException;
import com.cumt.guli.utils.ExceptionUtil;
import com.cumt.guli.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 统一异常处理器
 * @author: liuxiaosong
 * @Date: 2020/5/5
 * @version: 1.0
 */
@ControllerAdvice  //这个注解需要学习一下
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 异常处理方法
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e) {
        //e.printStackTrace(); //在控制台输出异常堆栈信息
        //log.error(e.getMessage());
        log.error(ExceptionUtil.getMessage(e));
        return R.error();
    }

    @ExceptionHandler(BadSqlGrammarException.class)
    @ResponseBody
    public R error(BadSqlGrammarException e) {
        //e.printStackTrace(); //在控制台输出异常堆栈信息
        //return R.error().code(203).message("sql错误"+e);
        //log.error(e.getMessage());
        log.error(ExceptionUtil.getMessage(e));
        return R.setR(ResultCodeEnum.BAD_SQL_GRAMAR);
    }

    @ExceptionHandler(GuliException.class)
    @ResponseBody
    public R error(GuliException e) {
        //e.printStackTrace(); //在控制台输出异常堆栈信息
        //log.error(e.getMessage());
        log.error(ExceptionUtil.getMessage(e));
        return R.error().message(e.getMessage()).code(e.getCode());
    }
}
