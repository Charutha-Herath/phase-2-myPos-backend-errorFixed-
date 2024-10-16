package lk.ijse.phase02.phase2myposbackend.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/health")
public class HealthCheckController {
    @GetMapping
    public String HealthTest(){
        System.out.println("HealthChecker.. \n\n");
        return "Health checker is working";
    }
}
