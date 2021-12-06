package co.usa.ciclo4.retos;


import co.usa.ciclo4.retos.icrudrepository.CloneCrudRepository;
import co.usa.ciclo4.retos.icrudrepository.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;


//@EntityScan(basePackages = {"co.usa.ciclo4.retos.model"})
@Component
@SpringBootApplication
public class RetosApplication implements CommandLineRunner {

        @Autowired
        private UserCrudRepository userCrudRepository;
        
        @Autowired
        private CloneCrudRepository cloneCrudRepository;
        
	public static void main(String[] args) {
		SpringApplication.run(RetosApplication.class, args);
	}
        
        @Override
        public void run(String... args) throws Exception {
            
            userCrudRepository.deleteAll();
            cloneCrudRepository.deleteAll();
            
            /*userCrudRepository.saveAll(List.of(
                new User()
            ));
            */
        }

}
