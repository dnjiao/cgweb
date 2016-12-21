package org.mdacc.rists.cghub.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Spring Boot main Application
 *
 */

@SpringBootApplication
//@EntityScan({"org.mdacc.rists.cghub.model"}) 
@EnableJpaRepositories(basePackages = {"org.mdacc.rists.cghub.ws.repository"})
public class CgApplication extends SpringBootServletInitializer
{
	
    public static void main( String[] args )
    {
        SpringApplication.run(CgApplication.class, args);
    }
    
 // following method only needed if deployed as war
 	@Override
     protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
         return application.sources(CgApplication.class);
     }
}
