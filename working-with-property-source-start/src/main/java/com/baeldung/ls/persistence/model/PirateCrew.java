package com.baeldung.ls.persistence.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.stereotype.Component;

//@Component
//@ConfigurationProperties(prefix = "pirate-crew")
public class PirateCrew {

    private Integer number;
    private String captain;
    @Name("first-mate")
    private String firsMate;
    private String navigator;
    private String sniper;
    private String doctor;
    private String cook;
    private String historian;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public String getFirsMate() {
        return firsMate;
    }

    public void setFirsMate(String firsMate) {
        this.firsMate = firsMate;
    }

    public String getNavigator() {
        return navigator;
    }

    public void setNavigator(String navigator) {
        this.navigator = navigator;
    }

    public String getSniper() {
        return sniper;
    }

    public void setSniper(String sniper) {
        this.sniper = sniper;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getCook() {
        return cook;
    }

    public void setCook(String cook) {
        this.cook = cook;
    }

    public String getHistorian() {
        return historian;
    }

    public void setHistorian(String historian) {
        this.historian = historian;
    }

    @Override
    public String toString() {
        return "PirateCrew{" +
                "number=" + number +
                ", captain='" + captain + '\'' +
                ", firsMate='" + firsMate + '\'' +
                ", navigator='" + navigator + '\'' +
                ", sniper='" + sniper + '\'' +
                ", doctor='" + doctor + '\'' +
                ", cook='" + cook + '\'' +
                ", historian='" + historian + '\'' +
                '}';
    }
}
