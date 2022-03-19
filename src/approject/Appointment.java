/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package approject;

/**
 *
 * @author 073T
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="APPOINTMENT")
public class Appointment implements java.io.Serializable {
    
    @Id
    @Column(name="dateandtime")
    private String DateAndTime;
    
    @Column(name="username")
    private String Username;
    
    
    @Column(name="service")
    private String Service;
    
    @Column(name="petkind")
    private String PetKind;
    
    
    
    public Appointment(){} 
    
    public String getDateAndTime(){
        return this.DateAndTime;
    }
    
    public void setDateAndTime(String Dateandtime) {
        this.DateAndTime = Dateandtime;
    }
    
    public String getService(){
        return this.Service;
    }
    
    public void setService(String service) {
        this.Service = service;
    }
    
    public String getPetKind(){
        return this.PetKind;
    }
    
    public void setPetKind(String Petkind) {
        this.PetKind = Petkind;
    }
    
    public String getUsername(){
        return this.Username;
    }
    
    public void setUsername(String username) {
        this.Username = username;
    }
}

