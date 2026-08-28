/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.miniclothingstore;

/**
 *
 * @author tamolefe
 */
public class clothingItem extends product {
    
    //Attributes specific to clothing items 
    
    private String size;
    private String material;
    private String colour;
    
    
    public clothingItem(String id, String name, double price, int stock, String _size,
            String _material, String _colour) {
        super(id, name, price, stock);
        
        this.size = _size;
        this.material = _material;
        this.colour = _colour;
    }

    public String getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    public String getColour() {
        return colour;
    }

    @Override
    public String toString() {
       return  id +" " + name +" " + price +" " + stock +" " + size  +" "+ material +" " + colour;
        
        /*instead of printing our class details as a normal string
        with System.out.println -> we choose how we want our clothingItem 
        to be displayed.
        */   
    }
    
    
    
}
