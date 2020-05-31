package com.cumt.guli.constant;


import lombok.Getter;

/**
 * @description: 返回枚举类
 * @author: liuxiaosong
 * @Date: 2020/5/5
 * @version: 1.0
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(true,200,"成功"),
    UNKNOWN_REASON(false,201,"未知错误"),
    BAD_SQL_GRAMAR(false,210,"sql语法错误"),
    JSON_PARSE_ERROR(false,220,"json解析异常"),
    PARAM_ERROR(false,230,"参数不正确"),
    FILE_UPLOAD_ERROR(false,240,"文件上传错误"),
    EXCEL_DATA_IMPORT_ERROR(false,250,"Excel数据导入错误");

    private Boolean success; //是否响应成功

    private Integer code; //返回码

    private String message; //返回消息

    ResultCodeEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
