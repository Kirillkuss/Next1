
package com.itrail.test.domain;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * @author barysevich_k
 */
public class BaseResponse<T> {
    private int code = 999;
    private String message = "System mallfunction";
    
    
    @JsonInclude(Include.NON_NULL)
    private T data;

    public BaseResponse() {
    }

    public BaseResponse(int code,String message) {
        this.code = code;
        this.message = message;
    }
    
    public static BaseResponse success() {
        return new BaseResponse( 0, "success");
    }
    
    public static BaseResponse error( int code, Throwable e ) {
        return new BaseResponse( 0, null == e.getMessage() ?  "System mullfunction " : e.getMessage());
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

    public <T> T getData() {
        return (T)data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResponce{" + "code=" + code + ", message=" + message + ", data=" + data + '}';
    }


}
