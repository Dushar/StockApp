package com.javatest.impl;

import java.util.Date;

import com.javatest.stock.Stock;
import com.javatest.stock.Trade;

public class TradeImpl implements Trade {

	private Stock stock;
 
 	private Date timestamp;

 	private Double sharesQuantity;
 	
 	private String buyorsell;
 
 	private Double price;
 	
 	public TradeImpl() {
     
   }
 
   public TradeImpl(Stock stock,
                    Date timestamp,
                    Double sharesQuantity,
                    String buyorsell,
                    Double price) {
     
       this.stock = stock;
       this.timestamp = timestamp;
       this.sharesQuantity = sharesQuantity;
       this.buyorsell = buyorsell;
       this.price = price;
   }
 
    public Stock getStock() {
     
       return this.stock;
   }
 
   public void setStock(Stock stock) {
     
       this.stock = stock;
   }
   
    public Date getTimestamp() {
     
       return this.timestamp;
   }
 
   public void setTimestamp(Date timestamp) {
     
       this.timestamp = timestamp;
   }

   public Double getSharesQuantity() {
     
       return this.sharesQuantity;
   }
 
   public void setSharesQuantity(Double sharesQuantity) {
     
       this.sharesQuantity = sharesQuantity;
   }

   public Double getPrice() {
     
       return this.price;
   }
 
  public void setPrice(Double price) {
     
       this.price = price;
   }

   public int hashCode() {

       int hash = 1;
     
       if (this.stock != null) {
           
           hash *= this.stock.hashCode();
       }

       if (this.timestamp != null) {
           
           hash *= this.timestamp.hashCode();
       }
     
       if (this.sharesQuantity != null) {
         
           hash *= this.sharesQuantity.hashCode();
       }

       if (this.price != null) {
         
           hash *= this.price.hashCode();
       }
     
       return hash;
   }

   @Override
   public boolean equals(Object obj) {
      
       if (!(obj instanceof TradeImpl)) {
           return false;
       }

       if (obj == this) {
       
           return true;
       }
     
       Trade trade = (Trade) obj;
     
       boolean equals = true;
           
       if (this.stock != null) {
           
           equals &= this.stock.equals(trade.getStock());
       }

       if (this.timestamp != null) {
           
           equals &= this.timestamp.equals(trade.getTimestamp());
       }
     
       if (this.sharesQuantity != null) {
         
           equals &= this.sharesQuantity.equals(trade.getSharesQuantity());
       }

      if (this.price != null) {
         
           equals &= this.price.equals(trade.getPrice());
       }
     
       return equals;
   }
}
