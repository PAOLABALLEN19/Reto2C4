/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo4.retos.repository;


import co.usa.ciclo4.retos.dmodel.User;
import co.usa.ciclo4.retos.icrudrepository.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * 
 * Clase Repositorio 'UserRepository'
 */
@Repository
public class UserRepository {
    
    /**
     * Atributo objeto 'userCrudRepository' instancia de la interface
     * 'UserCrudRepository'
     */
    @Autowired
    private UserCrudRepository userCrudRepository;
    
    /**
     * Metodo para obtener y retornar una lista de todos los registros de
     * documentos de cuentas de usuario hacia el metodo 'findAll' del 
     * MongoRepository
     * @return
     */
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }

    /**
     * Metodo para obtener y retornar un registro de documento de cuenta de 
     * usuario por el valor de su atributo 'id', hacia el metodo 'findById' del 
     * MongoRepository
     * @param id
     * @return 
     */
    public Optional<User> getUserById(Integer id) {
        return userCrudRepository.findById(id);
    }
    
    /**
     * Metodo para guardar y retornar un registro de documento de cuenta de 
     * usuario hacia el metodo 'save' del MongoRepository
     * @param user
     * @return 
     */
    public User save(User user) {
        return userCrudRepository.save(user);
    }
    
    /**
     * Metodo para actualizar y retornar un registro de documento de cuenta 
     * de usuario hacia el metodo 'update' del MongoRepository
     * @param user 
     */
     public void update(User user) {
        userCrudRepository.save(user);
    }
    
    /**
     * Metodo para eliminar y retornar un registro de documento de cuenta de 
     * usuario hacia el metodo 'delete' del MongoRepository
     * @param user 
     */
    public void delete(User user) {
        userCrudRepository.delete(user);
    }

    /**
     * Metodo para validar y retornar un valor booleano que indica si un
     * registro de documento de cuenta de usuario existe, buscandolo a partir 
     * del atributo 'email' del registro, hacia el metodo query 'findByEmail' 
     * del MongoRepository
     * @param email
     * @return 
     */
    public boolean emailExists(String email) {
        Optional<User> userOptional = userCrudRepository.findByEmail(email);
        return !userOptional.isEmpty();
    }
    
    /**
     * Metodo para obtener y retornar un registro de documento de cuenta de 
     * usuario, buscandolo a partir de los atributos 'email' y 'password' del 
     * registro, hacia el metodo query 'findByEmailAndPassword' del 
     * MongoRepository
     * @param email
     * @param password
     * @return 
     */
    public Optional<User> authenticateUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }  

    /**
     * Metodo para obtener y retornar un registro de documento de cuenta de 
     * usuario por el valor de su atributo 'name', hacia el metodo 'findByName' 
     * del MongoRepository
     * @param name
     * @return 
     */
    public Optional<User> getUserByName(String name) {
        return userCrudRepository.findByName(name);
    }
    
    /**
     * Metodo para obtener y retornar un registro de documento de cuenta de 
     * usuario por el valor de su atributo 'email', hacia el metodo 'findByEmail' 
     * del MongoRepository
     * @param email
     * @return 
     */
    public Optional<User> getUserByEmail(String email) {
        return userCrudRepository.findByEmail(email);
    }
    
    /**
     * Metodo para obtener y retornar un registro de documento de cuenta de 
     * usuario por el valor de su atributo 'name' o de su atributo 'email', 
     * hacia el metodo 'findByNameOrEmail' del MongoRepository
     * @param name
     * @param email
     * @return 
     */
    public List<User> getUsersByNameOrEmail(String name, String email) {
        return userCrudRepository.findByNameOrEmail(name, email);
    }
    
    /**
     * Metodo para obtener y retornar un registro de documento de cuenta de 
     * usuario por los valores de sus atributos 'email' y 'password', 
     * hacia el metodo 'findByName' del MongoRepository
     * @param email
     * @param password
     * @return 
    */
    public Optional<User> getUserEmailAndPassword(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
    
}
