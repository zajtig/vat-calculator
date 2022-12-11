package com.globalblue.common.rest.view;

public class ErrorDto extends DataStructure {

    public String error;

    public ErrorDto() {
    }

    public ErrorDto(String error) {
        this.error = error;
    }
}