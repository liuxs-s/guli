package com.cumt.guli.exception;

import com.cumt.guli.constant.ResultCodeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 自定义异常类
 * @author: liuxiaosong
 * @Date: 2020/5/5
 * @version: 1.0
 * 这里继承RuntimeException 是因为RuntimeException 是非检查异常，直接throw出来就行了
 * 而Exception， throw出来之后，要不捕获，要不然还得继续往上抛，它是一个检查异常
 */
@Data
public class GuliException extends RuntimeException{
    @ApiModelProperty(value = "状态码")
    private Integer code;


    public GuliException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public GuliException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "GuliException{" +
                "code=" + code +
                ",message" + this.getMessage()+
                '}';
    }
}

