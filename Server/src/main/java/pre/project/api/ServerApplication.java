<<<<<<<< HEAD:Server/src/main/java/pre/project/api/ServerApplication.java
package pre.project.api;
========
package pre.project;
>>>>>>>> main:Server/src/main/java/pre/project/ServerApplication.java

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

}
