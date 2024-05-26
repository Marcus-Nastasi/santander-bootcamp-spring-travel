package com.santander.springWeb.DTO;

import java.sql.Date;
import java.time.LocalDate;

public class UserOnReserveDTO {

    private int user_id;
    private String user_name;
    private String email;
    private LocalDate birth;

    private int reserve_id;
    private int id_user;
    private int id_destiny;
    private LocalDate reserve_date;
    private String status;

    public UserOnReserveDTO(int user_id, String user_name, String email, Date birth, int reserve_id, int id_user, int id_destiny, Date reserve_date, String status) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.email = email;
        this.birth = this.convertLocalDate(birth);
        this.reserve_id = reserve_id;
        this.id_user = id_user;
        this.id_destiny = id_destiny;
        this.reserve_date = this.convertLocalDate(reserve_date);
        this.status = status;
    }

    public LocalDate convertLocalDate(Date date) {
        return date.toLocalDate();
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
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



