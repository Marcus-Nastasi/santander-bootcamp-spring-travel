package com.santander.springWeb.DTO;

import com.santander.springWeb.Models.Reserve;
import com.santander.springWeb.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserOnReserveDTO {

    @Autowired
    private Reserve reserve;
    @Autowired
    private User user;

    public Reserve getReserve() {
        return reserve;
    }

    public void setReserve(Reserve reserve) {
        this.reserve = reserve;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


