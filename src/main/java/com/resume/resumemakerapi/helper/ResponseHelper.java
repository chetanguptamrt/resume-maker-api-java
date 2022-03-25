package com.resume.resumemakerapi.helper;

import java.util.Arrays;

public class ResponseHelper {
    
    private int status;

    private byte[] content;

    public ResponseHelper(int status, byte[] content) {
        this.status = status;
        this.content = content;
    }

    public ResponseHelper() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ResponseHelper [content=" + Arrays.toString(content) + ", status=" + status + "]";
    }

}
