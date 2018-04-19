package tddd05_lab2;

public class Stock {
	private long price;
	
	public Stock (long price){
		this.price = price;
	}
	
	public long getPrice (){
		return price;
	}

	public boolean priceCheck (long mrkPrice){
		if (price == mrkPrice)
			return true;
		
		return false;
	}
}
