package com.javatest.stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.javatest.impl.StockHelperImpl;
import com.javatest.impl.StockImpl;
import com.javatest.impl.TradeImpl;

public class StockMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Stock tea = new StockImpl("TEA", "Common", 0d, null, 100d, 110d);
        Stock pop = new StockImpl("POP", "Common", 8d, null, 100d, 120d);
        Stock ale = new StockImpl("ALE", "Common", 23d, null, 60d, 55d);
        Stock gin = new StockImpl("GIN", "Preferred", 8d, 2d, 100d, 100d);
        Stock joe = new StockImpl("JOE", "Common", 13d, null, 250d, 216.12d);
        
        List<Stock> stockList = new ArrayList<Stock>();
        stockList.add(tea);
        stockList.add(pop);
        stockList.add(ale);
        stockList.add(gin);
        stockList.add(joe);
        
        StockHelper helperimpl = new StockHelperImpl();
        
        /*
         * Below logic is to record a trade with timestamp
         */
        List<Trade> tradeList = null;
        Stock stk = null;
        Trade trade = null;
        Random rand = new Random();
        Map<Stock, List<Trade>> map = new HashMap<Stock, List<Trade>>();
        
        int trades = 0;
        
        for(int i = 0; i < trades; i++) {
        	
        	stk = stockList.get(rand.nextInt(stockList.size() - 1));
            
        	tradeList = map.get(stk);
          
            if (tradeList == null) {
              
            	tradeList = new ArrayList<Trade>();
              
                map.put(stk, tradeList);
            }
          
            trade = new TradeImpl(stk, new java.util.Date(), (rand.nextDouble()*1000d + 50d),rand.nextBoolean()?"BUY":"SELL", (rand.nextDouble()*1000d + 50d));
            
            tradeList.add(trade);
        }
        
        /**
         * The below logic which is to calculate the dividend for "Common" and "Preffered"
         */
        for(Stock stockResult : stockList){
        	
        	tradeList = map.get(stockResult);
        	
        	if(stockResult.getStockSymbol() != null){
        		System.out.println("Stock Symbol ["+stockResult.getStockSymbol()+"].");
        		if(stockResult.getStockType() == "Common"){
        			System.out.println("StockType::"+stockResult.getStockType());
        			helperimpl.calculateDividendCommon(stockResult.getParValue(), stockResult.getLastDividend());
        		}
        		if(stockResult.getStockType() == "Preferred"){
        			System.out.println("StockType ["+stockResult.getStockType()+"].");
        			helperimpl.calculateDividendPreferred(stockResult.getPrice(), stockResult.getParValue(), stockResult.getFixedDividend());
        		}
        		
        		//The below method is to calculate the P/E ratio by passing the input as parValue and lastDividend
        		helperimpl.calculatePERatio(stockResult.getParValue(), stockResult.getLastDividend());
        		
        		//Calculate the volume of stock price
        		calculateStockPrice(tradeList);
        	}
        }
   }

	public static double calculateStockPrice(List<Trade> tradeList){
    
	    if (tradeList == null) {
	        return 0;
	    }
	    double[] tradesPrices = new double[tradeList.size()];
	    double[] tradesQuantity = new double[tradeList.size()];
  
	    int  i = 0;
	    for(Trade trade : tradeList) {
	    System.out.println("Trade Price ["+trade.getPrice()+"] and TradeQuantity ["+trade.getSharesQuantity()+"].");
	    tradesPrices[i] = trade.getPrice();
        tradesQuantity[i] = trade.getSharesQuantity();
        i++;
	    }
        return calculateStockPrice(tradesPrices, tradesQuantity);
	}

	/**
	 * The below method is to calculateStockPrice by passing the tradesPrices and tradeQuantity as a parameter
	 * @param tradesPrices
	 * @param tradeQuantity
	 * @return
	 */
	public static double calculateStockPrice(double[] tradesPrice, double[] tradeQuantity){
    
	  if (tradesPrice == null || (tradesPrice != null && tradesPrice.length == 0)) {
		  return 0;
	  }
	  double pricePerQuantity = 0d;
	  double quantity = 0d;

	  for(int i = 1; i < tradesPrice.length; i++) {
		  pricePerQuantity += tradesPrice[i] * tradeQuantity[i];
		  quantity += tradeQuantity[i];
		  System.out.println("Quantity ["+quantity+"].");
	  }
	  return pricePerQuantity / quantity;
	}
	}
 
