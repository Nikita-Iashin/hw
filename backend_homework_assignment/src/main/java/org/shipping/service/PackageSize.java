package org.shipping.service;

public enum PackageSize {
    S("Small"),
    M("Medium"),
    L("Large");

    private String text;

    PackageSize(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
