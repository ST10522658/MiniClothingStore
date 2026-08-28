/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.miniclothingstore;

/**
 *
 * @author tamolefe
 */


/* since this is a mini clothing store.
The product class will determine behaviour for all other sub-classes.

Think of it this way| The stores sells "products" (from a selling point, it doesn't matter 
whether the product is a shirt/ pants / caps etc. THEY ARE ALL Products.

Now if we have more than one product (i.e. subclass.) they should all behave the same
This is why we will make use of an ABSTRACT class. To lay-out the structure for our classes.

*/
public abstract class product implements selling {
    
    protected String id;
    protected String name;
    protected double price;
    protected int stock;

    /*
    Our product class will make use of a parameterised constructor 
    for initialisation. This means -> when creating an instance of a product 
    it must have, an ID, Name, Price and Stock.
    
    */
    public product(String id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    /*dynamically fetching class attributes.
      this is necessary when the class object will be called outside
      the parent class.
    
    NOTE: ALL of these are just the interface methods 
    */
    
    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
    
    @Override
    public int stock() {
        return stock;
    }
    
    @Override
    public void reduceStock(int quantity){
        this.stock -= quantity; // stock = stock - quantity
        //assignment decrement operator (-=)
    }
    
    @Override
    public void addStock(int quantity){
        this.stock += quantity;// stock = stock + quantity
        // assignment increment operator (+=)
    }
   
    /*we want subclasses to define how they are displayed.
    meaning: the output of the clothingItem class should
    be specific to clothingItem.
    
    If we create a second class. The output of that class should also
    be specific to it.
    */
    
    @Override
    public abstract String toString();
     
}
