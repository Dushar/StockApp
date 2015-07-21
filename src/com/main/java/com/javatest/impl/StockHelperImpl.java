package com.javatest.impl;

import com.javatest.stock.StockHelper;

public class StockHelperImpl implements StockHelper{

	public double calculateDividendCommon(double marketPrice, double lastDividend) {
      
      	return lastDividend / marketPrice;
    }

  	public double calculateDividendPreferred(double marketPrice, double parValue, double fixedDividend) {
      
      	return (fixedDividend * parValue) / marketPrice;
    }
  
  	public double calculatePERatio(double marketPrice, double lastDividend) {
      	
      	return marketPrice / lastDividend;
    }

  	public double calculateGeometricMean(double[] tradesPrices) {
      
        if (tradesPrices == null || (tradesPrices != null && tradesPrices.length == 0)) {
            
            return 0d;
        }
      
        double geometricMean = tradesPrices[0];
      
        for(int i = 1; i < tradesPrices.length; i++) {
          
            geometricMean *= tradesPrices[i];
        }
      
        Integer n = new Integer(tradesPrices.length);
      
        return Math.pow(geometricMean, 1.0d / n.doubleValue());
    }
  
    public double calculateStockPrice(double[] tradesPrices, double[] tradesQuantities) {
      
		  if (tradesPrices == null || (tradesPrices != null && tradesPrices.length == 0)) {
            
            return 0d;
        }
      
		  double pricesPerQuantities = 0d;
          double quantities = 0d;
      
        for(int i = 1; i < tradesPrices.length; i++) {
          
            pricesPerQuantities += tradesPrices[i] * tradesQuantities[i];
          
            quantities += tradesQuantities[i];
        }
      
        return pricesPerQuantities / quantities;
    }

	
	
}
