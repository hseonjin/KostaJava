package arrayPac;

public class ArrayTest4 {

	public static void main(String[] args) {
		String hex = "13A0C";
		String[] binary = new String[] { "0000", "0001", "0010", "0011", // 0 1 2 3
				"0100", "0101", "0110", "0111", // 4 5 6 7
				"1000", "1001", "1010", "1011", // 8 9 A(10) B(11)
				"1100", "1101", "1110", "1111" // C(12) D(13) E(14) F(15)
		};

		String result = "";

		for (int i = 0; i < hex.length(); i++) {
			char ch = hex.charAt(i);

			if (ch >= '0' && ch <= '9') {
				result += binary[ch - '0'];
			} else {
				result += binary[9 + ch - 'A' + 1];
			}
		}
		System.out.println("hex: " + hex);
		System.out.println("binary: " + result);
	}

}

// ��°��
// hex: 13A0C
// binary: 00010011101000001100