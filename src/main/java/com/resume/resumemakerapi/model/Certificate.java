package com.resume.resumemakerapi.model;

public class Certificate {
    
    private String certificate;

    public Certificate(String certificate) {
        this.certificate = certificate;
    }

    public Certificate() {
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    @Override
    public String toString() {
        return "Certificate [certificate=" + certificate + "]";
    }

}
