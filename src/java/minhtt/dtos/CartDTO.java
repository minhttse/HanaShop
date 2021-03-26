/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhtt.dtos;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author minhv
 */
public class CartDTO {
    private String customerName;
    private String orderAddress;
    private String orderDate;
    private Map<String,FoodDTO> cart;

    public CartDTO() {
    }

    public CartDTO(String customerName, String orderAddress, String orderDate, Map<String, FoodDTO> cart) {
        this.customerName = customerName;
        this.orderAddress = orderAddress;
        this.orderDate = orderDate;
        this.cart = cart;
    }

    

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public Map<String, FoodDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, FoodDTO> cart) {
        this.cart = cart;
    }
    
    public void add(FoodDTO dto){
        if(cart==null){
            this.cart=new HashMap<String,FoodDTO>();
        }
        if(this.cart.containsKey(dto.getFoodID())){
            int quantity=this.cart.get(dto.getFoodID()).getQuantity();
            dto.setQuantity(quantity+dto.getQuantity());
        }
        cart.put(dto.getFoodID(), dto);
    }
    
    public void delete(String id){
        if(this.cart==null)
            return;
        if(this.cart.containsKey(id)){
            this.cart.remove(id);
        }
    }
    
    public void updateAddress(String orderAddress){
        if(this.cart!=null){
            this.orderAddress=orderAddress;
        }
    }
    
    public void updateAmount(FoodDTO dto){
        if(this.cart!=null){
            if(this.cart.containsKey(dto.getFoodID())){
                this.cart.replace(dto.getFoodID(), dto);
            }
        }
    }
}
