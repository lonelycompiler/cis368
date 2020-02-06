

public class Location {

	public int row;
	public int column;
	
	public double maxValue;
	
	public static Location locateLargest(double[][] array) {
		Location roc = new Location();
		roc.row = 0; roc.column = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j =0; j < array[0].length; j++) {
				if(array[roc.row][roc.column] < array[i][j]) {
					roc.row = i; roc.column = j;
				}
			}
		}
		
		roc.maxValue = array[roc.row][roc.column];
		return roc;
	}
}
