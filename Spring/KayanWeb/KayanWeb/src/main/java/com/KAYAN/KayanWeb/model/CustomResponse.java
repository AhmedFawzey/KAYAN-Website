package com.KAYAN.KayanWeb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CustomResponse<T> {

    private int code ;
    private String msg ;
    private T data;
}
