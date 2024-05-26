package com.santander.springWeb.DTO;

import java.sql.Date;
import java.time.LocalDate;

public class ReserveOnDestinyDTO {

    private int destiny_id;
    private String destiny_name;
    private String description;

    private int reserve_id;
    private int id_user;
    private int id_destiny;
    private LocalDate reserve_date;
    private String status;

    public ReserveOnDestinyDTO(int destiny_id, String destiny_name, String description, int reserve_id, int id_user, int id_destiny, Date reserve_date, String status) {
        this.destiny_id = destiny_id;
        this.destiny_name = destiny_name;
        this.description = description;
        this.reserve_id = reserve_id;
        this.id_user = id_user;
        this.id_destiny = id_destiny;
        this.reserve_date = convertLocalDate(reserve_date);
        this.status = status;
    }

    private LocalDate convertLocalDate(Date date) {
        return date.toLocalDate();
    }

    public int getDestiny_id() {
        return destiny_id;
    }

    public void setDestiny_id(int destiny_id) {
        this.destiny_id = destiny_id;
    }

    public String getDestiny_name() {
        return destiny_name;
    }

    public void setDestiny_name(String destiny_name) {
        this.destiny_name = destiny_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReserve_id() {
        return reserve_id;
    }

    public void setReserve_id(int reserve_id) {
        this.reserve_id = reserve_id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_destiny() {
        return id_destiny;
    }

    public void setId_destiny(int id_destiny) {
        this.id_destiny = id_destiny;
    }

    public LocalDate getReserve_date() {
        return reserve_date;
    }

    public void setReserve_date(LocalDate reserve_date) {
        this.reserve_date = reserve_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


