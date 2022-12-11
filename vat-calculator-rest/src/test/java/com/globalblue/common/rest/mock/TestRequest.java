package com.globalblue.common.rest.mock;

import com.globalblue.common.rest.view.DataStructure;
import com.globalblue.common.rest.view.RequestDto;

public class TestRequest extends DataStructure implements RequestDto {

    public String requestData = "requestData";

    @Override
    public Object mapToEntity() {
        return null;
    }
}
