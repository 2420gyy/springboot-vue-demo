package com.chen.managesystem.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.managesystem.common.Result;
import com.chen.managesystem.entity.Course;
import com.chen.managesystem.mapper.CourseMapper;
import com.chen.managesystem.service.ICourseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chenchen
 * @since 2021-12-11
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Resource
    private ICourseService iCourseService;

    // TODO 换掉
    @Resource
    private CourseMapper courseMapper;

    @PostMapping
    public Result<?> save(@RequestBody Course Course) {
        iCourseService.save(Course);
        return Result.success();
    }

    @PutMapping
    public Result<?> update(@RequestBody Course Course) {
        iCourseService.updateById(Course);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Integer id) {
        iCourseService.removeById(id);
        return Result.success();
    }

    @PostMapping("/deleteBatch")
    public Result<?> deleteBatch(@RequestBody List<Integer> ids) {
        courseMapper.deleteBatchIds(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<?> getById(@PathVariable Integer id) {
        return Result.success(courseMapper.selectById(id));
    }

    /**
     * 注意：这个方法使用的是Mybatis sql的方式做的多表联合查询，大家可以点开，参考下怎么写多表查询
     * @param //userId
     * @return
     */
    // @GetMapping("/{userId}")
    // public Result<?> getByUserId(@PathVariable Integer userId) {
    //     return Result.success(iCourseService.findByUserId(userId));
    // }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search) {
        LambdaQueryWrapper<Course> wrapper = Wrappers.<Course>lambdaQuery();
        if (StrUtil.isNotBlank(search)) {
            wrapper.like(Course::getName, search);
        }
        Page<Course> CoursePage = courseMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(CoursePage);
    }
}

