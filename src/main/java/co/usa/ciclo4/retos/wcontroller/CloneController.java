/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo4.retos.wcontroller;


import co.usa.ciclo4.retos.dmodel.Clone;
import co.usa.ciclo4.retos.service.CloneService;
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
 * Clase Controlador 'CloneController'
 */
@RestController
@RequestMapping("/api/clone")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CloneController {
    
    /**
     * Atributo objeto 'cloneService' instancia de la clase
     * 'CloneService'
     */    
    @Autowired
    private CloneService cloneService;
    
    /**
     * Metodo para obtener y retornar una lista de todos los registros de
     * de documentos de productos hacia el metodo 'getAll' del CloneService
     * @return 
     */
    @GetMapping("/all")
    public List<Clone> getClones() {
        return cloneService.getAll();
    }
    
    /**
     * Metodo para obtener y retornar un registro de documento de producto 
     * por el valor de su atributo 'id', hacia el metodo 'getUserById' 
     * del CloneService
     * @param id
     * @return 
     */
    @GetMapping("/{id}")
    public Optional<Clone> getClone(@PathVariable("id") Integer id) {
        return cloneService.getCloneById(id);
    }

    /**
     * Metodo para guardar y retornar un registro de documento de producto 
     * hacia el metodo 'save' del CloneService
     * @param clone
     * @return 
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone save(@RequestBody Clone clone) {
        return cloneService.save(clone);
    }
    
    /**
     * Metodo para actualizar y retornar un registro de documento de producto 
     * hacia el metodo 'update' del CloneService
     * @param clone
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone update(@RequestBody Clone clone) {
        return cloneService.update(clone);
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
        return cloneService.delete(id);
    }
    
}
