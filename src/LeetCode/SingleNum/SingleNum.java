package LeetCode.SingleNum;

public class SingleNum {
	
	public static void main(String[] args){
		int[] A = {2,5,7,9,8,8,5,9,2};
		SingleNum singleNum = new SingleNum();
		int result = singleNum.singleNumber(A);
		System.out.println(""+result);
	}
	
	public int singleNumber(int[] A) {
		java.util.Map map = new java.util.HashMap();
		
		for (int i = 0; i < A.length; i++){
			if(map.containsKey(A[i])){
				map.remove(A[i]);
			} else {
				map.put(A[i], A[i]);
			}
		}
		
		java.util.Collection values = map.values();
		int i = 0;
		for (Object obj : values){
			i = (int)obj;
		}
		
		return i;
	}
}