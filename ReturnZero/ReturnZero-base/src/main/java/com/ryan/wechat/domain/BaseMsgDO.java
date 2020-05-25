package com.ryan.wechat.domain;

import lombok.Data;

/**
 * @author: ryan
 * @create: 2020/5/23
 * @description: 信息交互基础对象
 **/
@Data
public class BaseMsgDO {

    private String ToUserName;

    private String FromUserName;

    private long CreateTime;

    private String MsgType;

}
