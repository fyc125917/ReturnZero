package com.ryan.wechat.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: ryan
 * @create: 2020/5/23
 * @description: 接收信息
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class TextMessageDO extends BaseMsgDO {

    private String Content;

    private String MsgId;


}
