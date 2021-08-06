/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author user1
 */
//TODO function to add proudct/s for arrayList
@Entity
public class Customer implements Serializable {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="cust_id")
    private long id;

    private String name;
    private String adress;
    //public String reflectionStam = "stam";

    public Customer(long id, String name, String adress) {
        this.id = id;
        this.name = name;
        this.adress = adress;
    }

    public Customer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return name + ", " + id;
    }

    @Override
    public boolean equals(Object obj) {
        Customer c = (Customer) obj;
        return c.getId() == id && c.getAdress() == adress && c.getName() == name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.adress);
        return hash;
    }

}
