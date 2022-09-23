package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
//@RequestMapping("hello")
public class HelloController {

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//////        full fledged request handler
//    }lives at hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
    return "Goodbye, Spring!";
    }
//handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam ( @RequestParam String name, @RequestParam String language){
        String properGreeting = HelloController.createMessage(name, language);
        return "<h3 style='color:purple;'>" + properGreeting + "</h3>";
    }
//handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam (@PathVariable String name){
        return "Hello, " + name + "!";
    }
    @GetMapping("form")
    public String helloForm() {

//        <select name="pets" id="pet-select">
//            <option value="">--Please choose an option--</option>
//            <option value="dog">Dog</option>
//            <option value="cat">Cat</option>
//            <option value="hamster">Hamster</option>
//            <option value="parrot">Parrot</option>
//            <option value="spider">Spider</option>
//            <option value="goldfish">Goldfish</option>
//        </select>

       return "<html" +
               "<body>" +
               "<form action='hello' method='post'>" + // submit a request to /hello
               "<input type= 'text' name='name'/>" +
               "<select name = 'language'>" +
                   "<option value='English'>English</option>"+
                   "<option value='Spanish'>Spanish</option>"+
                   "<option value='French'>French</option>"+
                   "<option value='Italian'>Italian</option>"+
                   "<option value='German'>German</option>"+
               "</select>"+
               "<input type= 'submit' value='Greet me!'/>" +
               "</form>"+
               "</body>" +
               "</html>";
    }
    public static String createMessage(String name, String language){
        switch(language){
            case "Spanish":
                return "Hola, " + name;
            case "French":
                return "Bonjour, " + name;
            case "Italian":
                return "Ciao, " + name;
            case "German":
        return "Hallo, " + name;
            case "English":
            default:
                return "Hello, " + name;
        }
    }
}