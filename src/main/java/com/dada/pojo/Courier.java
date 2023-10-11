package com.dada.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Courier {
    private int courierID;
    private String courierName;
    private String courierPassword;
    private String courierNumber;
    private String courierSite;
}
