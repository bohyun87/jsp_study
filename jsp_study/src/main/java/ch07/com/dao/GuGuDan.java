package ch07.com.dao;

public class GuGuDan {
	public int[] process(int n) {
		int arr[] = new int[9];
		
		for(int i=1; i<=9; i++) {
			arr[i-1] = n * i ;  //인덱스번호는 0 부터 시작이므로 i-1
		}
		return arr;
	}
}
