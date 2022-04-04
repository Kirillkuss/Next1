package com.itrail.test.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.itrail.test.serializer.LocalDateTimeSerializer;
import java.time.LocalDateTime;

/**
 *
 * @author barysevich_k
 */
public class ServerTime {

    private int code = 0;
    @JsonSerialize( using = LocalDateTimeSerializer.class)
    private LocalDateTime time;

    public ServerTime() {
        time = LocalDateTime.now();
    }

    public ServerTime(LocalDateTime time) {
        this.time = time;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ServerTime{" + "code=" + code + ", time=" + time + '}';
    }
}