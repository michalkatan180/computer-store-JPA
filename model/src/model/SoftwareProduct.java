/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author user1
 */
@Entity
public class SoftwareProduct extends Product implements Serializable{
    
    
    private int numberOfUsers;
    
    
    public SoftwareProduct() {
    }

    public SoftwareProduct(long id, String name, String description, float pricePerUnit,int numberOfUsers) {
        super(id, name, description, pricePerUnit);
        this.numberOfUsers = numberOfUsers;
    }
    public SoftwareProduct(long id, String name, String description) {
        super(id, name, description);
    }
    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public void setNumberOfUsers(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }
    public float getPrice(){
        return this.getPricePerUnit()+20*numberOfUsers;
    }
}
