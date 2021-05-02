package MathOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

@FunctionalInterface
interface ICalculator{
	public int calculate(int a, int b);
	static void printResult(int x, int y, String method, ICalculator iCalculator) {
		System.out.println(method+": ("+x+","+y+") = "+iCalculator.calculate(x, y));
	}
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
		
		ICalculator.printResult(6, 5, "Addition",add);
		ICalculator.printResult(10, 8, "Subtraction", subtract);
		ICalculator.printResult(9, 0, "Divison", divide);
		ICalculator.printResult(12, 3, "Divison", divide);
		
		List<Integer> numberPlayList = new ArrayList<>();
		System.out.println("Enter the size of the list:");
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		for(int i= 0; i<size; i++)
			numberPlayList.add(i+100);
		
		//Using Proper Class
		class MyConsumer implements Consumer<Integer> {
			public void accept(Integer t) {
				System.out.println("Traversing with Consumer interface implementation, element in the number list : "+t);
			}
		}
		MyConsumer myConsumer = new MyConsumer();
		numberPlayList.forEach(myConsumer);
		
		//Using Anonymous Class
		numberPlayList.forEach(new Consumer<Integer>() {
			public void accept(Integer t) {
				System.out.println("Using anonymous class, element in the number list : "+t);
			}
		});
		//Using Explicit Lambda Function
		Consumer<Integer> consumer = (n) -> {
			System.out.println("Using explicit lambda function, element in the number list : "+n);
		};
		numberPlayList.forEach(consumer);
		
		//Using Implicit Lambda Function
		numberPlayList.forEach((n) -> {System.out.println("Using implicit lambda function, element in the number list : "+n);});
		
	}

}
