package com.dada.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private int adminID;
    private String adminName;
    private String adminPassword;
    private String adminNumber;
}
