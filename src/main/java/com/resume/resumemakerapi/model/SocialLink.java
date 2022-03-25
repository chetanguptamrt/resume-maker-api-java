package com.resume.resumemakerapi.model;

public class SocialLink {

    private String account;

    private String link;

    @Override
    public String toString() {
        return "SocialLink [account=" + account + ", link=" + link + "]";
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public SocialLink(String account, String link) {
        this.account = account;
        this.link = link;
    }

    public SocialLink() {
    }

}
