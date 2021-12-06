/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo4.retos.service;


import co.usa.ciclo4.retos.dmodel.Clone;
import co.usa.ciclo4.retos.repository.CloneRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * Clase Servicio 'CloneService'
 */
@Service
public class CloneService {

    /**
     * Atributo objeto 'cloneRepository' instancia de la clase
     * 'CloneRepository'
     */
    @Autowired
    private CloneRepository cloneRepository;

    /**
     * Metodo para obtener y retornar una lista de todos los registros 
     * de documentos de productos hacia el metodo 'getAll' del 
     * CloneRepository
     * @return
     */
    public List<Clone> getAll() {
        return cloneRepository.getAll();
    }

    /**
     * Metodo para obtener y retornar un registro de documento de producto 
     * por el valor de su atributo 'id', hacia el metodo 'getCloneById' del
     * CloneRepository
     * @param id
     * @return
     */
    public Optional<Clone> getCloneById(Integer id) {
        return cloneRepository.getCloneById(id);
    }

    /**
     * Metodo para guardar y retornar una registro de documento de producto 
     * hacia el metodo 'save' del CloneRepository
     * @param clone
     * @return
     */
    public Clone save(Clone clone) {
        if (clone.getBrand() == null || clone.getProcesor() == null || clone.getOs() == null
                || clone.getDescription() == null || clone.getMemory() == null 
                || clone.getHardDrive() == null) {
            return clone;
        } else {
            if (clone.getId() == null) {
                return clone;
            } else {
                return cloneRepository.save(clone);
            }
        }

    }

    /**
     * Metodo para actualizar y retornar un registro de documento de producto 
     * hacia el metodo 'update' del CloneRepository
     * @param clone
     * @return
     */
    public Clone update(Clone clone) {
        if (clone.getId() != null) {
            Optional<Clone> cloneOptional = cloneRepository.getCloneById(clone.getId());
            if (!cloneOptional.isEmpty()) {
                if (clone.getBrand() != null) {
                    cloneOptional.get().setBrand(clone.getBrand());
                }
                if (clone.getProcesor() != null) {
                    cloneOptional.get().setProcesor(clone.getProcesor());
                }
                if (clone.getOs() != null) {
                    cloneOptional.get().setOs(clone.getOs());
                }
                if (clone.getDescription() != null) {
                    cloneOptional.get().setDescription(clone.getDescription());
                }
                if (clone.getMemory() != null) {
                    cloneOptional.get().setMemory(clone.getMemory());
                }
                if (clone.getHardDrive() != null) {
                    cloneOptional.get().setHardDrive(clone.getHardDrive());
                }
                if (clone.getPrice() != 0.0) {
                    cloneOptional.get().setPrice(clone.getPrice());
                }
                if (clone.getQuantity() != 0) {
                    cloneOptional.get().setQuantity(clone.getQuantity());
                }
                if (clone.getPhotography() != null) {
                    cloneOptional.get().setPhotography(clone.getPhotography());
                }
                cloneOptional.get().setAvailability(clone.isAvailability());
                cloneRepository.update(cloneOptional.get());
                return cloneOptional.get();
            } else {
                return clone;
            }
        } else {
            return clone;
        }
    }

    /**
     * Metodo para eliminar y retornar un registro de documento de producto 
     * hacia el metodo 'delete' del CloneRepository
     * @param id
     * @return
     */
    public boolean delete(Integer id) {
        Optional<Clone> cloneOptional = cloneRepository.getCloneById(id);
        if (cloneOptional.isPresent()) {
            cloneRepository.delete(cloneOptional.get());
            return true;
        } else {
            return false;
        }
    }

}
