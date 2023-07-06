package boardProject.MainBoard;

import boardProject.MainBoard.repository.UserRepository;
import boardProject.MainBoard.service.UserService;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class SpringConfig {
    private final EntityManager em;
    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource, EntityManager em){
        this.em=em;
        this.dataSource= dataSource;
    }

    @Bean
    public UserService userService(){
        return new UserService(userRepository());
    }

    @Bean
    public UserRepository userRepository(){
        return new UserRepository(em);
    }

}
