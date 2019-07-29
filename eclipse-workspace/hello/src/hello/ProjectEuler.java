package hello;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class ProjectEuler{
	/*public static void main (String[] args){
		ProjectEuler PE = new ProjectEuler();
		double x;
		for(int i = 0 ; i < 10 ; i++)
			PE.normald(0 , 1);
		x = PE.sqrt();
		System.out.println(x);
	}*/
	
	
	public int[] divisors(int n){
		int NoOfFactors = 0;
		for(int i = 2 ; i <= n ; i++){
			if(n % i == 0)
				NoOfFactors ++;
		}
		int factors[] = new int[NoOfFactors];
		int index = 0;
		for(int i = 2 ; i <= n ; i++){
			if(n % i == 0){
				factors[index] = i;
				index ++;
			}
		}
		return factors;
	}
	public double sqrt(){
		double n =100  , sqrt = 0;
		for(double i = 0 ; i <= n ; i = i + 0.01){
			if(Math.abs(i * i - n) <= 0.02 )
				sqrt = i;
			else
				continue;
		}
		return sqrt;
	}
	public boolean[] sieveOE(int n){
		int x = 0;
		boolean numbers[] = new boolean[n+1];//create a boolean array
		
		for (int i = 0; i < n ; i++){
			numbers[i] = true;//set all the members of array as true
		}
		for (int p = 2; p*p <= n; p++){//for a number that is less than square root of the n
			if(numbers[p] == true){//if it is true
				for (int i = 2 * p ; i <= n; i += p){//for all the multiples of that p
					numbers[i] = false;//make them false and select the next true number 
				}
			}
		}
		numbers[0] = false;
		numbers[1] = false;// 1 and 0 are also true but they are not prime
		
		return numbers;
		
		/*for (int i = 0; i <= n ; i ++){//to count the number of true
			if(numbers[i] == true)
				x++;
		}*/
		
	}
	public boolean palindrome(int n){
		int rem , newnumber = 0 , originalnumber = n;
		while (n != 0 ){
			rem = n % 10;
			newnumber = newnumber * 10 + rem;
			n = (n - rem) / 10;
		}
		if (newnumber == originalnumber)
			return true;
		else
			return false;
	}
	public int prob1(){//done
	int sum = 0;
	for(int i = 0 ; i < 1000 ; i++){
		if(i % 5 == 0 || i % 3 == 0){
		sum = sum + i;
		}
	}
	return sum;
	}
	public long prob2(){//done
		 long fn1 = 1 , fn2 = 2 , fn = 0 ;
		 long sum = 2;
		/*for (int i = 0 ; i < n ; i++){
			fn = fn1 + fn2;
			fn1 = fn2;
			fn2 = fn;
			if(fn < 4000000 && fn % 2 == 0){
				sum = sum + fn; 
			}
			
		}*/
		
		while(fn < 4000000){
			fn = fn1 + fn2;
			fn1 = fn2;
			fn2 = fn;
			
			if(fn % 2 == 0) sum += fn;
			
			
		}
		
		return sum;
	}
	/*public long prob3(){
		int pnum;
		BigInteger n = new BigInteger("600851475143");
		int[] factors = divisors(n);
	}*/
	public int prob4(){//done
		int product , ans = 0;
		for (int i = 100; i <= 999 ; i ++){//first number
			for (int j = 100; j <= 999 ; j ++){//second number 
				product = i*j;//product
				if(palindrome(product) && product > ans){//product must be palindromic and it dhould be greater than the previous palindromic product
					ans = product;//new ans is the product that passed the above two conditions
					continue;
				}
			}
		}
		return ans;
	}
	public int prob5(){//done
		int x = 1;
		for(int i = 1; i <= 20 ; i ++){
			if (x % i == 0)
				continue;
			else{
				x++;
				i = 1;
			}
		}
		return x;
	}
	public int prob6(){//done
		int sum = 0 , sqs = 0, ssq = 0;
		for(int i = 1; i <= 100 ; i++){
			sqs = sqs + i*i;
		}
		for(int i = 1; i <= 100 ; i++){
			sum = sum + i;
		}
		ssq = sum*sum;
		return ssq - sqs;
	}
	public long prob7(){//done
		int count = -2;//because 0 and 1 are also true after program
		int n = 1000000;//random number in which i guess 10001st prime is
		int ans = 0;
		boolean numbers[] = new boolean[n+1];//create a boolean array
		for (int i = 0; i <= n ; i++){
			numbers[i] = true;//set all the members of array as true
		}
		for (int p = 2; p*p <= n; p++){//for a number that is less than square root of the n
			if(numbers[p] == true){//if it is true
				for (int i = 2 * p ; i <= n; i += p){//for all the multiples of that p
					numbers[i] = false;//make them false and select the next true number 
				}
			}
		}
		for (int i = 0; i <= n ; i ++){//to count the number of true
			if(numbers[i] == true)//checks all the trues
				count++;//count 
			if(count == 10001){//question is to find the 10001st prime number
				ans = i;//the 10001st prime is in the ith place of the array
				break;//condition satisfied, come out of loop
			}
		}
		return ans;
	}
	public long prob8(){//done
		long product = 1 , iter = 1 , maxproduct = 1;
		String num = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
		for(int i = 0; i <= 987; i ++){
			
			for(int j = 0; j < 13; j++){
				char c = num.charAt(i + j);
				int number =Character.getNumericValue(c);// Integer.parseInt(s); //
				iter = iter * number;
				}
			product = iter;
			iter = 1;
			if(product > maxproduct)
				maxproduct = product;
			}
		return maxproduct;
	}
	public int prob9(){//done
		int a = 0,b = 0,c = 0;
		for(int i = 1; i < 1000 ; i ++){
			for(int j = i; j < 1000 ; j++){
				for(int k = j; k < 1000; k++){
					if(k*k == i*i + j*j && i + j + k == 1000){
						a = i;
						b = j;
						c = k;
						break;
					}
				}
			}
		}
		return a*b*c;
	}
	public long prob10(){//done
		int n = 2000000;
		long sum = 0;
		boolean[] primes = sieveOE(n);
		for(int i = 0; i < 2000000; i++){
			if(primes[i] == true){
				long x = Long.valueOf(i);
				sum = sum + x;
			}
		}
		
		return sum;
	}
	/*public int prob11(){
		int a[5][5];
		08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08
		49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00
		81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65
		52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91
		22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80
		24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50
		32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70
		67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21
		24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72
		21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95
		78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92
		16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57
		86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58
		19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40
		04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66
		88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69
		04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36
		20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16
		20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54
		01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48
	}*/
	public int prob12(){
		int n = 1;
		int trinum = 1;
		while (n > 0){
			trinum = n*(n + 1)/2;
			int factors[] = divisors(trinum);
			if(factors.length == 500)
				break;
			else
				n++;
		}
		return trinum;
	}
/*public long prob13(){
		String a;
		StringBuilder b = new StringBuilder();
		Scanner scan = new Scanner(System.in);
		a = scan.next();
		scan.close();
		
		for(int i = 0 ; i <= a.length() ; i ++){
			if(a.charAt(i) != ' ')
				b.append(a.charAt(i));
		}
		b.toString();
	}*/
	public int prob14(){
		long sequences = 1 , maxsequence = 0;
		int maxnum = 0;
		for(int i = 2 ; i < 1000000 ; i ++)
		{
			long j = i;
			while (j > 1)
			{
				if(j % 2 == 0)
				{
					j = j / 2;
				}
				else
					j = 3*j+ 1;
				
				sequences ++;
			}
			if(sequences > maxsequence)
			{
				maxsequence = sequences;
				maxnum = i;
				System.out.println(maxnum + ":"+ maxsequence);
			}
			sequences = 1;
		
		}

		return maxnum;
	}
	public int prob17(){//done
		numtostring num = new numtostring();
		int letters = 0;
		for(int i = 1; i <= 1000 ; i ++){
			String word = num.oldNumToWords(i);
			System.out.println(i + " " + word);
			for(int j = 0 ; j < word.length(); j ++)
				if(word.charAt(j) != ' ')
					letters ++;
			System.out.println(letters);
		}
		return letters;
	}
	public int prob20(){//done
		int num = 100;
		BigInteger fact = new BigInteger("1");
		for(int i = 1; i < num; i++){
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		String s = fact.toString();
		int digitsum = 0;
		for(int i = 0; i< s.length() ; i++)
			digitsum = digitsum + Character.getNumericValue(s.charAt(i));
		return digitsum;
	}
	/*public int prob34(){
		int factsum = 0 , totalsum = 0;
		for(int i = 10; i < 9999999 ; i++){
			int placevalue[] = new int[7];
			for(int j = 0; j < 7; j++){
				placevalue[j] = i % (int) Math.pow(10, j + 1) / (int) Math.pow(10 , j);
			}
			
			Factorial num = new Factorial();
			
			for(int j = 0 ; j < 7 ; j ++){
				factsum = factsum + num.fact(placevalue[j]);
			}
			if(factsum == i)
			totalsum = totalsum + factsum;
		}
		return totalsum;
	}*/
    
}
	



