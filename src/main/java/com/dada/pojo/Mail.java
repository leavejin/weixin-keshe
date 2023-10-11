package com.dada.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mail {
    //快递单号
    private int kid;
    //寄件人姓名
    private String senderName;
    //寄件人手机号
    private String senderNumber;
    //寄件人地址
    private String senderAddress;
    //收件人姓名
    private String recipientName;
    //收件人手机号
    private String recipientPhone;
    //收件人地址
    private String recipientAddress;
    //物品类型
    private String itemType;
    //物品重量
    private String itemWeight;
    //价格
    private String valuation;

    private String dotName;

    private String courierName;

    private String lj;
    private String sj;

}
