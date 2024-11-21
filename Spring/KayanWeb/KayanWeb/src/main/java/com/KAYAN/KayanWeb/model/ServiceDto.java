package com.KAYAN.KayanWeb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServiceDto {
    private Integer id;
    private String serviceName;
    private Integer serviceID;

    private String serviceDesc;
    private String serviceUrl;
    private String serviceType;
    private String serviceStatus;
}
