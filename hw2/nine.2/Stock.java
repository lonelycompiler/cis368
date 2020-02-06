

public class Stock {
	
	private String symbol;
	private String name;
	
	private double previousClosingPrice;
	private double currentPrice;
	
	public Stock(String symbol, String name) {
		this.symbol = symbol;
		this.name = name;
	}
	
	public void setPreviousClosingPrice(double prevPrice) {
		this.previousClosingPrice = prevPrice;
	}
	
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}
	
	public double getChangePercent() {
		return ((this.currentPrice - this.previousClosingPrice)/this.previousClosingPrice)*100;
	}
}
