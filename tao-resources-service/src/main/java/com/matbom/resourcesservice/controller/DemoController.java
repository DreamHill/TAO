package com.matbom.resourcesservice.controller;

import com.matbom.exception.IllegalPropertiesException;
import com.matbom.exception.NullOrEmptyException;
import com.matbom.exception.SessionNotFoundException;
import com.matbom.utils.IdWorker;
import com.matbom.utils.ResponseResult;
import com.matbom.xxhglresourcesservice.service.DemoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private DemoService demoService ;
    @ApiOperation(value="测试接口", notes="测试接口")// 使用该注解描述接口方法信息
    @ApiImplicitParams({@ApiImplicitParam(name = "mobile", value = "传入的示例手机号", required = true, dataType = "String",paramType = "form")})
    @RequestMapping(value="/getDemoStr",method =RequestMethod.GET)
    @ResponseBody
    public ResponseResult getDemoStr(@RequestParam String mobile){
        return ResponseResult.buildSuccess("Id:"+idWorker.nextId()+"手机号："+mobile);
    }
    @ApiOperation(value="查询集合数据", notes="查询集合数据")// 使用该注解描述接口方法信息
    @RequestMapping(value="/selectAllUser",method =RequestMethod.GET)
    @ResponseBody
    public ResponseResult selectAllUser(){
        return ResponseResult.buildSuccess(demoService.selectAll());
    }
    @ApiOperation(value="测试验证异常接口", notes="测试验证异常接口")// 使用该注解描述接口方法信息
    @ApiImplicitParams({@ApiImplicitParam(name = "type", value = "传入的异常类型", required = true, dataType = "Integer",paramType = "form")})
    @RequestMapping(value="/testException",method =RequestMethod.GET)
    @ResponseBody
    public ResponseResult testException(@RequestParam Integer type) throws Exception{
        switch (type){
            case 2:
                throw new SessionNotFoundException();
            case 3:
                throw new NullOrEmptyException();
            case 4:
                throw new IllegalPropertiesException();
        }
        return null;
    }
}
