
/**
 * BitBase,位运算工具
 * 
 * @author Administrator
 *
 */
public class BitBase {

	/**
	 * 打印
	 * 
	 * @param x
	 */
	public static void out(String x) {
		System.out.println(x);
	}

	/**
	 * 10进制转2进制
	 * 
	 * @param i
	 * @return
	 */
	public static String toBinary(int i) {
		return Integer.toBinaryString(i);
		// return Long.toBinaryString(i);
	}

	/**
	 * 补缺 fillAVacancy 10 = 00000010
	 */
	public static String to8(String binaryString) {
		return toBinary(1 << 8 - binaryString.length()).substring(1) + binaryString;
	}

	public static String to32(String binaryString) {
		String result = toBinary(1 << 32 - binaryString.length()).substring(1) + binaryString;
		// return result;

		StringBuffer _result = new StringBuffer();

		for (int i = 0; i < result.length(); i++) {
			_result.append((i + 1) % 4 == 0 ? result.charAt(i) + " " : result.charAt(i));
		}
//		 return _result.toString();

		_result = new StringBuffer();
		for (int i = 0; i < result.length(); i += 4) {
			_result.append(result.substring(i, i + 4) + " ");
		}
		return _result.toString();

	}

	public static String to32(int n) {
		StringBuffer result = new StringBuffer();
		for (int i = 31; i >= 0; i--) {
			if ((n & (1 << i)) != 0) {
				result.append("1");
			} else {
				result.append("0");
			}
			if ((32 - i) % 8 == 0) {
				result.append(" ");
			}
		}
		return result.toString();
	}
	
}
