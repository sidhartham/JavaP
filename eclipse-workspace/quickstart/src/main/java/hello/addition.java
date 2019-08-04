package hello;

import java.util.Scanner;

public class addition {

 public static void main(String[] args) {

  int num1 ,num2 ,num3 ,sum;
  Scanner sc =new Scanner(System.in);
  System.out.println("Enter first number");
  num1 = sc.nextInt();
  
  System.out.println("Enter second number");
  num2 = sc.nextInt();
  
  System.out.println("Enter third number");
  num3 = sc.nextInt();
  
  sc.close();
  sum = (int) (num1 * Math.pow(10, 2) + num3);
  System.out.println("the sum of the three numbers is: "+sum);
 }
}
