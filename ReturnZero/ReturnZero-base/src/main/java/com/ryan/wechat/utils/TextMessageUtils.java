package com.ryan.wechat.utils;

import com.ryan.wechat.domain.TextMessageDO;
import com.thoughtworks.xstream.XStream;

import java.util.Date;

/**
 * @author: ryan
 * @create: 2020/5/23
 * @description: 文本消息 工具类
 **/
public class TextMessageUtils implements BaseMessageUtils<TextMessageDO> {

    @Override
    public String messageToXml(TextMessageDO message) {
        XStream xstream  = new XStream();
        xstream.alias("xml", message.getClass());
        return xstream.toXML(message);
    }

    /**
     * 封装发送消息对象,封装时，需要将调换发送者和接收者的关系
     * @param FromUserName
     * @param ToUserName
     */
    public  String initMessage(String FromUserName, String ToUserName) {
        TextMessageDO text = new TextMessageDO();
        text.setToUserName(FromUserName);
        text.setFromUserName(ToUserName);
        text.setContent("欢迎关注机械振动工程党支部");
        text.setCreateTime(new Date().getTime());
        text.setMsgType("text");
        return  messageToXml(text);
    }

}
