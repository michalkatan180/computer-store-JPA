/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Customer;
import model.HardwareProduct;
import model.Product;
import model.PurchaseOrder;
import model.SoftwareProduct;

/**
 *
 * @author student
 */
public class Backend_DAO_List implements Backend {

    private EntityManagerFactory emf;
    private EntityManager em;
    private static Backend_DAO_List singelton;

    public static Backend_DAO_List GetBackend_DAO_List() {
        if (singelton == null) {
            singelton = new Backend_DAO_List();
        }
        return singelton;
    }

    private void init() {

    }

    private Backend_DAO_List() {
        // init();
        emf = Persistence.createEntityManagerFactory("modelPU");
        em = emf.createEntityManager();
    }

    //הוספת אובייקט לטבלה
    public void Persist(Serializable s) {
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void AddCustomer(Customer c) throws Exception {
        Persist(c);
    }

    @Override
    public void AddProduct(Product c) throws Exception {
        Persist(c);
    }

    public HashMap<Long, Customer> getAllCustomers() throws Exception {
        List resultList = em.createQuery("select c from Customer c").getResultList();
        HashMap<Long, Customer> tmp = new HashMap<>();
        for (int i = 0; i < resultList.size(); i++) {
            tmp.put(
                    ((Customer) (resultList.get(i))).getId(),
                    (Customer) resultList.get(i)
            );
        }
        return tmp;
    }

    @Override

    public HashSet<Product> getAllProducts() throws Exception {
        List resultList = em.createQuery("select p from Product p").getResultList();
        HashSet<Product> tmp = new HashSet<Product>();
        for (int i = 0; i < resultList.size(); i++) {
            tmp.add((Product) resultList.get(i));
        }
        return tmp;
    }

    @Override
    public void PlaceOrder(PurchaseOrder po) throws Exception {//הוספת הזמנה
        Persist(po);
    }

    @Override
    public void RemoveProduct(Product c) throws Exception {
        em.getTransaction().begin();
        Product p = em.find(Product.class, c.getId());
        em.remove(p);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public ArrayList<Product> getCustomersOrders(Customer c) throws Exception {
        List resultList = em.createQuery("select po.productList from PurchaseOrder as po where po.orderingCustomer =?1")
                .setParameter(1, c).getResultList();
        //em.close();
        ArrayList<Product> tmp = new ArrayList<Product>();
        for (int i = 0; i < resultList.size(); i++) {
            tmp.add((Product) (resultList.get(i)));
        }
        return tmp;
    }

    @Override
    public Float CalcProductsTotalCost(Product[] products) throws Exception {
        Float sum = 0F;
        for (Product p : products) {
            sum += p.getPrice();
        }
        return sum;
    }
}
