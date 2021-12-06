/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.usa.ciclo4.retos.icrudrepository;


import co.usa.ciclo4.retos.dmodel.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * 
 * Interface UserCrudRepository hereda los metodos y atributos de la clase
 * MongoRepository
 */
public interface UserCrudRepository extends MongoRepository<User, Integer> {
    
    /**
     * Metodo Query para encontrar registro de cuenta de usuario por el valor 
     * de su atributo 'name'
     * @param name
     * @return 
     */
    public Optional<User> findByName(String name);
    
    /**
     * Metodo Query para encontrar registro de cuenta de usuario por el valor
     * de su atributo 'email'
     * @param email
     * @return 
     */
    public Optional<User> findByEmail(String email);
    
    /**
     * Metodo Query para encontrar registro de cuenta de usuario por el valor
     * de su atributo 'name' o por su atributo 'email'
     * @param name
     * @param email
     * @return 
     */
    public List<User> findByNameOrEmail(String name, String email);
    
    /**
     * Metodo Query para encontrar registro de cuenta de usuario por los valores
     * de sus atributos 'email' y 'password'
     * @param email
     * @param password
     * @return
     */
    public Optional<User> findByEmailAndPassword(String email, String password);
    
}
