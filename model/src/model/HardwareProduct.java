/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author user1
 */
@Entity
public class HardwareProduct extends Product implements Serializable {

    
    private int intWarrantyPeriod;//שנות אחריות

    public HardwareProduct(long id, String name, String description, float pricePerUnit, int intWarrantyPeriod) {
        super(id, name, description, pricePerUnit);
        this.intWarrantyPeriod = intWarrantyPeriod;
    }
 public HardwareProduct() {
    }
    public HardwareProduct(long id, String name, String description) {
        super(id, name, description);
    }

    public int getIntWarrantyPeriod() {
        return intWarrantyPeriod;
    }

    public void setIntWarrantyPeriod(int intWarrantyPeriod) {
        this.intWarrantyPeriod = intWarrantyPeriod;
    }

    public float getPrice() {
        return intWarrantyPeriod * 10F + this.getPricePerUnit();
    }

   

}
