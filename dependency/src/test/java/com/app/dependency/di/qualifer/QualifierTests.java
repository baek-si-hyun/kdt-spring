package com.app.dependency.di.qualifer;

import com.app.dependency.di.qualifier.Computer;
import com.app.dependency.di.restaurant.Restaurant;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class QualifierTests {
    @Autowired
//    @Qualifier("desktop")
    private Computer computer;

    @Autowired
    @Qualifier("vips")
    private Restaurant restaurant;

    @Test
    public void computerTest(){
        log.info("{}", computer);
    }

    @Test
    public void restaurantTest(){
        log.info("{}", restaurant);
    }

}
