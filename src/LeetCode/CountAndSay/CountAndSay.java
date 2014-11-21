package LeetCode.CountAndSay;

public class CountAndSay {
	public static void main(String[] args){
		CountAndSay countAndSay = new CountAndSay();
		String s = countAndSay.countAndSay(30);
		System.out.println(s);
	}
	
	public String countAndSay(int n) {
		String result = "1, ";
		String num = "1";
		String newNum = "";
		char temp;
		int count = 0;
		
		if (n == 0)
			return "";
		for (int i = 0; i < n - 1; i++){ // 控制计算至第几个串
			
			int numLength = num.length();
			for (int j = 0; j < numLength;) {// 每个串的处理
				temp = num.charAt(j);
				while (j < numLength) {
					if (temp == num.charAt(j++))
						count++;
					else {
						j--;
						break;
					}
				}
				result += count + "" + temp;
				newNum += count + "" + temp;
				count = 0;
			}
			num = newNum;
			newNum = "";
			result += ", ";
		}
		result = result.substring(0,result.length()-2);
        return result;
    }
}
