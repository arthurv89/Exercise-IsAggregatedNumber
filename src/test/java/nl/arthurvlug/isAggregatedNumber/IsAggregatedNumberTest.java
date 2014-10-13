package nl.arthurvlug.isAggregatedNumber;

import static org.junit.Assert.*;

import org.junit.Test;

public class IsAggregatedNumberTest {
	private AggregatedNumber numberChecker = new AggregatedNumber();

	@Test
	public void testFibSimple() {
		boolean test = numberChecker.testNumber("112");
		assertTrue(test);
	}

	@Test
	public void testLengthTwo() {
		boolean test = numberChecker.testNumber("11");
		assertTrue(test);
	}

	@Test
	public void testFibMediumPrependNine() {
		boolean test = numberChecker.testNumber("911235813");
		assertFalse(test);
	}

	@Test
	public void testSkip() {
		boolean test = numberChecker.testNumber("1012");
		assertFalse(test);
	}

	@Test
	public void testZero() {
		boolean test = numberChecker.testNumber("000");
		assertTrue(test);
	}

	@Test
	public void testFibZeroes() {
		boolean test = numberChecker.testNumber("00000000000");
		assertTrue(test);
	}

	@Test
	public void testZeroTwo() {
		boolean test = numberChecker.testNumber("022461016264268110178");
		assertTrue(test);
	}

	@Test
	public void testZeroTwenty() {
		boolean test = numberChecker.testNumber("02020406010016026042068011001780");
		assertTrue(test);
	}

	@Test
	public void testFibMedium() {
		boolean test = numberChecker.testNumber("11235813");
		assertTrue(test);
	}

	@Test
	public void testFibWrong() {
		boolean test = numberChecker.testNumber("113");
		assertFalse(test);
	}

	@Test
	public void testFibDoubleDigits() {
		boolean test = numberChecker.testNumber("122436");
		assertTrue(test);
	}

	@Test
	public void testFibDoubleDigits2() {
		boolean test = numberChecker.testNumber("1299111210");
		assertTrue(test);
	}

	@Test
	public void testFibTripleDigits() {
		boolean test = numberChecker.testNumber("112112224");
		assertTrue(test);
	}

	@Test
	public void testFibSingleDoubleDigits() {
		boolean test = numberChecker.testNumber("11011213253");
		assertTrue(test);
	}

	@Test
	public void testFibNonGreedy() {
		boolean test = numberChecker.testNumber("1125126");
		assertTrue(test);
	}

	@Test
	public void testFibWrong2() {
		boolean test = numberChecker.testNumber("11251265");
		assertFalse(test);
	}

	@Test
	public void testMediumInitials() {
		boolean test = numberChecker.testNumber("100000100000200000");
		assertTrue(test);
	}

	@Test
	public void testFibLong() {
		boolean test = numberChecker.testNumber("011235813213455891442333776109871597258441816765");
		assertTrue(test);
	}

	@Test
	public void testFibHuge() {
		boolean test = numberChecker.testNumber("0112358132134558914423337761098715972584418167651094617711286574636875025121393196418317811");
		assertTrue(test);
	}
	
	@Test
	public void testGigangtic() {
		boolean test = numberChecker.testNumber("011235813213455891442333776109871597258441816765109461771128657463687502512139319641831781151422983204013462692178309352457857028879227465149303522415781739088169632459861023341551655801412679142964334944377014087331134903170183631190329712150734807526976777874204912586269025203650110743295128009953316291173862675712721395838624452258514337173654352961625912867298799567220260411548008755920250473078196140527395378816557470319842106102098577231716768017756527777890035288449455702128537272346024814111766903046099419039249070913530806152117012949845401187926480651553304939313049695449286572111485077978050341645462290670755279397008847578944394323791464");
		assertTrue(test);
	}
}
