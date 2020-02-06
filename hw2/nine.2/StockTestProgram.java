

public class StockTestProgram {
	public static void main(String[] args) {
		Stock stock = new Stock("Oracle Corporation","ORCL");
		stock.setPreviousClosingPrice(34.5);
		stock.setCurrentPrice(34.35);
		System.out.println("Change in percentage " + stock.getChangePercent() + "%");
	}
}
