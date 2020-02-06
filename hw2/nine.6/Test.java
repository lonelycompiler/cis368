import java.util.Scanner;

public class Test {
	private int[] nums;
	int len = 1000;

	public static void main(String[] args) {
		Test test = new Test();
		Scanner sc = new Scanner(System.in);
		test.nums = new int[test.len];
		
		int i;
		for(i = 0; i < test.len; i++) {
			test.nums[i] = Integer.parseInt(sc.nextLine());
		}
		
		
		StopWatch sw = new StopWatch();
		test.selectSort();
		sw.stop();
		
		System.out.println("It took " + sw.getElapsedTime() + " miliseconds to do selection sort!");
	}
	
	private void selectSort() {
		int i;
		
		for(i = 0; i < len-1; ++i) {
			int minIndex = i;
			int j;
			
			for(j = minIndex+1; j < len; ++j) {
				if(nums[j] < nums[minIndex]) { minIndex = j; }
			}
			
			int tempNum = nums[minIndex];
			nums[minIndex] = nums[i];
			nums[i] = tempNum;
		}
    } 
}
