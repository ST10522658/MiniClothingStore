/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.miniclothingstore;

/**
 *
 * @author tamolefe
 */
public interface selling {
    
    /*this interface is a contract that tells all the classes 
    that "want to sell" products that "you must behave in this manner"
    i.e. in this context behaviour refers to methods*/
    
    /* Things we need to know about products that can be sold
    
    Must have a barcode = ID
    Must have stock = quantity
    Must have price 
    Must have a name
    
    */
    
    
    String getId(); //People must reason on Thursday (ID to track the product)
    String getName(); //we need to know what product we are selling
    double getPrice(); //how much does it cost? will be useful for the receipt
    
    int stock(); /*to know our quantity (we need to know how much is left
     when people buy (stock on hand is reduced) and we need to know
    how much we added if there's a restock (stock on hand is increased)*/
    
    void reduceStock(int quantity); //the number of items being sold
    //or bought by the customer 
    
    void addStock(int quantity);// the number of items we're "restocking"
    
    
    
    
}
