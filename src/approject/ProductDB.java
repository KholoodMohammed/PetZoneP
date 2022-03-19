/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package approject;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author hp
 */
 
@Entity
@Table(name="PRODUCT")
public class ProductDB {
    
    
     @Id
     @Column(name="productid")
     private int productid;
     @Column(name="proname")
     private String proname;
     @Column(name="proprice")
     private int proprice;    
     @Column(name="usern")
     private String usern;

    public ProductDB(int productid, String proname, int proprice, String usern) {
        this.productid = productid;
        this.proname = proname;
        this.proprice = proprice;
        this.usern = usern;
    }

    public ProductDB() {
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public int getProprice() {
        return proprice;
    }

    public void setProprice(int proprice) {
        this.proprice = proprice;
    }

    public String getUsern() {
        return usern;
    }

    public void setUsern(String usern) {
        this.usern = usern;
    }

    
    
    
}
