/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo4.retos.wcontroller;


import co.usa.ciclo4.retos.dmodel.User;
import co.usa.ciclo4.retos.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 * 
 * Clase Controlador 'UserController'
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {
    
    /**
     * Atributo objeto 'userService' instancia de la clase
     * 'UserService'
     */    
    @Autowired
    private UserService userService;
    
    /**
     * Metodo para obtener y retornar una lista de todos los registros de
     * documentos de cuentas de usuario hacia el metodo 'getAll' del UserService
     * @return 
     */
    @GetMapping("/all")
    public List<User> getUsers() {
        return userService.getAll();
    }
    
    /**
     * Metodo para obtener y retornar un registro de documento de cuenta de 
     * usuario por el valor de su atributo 'id', hacia el metodo 'getUserById' 
     * del UserService
     * @param id
     * @return 
     */
    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }
    
    /**
     * Metodo para guardar y retornar un registro de documento de cuenta de 
     * usuario hacia el metodo 'save' del UserService
     * @param user
     * @return 
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return userService.save(user);
    }
    
    /**
     * Metodo para actualizar y retornar un registro de documento de cuenta 
     * de usuario hacia el metodo 'update' del UserService
     * @param user
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
    
    /**
     * Metodo para eliminar y retornar un registro de documento de cuenta de 
     * usuario hacia el metodo 'delete' del UserService
     * @param id
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id) {
        return userService.delete(id);
    }    
    
    /**
     * Metodo para obtener y retornar un registro de cuenta de usuario por
     * el valor de su atributo 'email', hacia el metodo 'getUserByEmail' del 
     * UserService
     * @param email
     * @return 
     */
    @GetMapping("/emailexist/{email}")
    public boolean emailExist(@PathVariable("email") String email) {
        return userService.getUserByEmail(email);
    }
    
    /**
     * Metodo para obtener y retornar un registro de cuenta de usuario por
     * el valor de sus atributos 'email' y 'password', hacia el metodo 
     * 'getUserByEmailAndPassword' del UserService
     * @param email
     * @param password
     * @return 
     */
    @GetMapping("/{email}/{password}")
    public User authenticateUser(@PathVariable("email") String email, 
            @PathVariable("password") String password) {
        return userService.getUserEmailAndPassword(email, password);
    }
    
}
