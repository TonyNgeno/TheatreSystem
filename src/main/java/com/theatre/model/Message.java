package com.theatre.model;

import java.io.Serializable;

public class Message implements Serializable {

    private String message;
    private Object object;
    private boolean success;

    public Message(boolean success, String message) {
        this.message = message;
        this.success = success;
    }

    public Message(boolean success, String message, Object object) {
        this.message = message;
        this.object = object;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
