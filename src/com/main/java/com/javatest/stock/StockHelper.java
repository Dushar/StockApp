package com.javatest.stock;

/**
 * Interface of stock calculation helpers.
 * @author Charles-Philippe Bernard
 */
public interface StockHelper {
  
  	double calculateDividendCommon(double marketPrice, double lastDividend);
  
  	double calculateDividendPreferred(double tickerPrice, double parValue, double fixedDividend);
  
  	double calculatePERatio(double tickerPrice, double lastDividend);
    
  	double calculateGeometricMean(double[] tradesPrices);

    double calculateStockPrice(double[] tradesPrices, double[] tradesQuantities);
}