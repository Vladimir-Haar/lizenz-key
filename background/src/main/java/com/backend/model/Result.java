package com.backend.model;

public class Result {
    private boolean gueltig;
    private String meldung;

    public Result() {
    }

    public boolean isGueltig() {
        return gueltig;
    }

    public String getMeldung() {
        return meldung;
    }

    public Result(boolean gueltig, String meldung) {
        this.gueltig = gueltig;
        this.meldung = meldung;
    }
}
