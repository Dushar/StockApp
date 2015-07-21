package com.javatest.stock;

import java.util.Date;

public interface Trade {

	    Stock getStock();
	    void setStock(Stock stock);
	    Date getTimestamp();
	    void setTimestamp(Date timestamp);
	    Double getSharesQuantity();
	    void setSharesQuantity(Double sharesQuantity);
	    Double getPrice();
	    void setPrice(Double price);
}
