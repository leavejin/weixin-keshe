package com.dada.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NetAdmin {
    private int netadminID;
    private String netadminName;
    private String netadminPassword;
    private String netadminNumber;
    private String dotName;
}
