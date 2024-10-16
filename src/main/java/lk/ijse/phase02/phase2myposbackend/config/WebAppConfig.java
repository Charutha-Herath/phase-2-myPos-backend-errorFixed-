package lk.ijse.phase02.phase2myposbackend.config;


import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "lk.ijse.phase02.phase2myposbackend")
@EnableWebMvc
public class WebAppConfig {

}
