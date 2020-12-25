package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    // static 정적
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";
    }
    // mvc 방식. 뷰로 전해줌 name은 ?name=ㅇㄴㅁㅇ 해줘야함
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }
    // api 방식. 뷰가없음 템플릿가는게아니고 html없이 걍 그대로 보여줌
    @GetMapping("hello-string")
    @ResponseBody // viewresolve한테 던지지않고 그대로 넘기게함
    public String helloString(@RequestParam("name") String name){
        return "hello" + name;
    }
    // api 방식. json 형태로 보내주기 (요즘)
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    } // 객체 넘기면 json형태로 주는게 규칙
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
