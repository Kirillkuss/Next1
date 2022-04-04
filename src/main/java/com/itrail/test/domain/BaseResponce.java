
package com.itrail.test.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 * @author barysevich_k
 */
public class BaseResponce {
    private int code =999;
    private String message;
    @JsonInclude(Include.NON_NULL)
    private Object data;

    public BaseResponce() {
    }

    public BaseResponce(int code,String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    

    @Override
    public String toString() {
        return "BaseResponce{" + "code=" + code + ", message=" + message + '}';
    }
    
    
    
}
