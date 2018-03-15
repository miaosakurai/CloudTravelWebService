package com.cloudtravel.cloudtravelwebservice.controller;

import com.cloudtravel.cloudtravelwebservice.annotation.Authentication;
import com.cloudtravel.cloudtravelwebservice.bean.BaseBean;
import com.cloudtravel.cloudtravelwebservice.constants.CommonConstants;
import com.cloudtravel.cloudtravelwebservice.dto.Role;
import com.cloudtravel.cloudtravelwebservice.dto.request.SignUpRequest;
import com.cloudtravel.cloudtravelwebservice.dto.request.UserLoginRequest;
import com.cloudtravel.cloudtravelwebservice.dto.response.BaseJsonResponse;
import com.cloudtravel.cloudtravelwebservice.mapper.UserMapper;
import com.cloudtravel.cloudtravelwebservice.model.User;
import com.cloudtravel.cloudtravelwebservice.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    @Authentication(Role.User)
    public BaseJsonResponse getUserInfo() {
        System.out.println("getUserInfo()");
        User user=userMapper.selectByPrimaryKey(getToken().getId());
        BaseJsonResponse baseJsonResponse=new BaseJsonResponse();
        baseJsonResponse.setObj(user);
        baseJsonResponse.setReturnCode("0");
        return baseJsonResponse;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseJsonResponse login(@RequestBody UserLoginRequest request) {
        BaseJsonResponse baseJsonResponse = new BaseJsonResponse();
        User user = userMapper.selectByAccountNumber(request.getAccountNumber());
        BaseBean baseBean = new BaseBean();
        int result;
        if (user == null) {
            result = -1;
            baseJsonResponse.setObj(baseBean);
        } else if (user.getPassword().equals(request.getUserPassword())) {
            result = user.getUserId();
            String token = tokenService.generateToken(Role.User, result);
            baseBean.setSingleResult(token);
            baseJsonResponse.setObj(baseBean);
            addCookie(CommonConstants.TOKEN_KEY, token);
        } else {
            result = 0;
            baseBean.setSingleResult(String.valueOf(result));
            baseJsonResponse.setObj(baseBean);
        }

        switch (result) {
            case -1://对应异常  2.0.E.1
                baseJsonResponse.setReturnCode("2.0.E.1");
                baseJsonResponse.setReturnMsg("邮箱未被注册");
                break;
            case 0://对应异常  2.0.E.2
                baseJsonResponse.setReturnCode("2.0.E.2");
                baseJsonResponse.setReturnMsg("邮箱和密码不匹配");
                break;
            default://对应正确用例
                baseJsonResponse.setReturnCode("0");
                baseJsonResponse.setReturnMsg("登录成功");
                break;
        }
        return baseJsonResponse;
    }

    @RequestMapping(value = "/signUp" , method = RequestMethod.POST)
    public BaseJsonResponse signUp(@RequestBody SignUpRequest request) {
        System.out.println("signup");
        BaseJsonResponse baseJsonResponse = new BaseJsonResponse();
        BaseBean baseBean = new BaseBean();
        int result;
        if(userMapper.selectByAccountNumber(request.getAccountNumber())!=null){
            result=1;
            baseBean.setSingleResult(String.valueOf(result));
            baseJsonResponse.setObj(baseBean);
            baseJsonResponse.setReturnCode("1");
            baseJsonResponse.setReturnMsg("该邮箱已注册");
        }
        else {
            User user = new User();
            user.setEmail(request.getAccountNumber());
            user.setPassword(request.getUserPassword());
            user.setUserName("呵呵");
            userMapper.insertSelective(user);
            result = user.getUserId();
            String token = tokenService.generateToken(Role.User, result);
            baseBean.setSingleResult(token);
            baseJsonResponse.setObj(baseBean);
            baseJsonResponse.setReturnCode("0");
            baseJsonResponse.setReturnMsg("注册成功");
        }
        return baseJsonResponse;
    }





}
