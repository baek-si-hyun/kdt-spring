package com.app.controller.controller;


import com.app.controller.domain.MemberVO;
import com.app.controller.domain.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ex/*")
@Slf4j
public class ExampleController {


    @GetMapping("ex01")
    public void ex01() {
        log.info("ex01 ...............");
    }

//    화면에 전달받은 파라미터를 출력하기 위해서는 Model객체를 필요로한다.
//    @ModelAttribute 와 Model model은 같은것이다
//    하지만 가독성을 위해 전달할 파라미터가 하나이면 @ModelAttribute를 두개이상이면 Model을 전달하는 것이 좋다

    @GetMapping("ex02")
    public void ex02(@ModelAttribute("name") String name) {
        log.info("ex02 ...............");
        log.info(name);
    }

    //    나이 전달받기
    @GetMapping("ex03")
    public void ex03(@ModelAttribute("age") int age) {
        log.info("ex03 ...............");
        log.info("{}살", age);
    }

    @GetMapping("ex04")
    public void ex04(String name, int age, Model model) {
        log.info("ex04 ...............");
        log.info("{}: {}살", name, age);
        model.addAttribute("name", name);
        model.addAttribute("age", age);
    }

//  @RequestParam는 파라미터 이름을 정해주는 어노테이션이다.
//  파라미터로 받는 어노테이션은 하나만 가능하다
//  리턴을 하지않는 void 타입으로하게 되면 기존경로인 ex/가 앞에 붙는다
//  하지만 붙이지 않고 바로 ex05로 가고 싶으면 이동하고자하는 경로를 직접 return한다.
    @GetMapping("ex05")
    public String ex05(@RequestParam("job") String data, Model model) {
        log.info("ex05 ...............");
        log.info("직업: {}", data);
        model.addAttribute("job", data);

        return "ex05";
    }

//  객체는 Model에 자동으로 담기기 때문에 Model을 같이 전달 할 필요가 없다.
//  키 값은 해당 객체의 타입이 키값이다.
    @GetMapping("ex06")
    public void ex06(MemberVO memberVO) {
        log.info("ex06 ...............");
        log.info(memberVO.toString());
    }

//    상품명, 가격
    @GetMapping("ex07")
    public void ex07(ProductVO productVO){}
}
