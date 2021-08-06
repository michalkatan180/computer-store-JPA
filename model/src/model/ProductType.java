/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author user1
 */
public enum ProductType {
    HARDWARE(1),
    SOFTWARE(2);

    private int num;
    private ProductType(int x){
        num=x;
    }
  
}
