package pre.project.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pre.project.aop.LogAop;

@Configuration
public class AppConfig {

   @Bean
   public LogAop logAop() {
       return new LogAop();
   }
}
