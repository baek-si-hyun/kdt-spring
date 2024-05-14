package com.app.dependency.di;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Data
public class Food {
    private final Knife knife;

//    @RequiredArgsConstructor을 사용하여
//    public Food(Knife knife) {
//        this.knife = knife;
//    }
//    로직을 추가하지 않아도 된다. (RequiredArgsConstructor가 대신 해줌)
//    즉, @RequiredArgsConstructor은 필드를 생성과 동시에 주입해주기 때문에 별도로 생성자를 만들지 않아도 된다.

}
