/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.miniclothingstore;

/**
 *
 * @author tamolefe
 */
public class cartItem {
    
    /* Cart is going to hold ALL PRODUCTS 
    */
    
    private product boughtitem;
    
    private int quantity; 

    public cartItem(product boughtitem, int quantity) {
        this.boughtitem = boughtitem;
        this.quantity = quantity;
    }
    
    public product getProduct(){
        return boughtitem;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public double getTotalPrice(){
        return boughtitem.getPrice() * quantity;
    }
}
