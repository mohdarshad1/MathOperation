package MathOperation;

@FunctionalInterface
interface ICalculator{
	public int calculate(int a, int b);
}

public class MathApp {

	public static void main(String[] args) {
		System.out.println("Welcome to Math Application Program");
		
		ICalculator add = (a,b) -> a+b;
		ICalculator subtract = (a,b) -> a-b;
		ICalculator divide = (a,b) -> { 
										try { 
											return a/b;
										}catch(ArithmeticException e) {
											return 0;
										}
									};
		
		System.out.println("Addition of 6 and 5 is "+add.calculate(6,5));
		System.out.println("Subtraction of 8 from 10 is "+subtract.calculate(10,8));
		System.out.println("Divison of 9 by 0 is "+divide.calculate(9,0));
		System.out.println("Divison of 12 by 3 is "+divide.calculate(12,3));
	}
}