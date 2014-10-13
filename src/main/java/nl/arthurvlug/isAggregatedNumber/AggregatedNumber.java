package nl.arthurvlug.isAggregatedNumber;

import java.math.BigInteger;

public class AggregatedNumber {
	public boolean testNumber(String number) {
		if (number.length() <= 2) {
			return true;
		}

		// Find j: the position of the second pointer
		for(int j = 1; j < number.length() - 1; j++) {
			String number1String = number.substring(0, j);
			if (number1String.length() > 1 && number1String.charAt(0) == '0') {
				// A non-zero number should not start with a zero
				continue;
			}
			BigInteger number1 = new BigInteger(number1String);

			// Find jLength: The length of the second value
			for(int jLength = j; jLength < number.length() - j; jLength++) {
				String number2String = number.substring(j, j + jLength);
				if (number2String.length() > 1 && number2String.charAt(0) == '0') {
					// A non-zero number should not start with a zero
					continue;
				}
				BigInteger startTwo = new BigInteger(number2String);

				// Check if the combination {j, jLength} results in an aggregated number
				if (check(number1, startTwo, number.substring(number1String.length() + number2String.length()))) {
					return true;
				}
			}
		}
		
		// We did not find any valid combination of {j, jLength}: return false
		return false;
	}

	private boolean check(BigInteger number1, BigInteger startTwo, String numberSubstring) {
		if (numberSubstring.isEmpty()) {
			// We are finished
			return true;
		}

		// What do we expect next? The previous two numbers added
		BigInteger expected = number1.add(startTwo);
		String expectedString = expected + "";
		if (!numberSubstring.startsWith(expectedString)) {
			// The next number was not found: the sequence is not an aggregated number
			return false;
		}

		// Do recursion on the rest of the string
		String newNumberSubstring = numberSubstring.substring(expectedString.length());
		return check(startTwo, number1.add(startTwo), newNumberSubstring);
	}
}
