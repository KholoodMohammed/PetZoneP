/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package approject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author rooof
 */
    @Entity
@Table(name="PERSON")
public class person  implements java.io.Serializable  {
     @Id
          @Column(name="fname")
     private String fname;
       @Column(name="lname")
     private String lname;
     @Column(name="uname")
     private String uname;
       @Column(name="email")
     private String email;
          @Column(name="password")
     private String password;
              @Column(name="gender")
     private String gender;
                  @Column(name="dateofbirth")
     private String dateofbirth;
                 
    public person() {
       
    }
    
     public person(String fname, String lname,String uname,String email,String password,String gender,String dateofbirth) {
     this.fname=fname;
     this.lname=lname;
     this.uname=uname;
     this.email=email;
     this.password=password;
     this.gender=gender;
     this.dateofbirth=dateofbirth;
    
     } 

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

 
    public String getDateofbirth() {
        return dateofbirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    



    }
     
    

