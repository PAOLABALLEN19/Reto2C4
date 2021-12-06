/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo4.retos.dmodel;


import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * Clase Modelo Documento User
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document (collection = "usuarios")
public class User {
    
    /**
     * Atributo 'id' del Documento
     */
    @Id
    private Integer id;
    
    /**
     * Atributo 'identification' del Documento
     */
    private String identification;
    
    /**
     * Atributo 'name' de la Entidad
     */
    private String name;
    
    /*private Date birthDay;*/
    
    /*private String monthBirthDay;*/
    
    /**
     * Atributo 'address' de la Entidad
     */
    private String address;
    
    /**
     * Atributo 'cellPhone' de la Entidad
     */
    private String cellPhone;

    /**
     * Atributo 'email' de la Entidad
     */
    private String email;
    
    /**
     * Atributo 'password' de la Entidad
     */
    private String password;
    
    /**
     * Atributo 'zone' de la Entidad
     */
    private String zone;
    
    /**
     * Atributo 'type' de la Entidad
     */   
    private String type;
    
}
