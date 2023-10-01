package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    //lives /hello/goodbye
    @GetMapping("goodbye")
    public String displayGoodbyeMessage() {
        return "Goodbye, Spring!";
    }

    //lives /hello/hello
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //Handles requests of the form /hello/Launchcode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm() {
        String html =
                "<html>" +
                        "<body>" +
                        "<form method = 'post' action = '/hello/form/greeting'>" +
                        "<input type = 'text' name = 'name' />" +
                        "<select name = 'lang'>" +
                        "<option value = 'English'> English </option>" +
                        "<option value = 'Spanish'> Spanish </option>" +
                        "<option value = 'French'> French </option>" +
                        "<option value = 'German'> German </option>" +
                        "<option value = 'Italian'> Italian </option>" +
                        "<option value = 'Japanese'> Japanese </option>" +
                        "<input type = 'submit' value = 'Greet Me!' />" +
                        "</form>" +
                        "</body>" +
                        "</html>";
        return html;
    }

    @PostMapping("/form/greeting")
    public static String createMessage(@RequestParam String name, String lang) {
        String greeting = "";
        if (Objects.equals(lang, "Spanish")) {
            greeting = "Hola";
        } else if (Objects.equals(lang, "French")) {
            greeting = "Bonjour";
        } else if (Objects.equals(lang, "German")) {
            greeting = "Guten Tag";
        } else if (Objects.equals(lang, "Italian")) {
            greeting = "Salve";
        } else if (Objects.equals(lang, "Japanese")) {
            greeting = "Konnichiwa";
        } else if (Objects.equals(lang, "English")){
            greeting = "Hello";
        }
        return greeting + " " + name;
    }
    //Handles request of the form /hello?name=Launchcode
//    @GetMapping("hello")
//    @ResponseBody
//    public String helloWithQueryParam(@RequestParam String name) {
//      return "Hello, " + name + "!";
//    }
}
