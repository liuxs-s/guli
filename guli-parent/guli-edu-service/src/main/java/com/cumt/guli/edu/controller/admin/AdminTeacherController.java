package com.cumt.guli.edu.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cumt.guli.edu.entity.Teacher;
import com.cumt.guli.edu.service.TeacherService;
import com.cumt.guli.exception.GuliException;
import com.cumt.guli.vo.R;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: TODO
 * @author: liuxiaosong
 * @Date: 2020/5/4
 * @version: 1.0
 */
@RestController
@RequestMapping("/admin/edu/teacher")
public class AdminTeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public R list(){
        List<Teacher> teacherList = teacherService.list(null);
        //return teacherList;
        return R.ok().data("items",teacherList).message("查询讲师列表成功");
    }

    @DeleteMapping("{id}")
    public R removeById(@PathVariable  String id){
        boolean result = teacherService.removeById(id);
        if(!result){
            return R.error();
        }
        return R.ok();
    }

    @GetMapping("{page}/{size}")
    public R listTeacherPage(@PathVariable Long page,@PathVariable Long size){
        if(page < 0 || size < 0){
            throw new GuliException(205,"输入参数不能为负数");
        }
        Page<Teacher> pageParam = new Page<>(page,size);
        teacherService.page(pageParam,null);
        List<Teacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return R.ok().data("total",total).data("rows",records);
    }

//    @ApiOperation(value = "分页讲师列表")
//    @GetMapping("{page}/{limit}")
//    public R pageList(
//            @ApiParam(name = "page", value = "当前页码", required = true)
//            @PathVariable Long page,
//
//            @ApiParam(name = "limit", value = "每页记录数", required = true)
//            @PathVariable Long limit){
//
//        Page<Teacher> pageParam = new Page<>(page, limit);
//
//        teacherService.page(pageParam, null);
//        List<Teacher> records = pageParam.getRecords();
//        long total = pageParam.getTotal();
//
//        return  R.ok().data("total", total).data("rows", records);
//    }
}
