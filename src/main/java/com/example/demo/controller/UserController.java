package com.example.demo.controller;

import com.example.demo.Application;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.demo.common.LoadUserResponse;
import com.example.demo.common.BaseResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

import org.springframework.validation.annotation.Validated;

import java.util.Date;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(Application.class);

    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public BaseResponse addUser(@RequestBody @Validated User user, BindingResult bindingResult) {
        logger.info(user.getUserName());
        logger.info(user.getPassword());
        BaseResponse baseResponse = new BaseResponse();

        if (bindingResult.hasErrors()) {//表单验证，报错
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            baseResponse.setResult("1");
            baseResponse.setMsg(bindingResult.getFieldError().getDefaultMessage());
            return baseResponse;
        }
        user.setCreateTime(new Date());
        user.setModifyTime(new Date());
        userService.addUser(user);
        logger.info("刚插入的主键: "+user.getId());
        baseResponse.setResult("0");
        baseResponse.setMsg("success");

        return baseResponse;
    }

    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return userService.findAllUser(pageNum, pageSize);
    }

    @RequestMapping(value = "/load/{id}", produces = {"application/json;charset=UTF-8"})
    public LoadUserResponse loadUser(@PathVariable("id") int id) {
        User u = userService.loadUser(id);
        LoadUserResponse resp = new LoadUserResponse();
        resp.setResult("0");
        resp.setMsg("success");
        resp.setData(u);

        return resp;
    }
    /**
     * 使用@RestController时，则使用ModelAndView显示页面
     * @param map
     * @return
     */
    @RequestMapping(value = "/list",method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView index(ModelMap map) {
        ModelAndView mv = new ModelAndView("user/list");
        map.addAttribute("name","赵老师");
        return mv;
    }
}
