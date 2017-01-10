package transition.technologies.unittesting.basic.calculator;

import static org.junit.Assert.*;

import junitparams.JUnitParamsRunner;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(JUnitParamsRunner.class)
public class SimpleCalculatorTest {

	private SimpleCalculator sut;

	@Before
	public void initialize(){
		sut = new SimpleCalculator();
	}

	@Test
	//@Parameterized.Parameters({"1.0, 2.0, 3.0", "2.0, 3.0, 5.0", "3.0, 5.0, 8.0"})
	public void shouldAddTwoPositiveNumbers(double first, double second, double expectedResult){
		//given
		initialize();
		//when
		double result = sut.add(first, second);
		//then
		assertEquals(expectedResult, result, 0.00001);
	}

	@Test
	public void shouldSubstractTwoPositiveNumbers(){
		//given
		initialize();
		//when
		double result = sut.substract(9, 3);
		//then
		assertEquals(6, result, 0.00001);
	}

	@Test
	public void shouldDivideTwoPositiveNumbers() throws CannotDivideByZeroException{
		//given
		initialize();
		//when
		double result = sut.divide(12, 4);
		//then
		assertEquals(3, result, 0.00001);
	}

	@Test
	public void shouldCalculateSquareRootPositiveNumbers() throws CannotCalculateSquareRootOfNegativeNumber{
		//given
		initialize();
		//when
		double result = sut.calculateSquareRoot(3);
		//then
		assertEquals(9, result, 0.00001);
	}
	
}
