package arrayPac;

public class ArrayTest3 {

	public static void main(String[] args) {
		char[] hex = new char[] { 'C', 'A', 'F', 'E', '2', '0', '2', '3' };
		String[] binary = new String[] { "0000", "0001", "0010", "0011", // 0 1 2 3
				"0100", "0101", "0110", "0111", // 4 5 6 7
				"1000", "1001", "1010", "1011", // 8 9 A(10) B(11)
				"1100", "1101", "1110", "1111" // C(12) D(13) E(14) F(15)
		};

		String result = "";

		// '0' -> 0000 : binary[0]
		// '1' -> 0001 : binary[1]
		// '9' -> 1001 : binary[9]
		// 'A' -> 1010 : binary[10] 9 + 'A' - 'A' + 1 => 10
		// 'F' -> 1111 : binary[15] 9 + 'F' - 'A' + 1 => 15 (F:69 - A:65 = 4)

		for (int i = 0; i < hex.length; i++) {
			char ch = hex[i];
			if (ch >= '0' && ch <= '9')
				result += binary[ch - '0'];
			else
				result += binary[10 + ch - 'A'];
		}

		System.out.println("hex: " + new String(hex));
		System.out.println("binary: " + result);
	}
}

// ��°��
// hex: CAFE2023
// binary: 11001010111111100010000000100011