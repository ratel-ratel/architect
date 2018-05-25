package data.structure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * import org.springframework.web.method.support.HandlerMethodArgumentResolver;
 import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 import data.structure.annotation.RequestJsonHandlerMethodArgumentResolver;
 */

@SpringBootApplication
@MapperScan("data.structure.mapper*")
@EnableScheduling
public class Application/* extends WebMvcConfigurerAdapter*/ {

//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        //参数解析器
//        argumentResolvers.add(new RequestJsonHandlerMethodArgumentResolver());
//        super.addArgumentResolvers(argumentResolvers);
//    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(
        Application.class);
        application.run(args);
    }
}
