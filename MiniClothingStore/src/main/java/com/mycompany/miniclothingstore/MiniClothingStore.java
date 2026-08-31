/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.miniclothingstore;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tamolefe
 */
public class MiniClothingStore {
/* Class example based on "Mr Price".
    
    We'll use an interface (the "contract" our classes must use)
    An abstract class -> to "structure our classes".
    
    The logic is that, a person can pick clothes, add them to a cart
    and then "checkout". Upon checkout, they get a "receipt"
    
    */
    
    ArrayList<product> stockItems = new ArrayList();
    ArrayList<cartItem> shoppingCart = new ArrayList();
    
    Scanner input = new Scanner(System.in);

    public MiniClothingStore() {
        
        stockItems.add(new clothingItem("TS00","Nike T-Shirt",349.99,100,"M","Polyester","Red"));
        stockItems.add(new clothingItem("SH00","Adidas Samba",1499.99,30,"7","Suede","Brown"));
        stockItems.add(new clothingItem("SC00","Socks",69.99,4,"L","Nylon","White"));
        stockItems.add(new clothingItem("LJ00","Levis Jeans",799.99,40,"M","Cotton,Polyester & Elastane","Blue"));     
    }
    
    public static void main(String[] args) {
        
        MiniClothingStore store = new MiniClothingStore();
        
        store.Menu();
    }
    
    public void Menu()
    {
        int choice = 0;
        do
        {
            System.out.println("*".repeat(8) + "Dashin Clothing" + "*".repeat(8));
            
            System.out.println("1. View Stock");
            System.out.println("2. Add to cart");
            System.out.println("3. View cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            
            //first try-catch (intro to exception handling
            
            try{
                
                choice = Integer.parseInt(input.nextLine());
                switch(choice){
                    case 1: viewStock();
                    break;
                    case 2: addToCart();
                    break;
                    case 3: viewCart();
                    break;
                    case 4: checkout();
                    break;
                    case 5:
                        for(cartItem item : shoppingCart)
                        {
                            item.getProduct().addStock(item.getQuantity());
                            System.out.println(item.getProduct().getName() + "Is back in stock" + "\n"
                            + item.getQuantity() + " items");
                        }
                        System.out.println("Goodbye");
                    break;
                    default:System.out.println("Enter valid choice (1-5)");
                            
                }                
            }
            catch(Exception e)
            {
              System.out.println(e);
            }
        }
        while(choice != 5);
    }
    
    private void viewStock()
    {
        System.out.println("Stock view");
        for(product prod : stockItems)
        {
            System.out.println(prod);
        }
    }
    
    private void addToCart()
    {
        viewStock();
        System.out.println("Enter product ID: ");
        String productId = input.nextLine().trim();
        
        product selectedProduct = null;
        
        for(product prod: stockItems)
        {
            if(prod.getId().equalsIgnoreCase(productId))
            {
               selectedProduct = prod;
               //return;
               break;
            }
        }
        if(selectedProduct == null)
        {
            System.out.println("Product not found");
            return;
        }
        
        System.out.println("Enter quantity: ");
        //int quantity = input.nextInt();
        int quantity = Integer.parseInt(input.nextLine());
        
        if(quantity <= 0)
        {
            System.out.println("Enter a valid number");
            return;
        }
        
        if(quantity > selectedProduct.stock())
        {
            System.out.println("We only have " + selectedProduct.stock()
            + " items in stock");
            return;
        }
        
        selectedProduct.reduceStock(quantity);
        
        cartItem newItem = new cartItem(selectedProduct, quantity);
        shoppingCart.add(newItem);
        
    }
         
    
    
   private void viewCart()
{
    System.out.println("-".repeat(8) + "Shopping Cart " + "-".repeat(8));

    if(shoppingCart.isEmpty())
    {
        System.out.println("Shopping cart is empty. Add items to cart");
        return;
    }

    double cartTotal = 0.0;

    for(cartItem item: shoppingCart)
    {
        product cartProduct = item.getProduct();

        System.out.println("ID: " + cartProduct.getId()
                + " Name: " + cartProduct.getName()
                + " x " + item.getQuantity()
                + " Total: R" + String.format("%.2f", item.getTotalPrice()));

        cartTotal += item.getTotalPrice();
    }

    System.out.println("Cart Total: R" + String.format("%.2f", cartTotal));

    if(cartTotal >= 2999.99)
    {
        double discount = cartTotal * 0.10;
        double finalTotal = cartTotal - discount;

        System.out.println("You got a 10% discount!");
        System.out.println("Discount Amount: R" + String.format("%.2f", discount));
        System.out.println("Final Cart Total: R" + String.format("%.2f", finalTotal));
    }
    else
    {
        double amountNeeded = 2999.99 - cartTotal;

        System.out.println("You are missing out on a 10% discount!");
        System.out.println("Add R" + String.format("%.2f", amountNeeded)
                + " to qualify for the discount.");
    }
}
    
    private void checkout()
    {
        System.out.println("=".repeat(8) + "Dashin Clothing Receipt" + "=".repeat(8));
        
        if(shoppingCart.isEmpty())
        {
            System.out.println("Your cart is empty.");
        }
        
        double finalAmount = 0.0;
       
        for(cartItem item: shoppingCart)
        {
            product checkoutProd = item.getProduct();
            System.out.println(">" + checkoutProd.getName() + " x " + item.getQuantity()
            + " R" + item.getTotalPrice());
            
            finalAmount += item.getTotalPrice();
           
        }
        
        System.out.println("-".repeat(25)+ "");
        System.out.println("Amount Due: R" + finalAmount);
        System.out.println("-".repeat(25)+ "");
        
        System.out.println("Thank you. Come again");
        
        shoppingCart.clear();
    }
    
}
