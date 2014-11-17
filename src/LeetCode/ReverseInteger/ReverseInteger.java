package LeetCode.ReverseInteger;

/**
 * @author shhqin
 * 小心数据会溢出
 */
public class ReverseInteger {
	private boolean isMinus = false;
	final static int[] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
			99999999, 999999999, Integer.MAX_VALUE };
	final static int[] bitCountTable = { 1, 10, 100, 1000, 10000, 100000, 1000000,
			10000000, 100000000, 1000000000 };

	static int sizeOfInt(int x) {
		for (int i = 0;; i++)
			if (x <= sizeTable[i])
				return i + 1;
	}

	public static void main(String[] args) {
		ReverseInteger rint = new ReverseInteger();
		int reverse = rint.reverse(-2147483648);
		System.out.println("" + reverse);
	}

	public int reverse(int x) {
		int data = x;
		if (data < 0){
			if (data == -2147483648)
				return 0;
			isMinus = true;
			data = -data;
		}
		
		int bitCount = sizeOfInt(data);
		int sum = 0;
		int count = 0;
		
		for (int i = 0, j = bitCount-1; i < bitCount; i++, j--){
			int temp = data / bitCountTable[j];
			if (count >= 9)
				if (data > 2 || (data == 2 & sum > 147483647))
					return 0;
			sum += temp * bitCountTable[i];
			data -= temp * bitCountTable[j];
			count++;
		}
		if (isMinus)
			sum = -sum;
		
		return sum;
	}
}
