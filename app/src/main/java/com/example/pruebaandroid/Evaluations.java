package com.example.pruebaandroid;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;
import androidx.room.Entity;

import java.io.Serializable;

@Entity
public class Evaluations implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "evaluator_name")
    private String evaluator_name;

    @ColumnInfo(name = "date_eva")
    private String date_eva;

    @ColumnInfo(name = "commerce")
    private String commerce;

    @ColumnInfo(name = "clean_clothes")
    private boolean clean_clothes;

    @ColumnInfo(name = "nails")
    private boolean nails;

    @ColumnInfo(name = "groomed_hair")
    private boolean groomed_hair;

    @ColumnInfo(name = "mask")
    private boolean mask;

    @ColumnInfo(name = "hat")
    private boolean hat;

    @ColumnInfo(name = "courtesy")
    private boolean courtesy;

    @ColumnInfo(name = "clients_served")
    private int clients_served;

    @ColumnInfo(name = "services")
    private int services;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvaluator_name() {
        return evaluator_name;
    }

    public void setEvaluator_name(String evaluator_name) {
        this.evaluator_name = evaluator_name;
    }

    public String getDate_eva() {
        return date_eva;
    }

    public void setDate_eva(String date_eva) {
        this.date_eva = date_eva;
    }

    public String getCommerce() {
        return commerce;
    }

    public void setCommerce(String commerce) {
        this.commerce = commerce;
    }

    public boolean getClean_clothes() {
        return clean_clothes;
    }

    public void setClean_clothes(boolean clean_clothes) {
        this.clean_clothes = clean_clothes;
    }

    public boolean getNails() {
        return nails;
    }

    public void setNails(boolean nails) {
        this.nails = nails;
    }

    public boolean getGroomed_hair() {
        return groomed_hair;
    }

    public void setGroomed_hair(boolean groomed_hair) {
        this.groomed_hair = groomed_hair;
    }

    public boolean getMask() {
        return mask;
    }

    public void setMask(boolean mask) {
        this.mask = mask;
    }

    public boolean getHat() {
        return hat;
    }

    public void setHat(boolean hat) {
        this.hat = hat;
    }

    public boolean getCourtesy() {
        return courtesy;
    }

    public void setCourtesy(boolean courtesy) {
        this.courtesy = courtesy;
    }

    public int getClients_served() {
        return clients_served;
    }

    public void setClients_served(int clients_served) {
        this.clients_served = clients_served;
    }

    public int getServices() {
        return services;
    }

    public void setServices(int services) {
        this.services = services;
    }


}
