/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author user1
 */
@Entity
public class PurchaseOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne//הרבה הזמנות לאותו לקוח
    private Customer orderingCustomer;

    @OneToMany//הזמנה אחת למלא מוצרים
    private List<Product> productsList;

    // @Temporal(TemporalType.DATE)
    private LocalDate orderDate;

    public PurchaseOrder() {
    }

    public PurchaseOrder(Customer orderingCustomer) {
        this.orderingCustomer = orderingCustomer;
        this.orderDate = LocalDate.now();
    }

    public Customer getOrderingCustomer() {
        return orderingCustomer;
    }

    public void setOrderingCustomer(Customer orderingCustomer) {
        this.orderingCustomer = orderingCustomer;
    }

    public ArrayList<Product> getProductsList() {
        ArrayList<Product> tmp = new ArrayList<>();

        for (int i = 0; i < productsList.size(); i++) {
            tmp.add(productsList.get(i));
        }
        return tmp;
    }

    public void setProductsList(ArrayList<Product> productsList) {
        this.productsList = productsList;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "the PurchaseOrder is: {" + "orderingCustomer=" + orderingCustomer + ", orderDate=" + orderDate + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 13 * hash + Objects.hashCode(this.orderingCustomer);
        hash = 13 * hash + Objects.hashCode(this.productsList);
        hash = 13 * hash + Objects.hashCode(this.orderDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PurchaseOrder other = (PurchaseOrder) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.orderingCustomer, other.orderingCustomer)) {
            return false;
        }
        if (!Objects.equals(this.productsList, other.productsList)) {
            return false;
        }
        if (!Objects.equals(this.orderDate, other.orderDate)) {
            return false;
        }
        return true;
    }

}
