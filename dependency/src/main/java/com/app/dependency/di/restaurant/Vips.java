package com.app.dependency.di.restaurant;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Data
@Qualifier("vips")
public class Vips implements Restaurant {

    private int steak = Restaurant.steak;

    @Override
    public boolean isSelfBar() {
        return false;
    }
}
