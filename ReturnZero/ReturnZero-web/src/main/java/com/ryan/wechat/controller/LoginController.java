package com.ryan.wechat.controller;

import com.ryan.wechat.util.CheckUtil;
import com.ryan.wechat.utils.MessageUtils;
import com.ryan.wechat.utils.TextMessageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @author: ryan
 * @create: 2020/5/23
 * @description: 请求接收
 **/
@Slf4j
@Controller
@RequestMapping("/weixin")
public class LoginController {

    //微信服务的请求地址
    @RequestMapping(value = "/",method = RequestMethod.GET)
    @ResponseBody
    public String login(HttpServletRequest request) {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        if(CheckUtil.checkSignature(signature, timestamp, nonce)){
            System.out.println(echostr);
            log.info(echostr);
            return echostr;
        }else {
            log.warn("不是微信服务器发过来的请求");
            return null;
         }
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    @ResponseBody
    public Object dopost(HttpServletRequest request){
        //将微信请求xml转为map格式，获取所需的参数
        Map<String,String> map = MessageUtils.xmlToMap(request);
        String ToUserName = map.get("ToUserName");
        String FromUserName = map.get("FromUserName");
        String MsgType = map.get("MsgType");
        String Content = map.get("Content");

        String message = "131d634ad3.a1d3a1";
        //处理文本类型，实现输入1，回复相应的封装的内容
        if("text".equals(MsgType)){
            if("1".equals(Content)){
                TextMessageUtils textMessage = new TextMessageUtils();
                message = textMessage.initMessage(FromUserName, ToUserName);
            }
        }
        return message;
    }

}
