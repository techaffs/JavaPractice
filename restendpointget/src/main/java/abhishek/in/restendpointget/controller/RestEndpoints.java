package abhishek.in.restendpointget.controller;

import abhishek.in.restendpointget.service.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestEndpoints {
    //MVC Spring,
    //Bean // Constructor, parametrized , ...Spring Recipe PDF
    //Spring IOC Container
    //Invoking a Constructor
    //Specifying Bean References.
    @Autowired   //by Singleton, prototype ,
    Utility util;
        // A // B @A //C @B

    @RequestMapping("/course")
    public Course abhishekPoint(@RequestParam(value="name",defaultValue = "JAVA", required = false) String name,
                              @RequestParam(value="chapterCount",defaultValue = "1", required = false) int chapterCount
                            ){
        util.printName();
        return new Course(name, chapterCount);
    }
}
