package com.javatest.stock;

public interface Stock {

	String getStockSymbol();
	void setStockSymbol(String stockSymbol);
	String getStockType();
	void setStockType(String stockType);
	Double getLastDividend();
	void setLastDividend(Double lastDividend);
	Double getFixedDividend();
	void setFixedDividend(Double fixedDividend);
	Double getParValue();
	void setParValue(Double parValue);
	Double getPrice();
	void setPrice(Double price);	
}
