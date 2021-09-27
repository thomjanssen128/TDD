package nl.thom.tdd;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {

    @Test
    public void CalcGetsNoNumbersItReturnsZero() {
        StringCalculator sc = new StringCalculator();
        int zero = sc.add("");
        assertEquals(0, zero);
    }

    @Test
    public void CalcGetsOneNumberItReturnsThatNumber() {
        StringCalculator sc = new StringCalculator();
        int three = sc.add("3");
        assertEquals(3, three);
        int big = sc.add("543");
        assertEquals(543, big);
    }

    @Test
    public void CalcGetTwoCommaSeperatedNumbersItReturnsTheSum() {
        StringCalculator sc = new StringCalculator();
        int ten = sc.add("2,8");
        assertEquals(10, ten);
    }

    @Test
    public void CalcGetMultiCommaSeperatedNumbersItReturnsTheSum() {
        StringCalculator sc = new StringCalculator();
        int threesum = sc.add("2,8,100");
        assertEquals(110, threesum);
    }

    @Test
    public void CalcGetMultiLinefeedSeperatedNumbersItReturnsTheSum() {
        StringCalculator sc = new StringCalculator();
        int threesum = sc.add("10\n10\n44");
        assertEquals(64, threesum);
    }

    @Test
    public void CalcGetMultiMixSeperatedNumbersItReturnsTheSum() {
        StringCalculator sc = new StringCalculator();
        int mixed = sc.add("//1/2,     **** 3 4\n 5;6");
        assertEquals(21, mixed);
    }

    @Test(expected = IllegalArgumentException.class)
    public void CalcGetNegativeNumbersThrowsException() {
        StringCalculator sc = new StringCalculator();
        sc.add("1 2 -3");

    }

    @Test
    public void CalcGetNegativeNumbersThrowsExceptionWithThoseNegativeNumbersInTheMessage() {
        StringCalculator sc = new StringCalculator();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> sc.add("1 2 -3;20\n-90"));
        // System.out.println(e.getMessage());
        assertTrue((e.getMessage().contains("Negatives not allowed -3 -90")));

    }

    @Test
    public void CalcShouldIgnoreNumbersAbove1000() {
        StringCalculator sc = new StringCalculator();
        int r = sc.add("1 2 3 1001");
        assertEquals(6, r);
    }

    @Test
    public void CalcGetAllKindsOfDelimitersJustTakesTheNumbersAndSumsThemUp() {
        StringCalculator sc = new StringCalculator();
        int x = sc.add("//[***]\\n1***2***3");
        assertEquals(6, x);
    }

    @Test
    public void CalcGetsNonNumericalValuesAndIgnoresThem() {
        StringCalculator sc = new StringCalculator();
        int x = sc.add("1 # 2 3 4 5 boo 6 7 :) 8 9");
        assertEquals(45, x);

    }

}