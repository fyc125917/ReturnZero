package com.ryan.wechat.utils;

/**
 * @author: ryan
 * @create: 2020/5/23
 * @description: 消息处理工具总类
 **/
public interface BaseMessageUtils<T> {

    /**
     * @author: ryan
     * @create: 2020/5/23
     * @description: 消息-> xml
     **/
    String messageToXml(T t);

    /**
     * @author: ryan
     * @create: 2020/5/23
     * @description: 回复消息的封装
     **/
    String initMessage(String FromUserName,String ToUserName);

}
