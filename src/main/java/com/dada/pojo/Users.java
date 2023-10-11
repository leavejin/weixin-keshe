package com.dada.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    private int userID;
    private String userName;
    private String userPassword;
    private String userNumber;
    private String userAddress;
}
