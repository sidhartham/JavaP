package hello;

import java.util.Scanner;
import java.lang.String;

public class demo {
	
	public String m_delimitter ;
	public static void main(String[] args) {

		//CalculateAverage(5, 3);
		main2(args);
		if (true)
		return;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter any number: ");

        String num = scan.next();
      //  Integer numI = 0 ;
        scan.close();
        
       // System.out.println("The number entered by user: "+num);
        
       // demo de = new demo() ;
        //int avg=0;
        //avg= de.CalculateAverage(num, 3);
        //System.out.println("The number returned from CalculateAverager: "+avg);
	}
	
	//Method Name : CalculateAverage
	//              returns int.
	//Input arguments: int, int
	/*public int CalculateAverage(int a, //First number
			                   int b) //Second number
	{
		int average =  ( a+b) /2 ;
		return average;
	}*/
   public static void main2(String[] args){
	/*for (int i = 0; i >= 0 ; i++){
		Scanner scan = new Scanner(System.in);
		    System.out.println("Enter delimiter number" + i); 
		   String a = scan.nextLine();
		  
		   if( a == null){
			   scan.close();
		   }
	}*/
	   //System.out.println("Enter second number");
	   //b = scan.nextInt();
	   Scanner scan = new Scanner(System.in);
	    System.out.println("Enter delimiters"); 
	   String a = scan.nextLine();
	   
	  // scan.close();
	   
	  // Scanner scan2 = new Scanner(System.in);
	   /* System.out.println("Enter sentence"); 
	    String a2 = scan.nextLine();
	
	    System.out.println("Enter sentence"); 
	    String a3 = scan.nextLine();
	    
	    System.out.println("Enter sentence"); 
	    String b1 = scan.nextLine();
	    
	    System.out.println("Enter sentence"); 
	    String b2 = scan.nextLine();
	    
	    System.out.println("Enter sentence"); 
	    String b3 = scan.nextLine();*/
	    scan.close();
		
	   
	   demo de = new demo();
	 // de.m_delimitter = b ;
	   //double c1 =0;
	  int n = 10000000;
	  //String c1 = null;
	  String[] c1 = new String[n];
	  StringBuilder word3 = new StringBuilder();
	  //c1=de.CalculateHarMean(a ,b);
	   //c1=de.CalculateArea(a ,b);
	  //c1=de.CalculateSum(a);
	  // c1 = de.Divisibility(a);
	   //c1 = de.Divide(a, b);
	   //c1 = de.Read(a);
	   //c1 = de.Count_a(a);
	  // c1 = de.Split(a);
	  //c1 = de.Join(a);
	  c1 = de.Array(a);
	// String c1 = de.Matmult(a1, a2, a3, b1, b2, b3);
	   //String c2 = de.Split(a);
	   //System.out.println("The harmonic mean is ="+c1);
       //System.out.println("The area is="+b);
       //System.out.println("[" +c1 +"]");
	 System.out.println("-" + c1);
	 
	  for ( int i = 0; i < c1.length; ++i){
		 
		  
		 if(c1[i] != null){
			 
			if(word3.length() > 0 ){
				word3.append(",");
			}
          word3.append(c1[i]) ;
         
		 }
	   }
	   
	   System.out.println("[" + word3.toString() + "]");
   }
	
	private StringBuilder Split(StringBuilder a) {
		// TODO Auto-generated method stub
		return null;
	}
	public double CalculateHarMean(double a, double b)
	{
		double harmean = 1/((1/a) + (1/b));
		return harmean;
	}
	public double CalculateArea(double a ,double b)
	{
		double area = a*b/2 ;
		return area;
	}
	public int CalculateSum(int a)
	{
		int c2=0;
		for(int i = 1; i <= a; ++i) {
			c2 +=i;
		}
		return c2;
		
	}
	public int Divisibility(int a)
	{
		int b=0;
	    if (a % 7 == b) {
	    	System.out.println("number is divisibe by 7");
	    }
	    else {
	    	System.out.println("number is not divisible by 7");
	    }
		return b;
	 }
    public int Divide(int a ,int b){
    int count = 0 ;
    for (int i=0 ; i <= a; ++ i){
    	
    if ((i % 7) ==0)
    {
     count ++;
     
    }
        }
    return count;
}
    public int Read(String a){
       int count = 0;
       for (int i = 0; i < a.length(); ++ i){
    	   count ++;//= i;
       }
	return count;
    }
    public int Count_a(String a){
          char p;
          int count = 0 ;
          for ( int i= 0 ; i < a.length(); i++)
          {
            p = a.charAt(i);
            if ( p == 'a')
            	count ++ ;
          }
    
          return count ;
    }
    public String Split(String a){
       char p ;
       StringBuilder word = new StringBuilder();
      for (int i = 0; i < a.length(); i++){
          p = a.charAt(i);
          if ( p == ' '){
        	  System.out.println("-" + word);
        	  word = new StringBuilder();
          }
    	   
          else {
        	  word.append(p);
          }
          }
      
      //if ( word.length() > 0)
    	  //System.out.println("-" + word);
      
      
    	  
      
	return word.toString();
	}
    public String Join(String a){
        char p ;
        int n = 10 , presentplace = 0;
        String[] A = new String[n];
        StringBuilder word = new StringBuilder();
        String word2 = null;
       for (int i = 0; i < a.length(); i++){
           p = a.charAt(i);
           if ( p == ' '){
         	  A[presentplace ++] = word.toString();
         	  word = new StringBuilder();
           }
     	   
           else {
         	  word.append(p);
           }
           }
       
       if (word.length() > 0)
    	   A[presentplace ++] = word.toString();
       for (int i2 = 0 ; i2 < presentplace; i2++){
    	   word2 = A[i2];
    	   System.out.println("-" +word2);
       }
      
     	return word2;
 	}
    public String[] Array(String a){
    char p;
    int n = 10 , presentplace = 0;
    String[] A = new String[n];
    StringBuilder word = new StringBuilder();
    
   for (int i = 0; i < a.length(); i++){
       p = a.charAt(i);
       //when i = 0
       
       if ( i == 0){
    	   p = a.charAt(i++);
       }
       if ( p == ' ' && ' ' != a.charAt(i-1)){ //it is a new word
     	  A[presentplace ++] = word.toString(); //store the existing word in an array
     	  word = new StringBuilder();//create new string for the next word
       }
       else if ( p != ' ')
 	    {
     	  word.append(p); //store the character in the word
       }
       }
   
   if (word.length() > 0)
	   A[presentplace ++] = word.toString();
   
   
return A;
}
    public int Count(String a){
    	int c = 0;
    
    	for (int i = 0; i <a.length(); i++){
    		if( a.charAt(i) !=' '){
    			c++ ;
    		}
    	}
		return c;
    }
    public String[] Delim(String a){
    	char p;
        int n = 10 , presentplace = 0;
        String[] A = new String[n];
        StringBuilder word = new StringBuilder();
        
       for (int i = 0; i < a.length(); i++){
           p = a.charAt(i);
           //when i = 0
           
           if ( i == 0){// for first word
        	  // p = a.charAt(i);
        	   if ( p != ' ' && p!=',')
        	    {
            	  word.append(p); //store the character in the word
              }
        	   continue;
        	   
           }
           if ( p == ' ' && ' ' != a.charAt(i-1) && ',' != a.charAt(i-1)){ //it is a new word
         	  A[presentplace ++] = word.toString(); //store the existing word in an array
         	  word = new StringBuilder();//create new string for the next word
           }
           else if ( p == ',' && ',' != a.charAt(i-1) && ' ' != a.charAt(i-1)){
        	   A[presentplace ++] = word.toString();
        	   word = new StringBuilder();
           }
           else if ( p != ' ' && p!=',')
     	    {
         	  word.append(p); //store the character in the word
           }
           }
       
       if (word.length() > 0)
    	   A[presentplace ++] = word.toString();
       
       
    return A;
    }
    public boolean Bdelim(String a){
    	char p ;
    	
    	for (int i = 0; i < a.length(); i++){
    		p = a.charAt(i);
    		if (p == ' '){
    			System.out.println("true");
    		}
    		else if (p == ','){
    			System.out.println("true");
    		}
    		else{
    			System.out.println("false");
    		}
    	}
		return false;
	
    }
    public boolean Rdelim1(String b , //Input String
                    		String a){ //
    	char inchar = ' ';
    	System.out.println(b);
    	
    	for (int i = 0; i <b.length(); i++){
    		
    		inchar = b.charAt(i);
    		
    		boolean l = Isdelimiter(inchar , b);
    	    if ( l == true){
    	    	System.out.println(inchar+" is a delimiter");
    	    }
    	    else {
    	    	System.out.println(inchar+"-is not a delimiter");
    	    }
    	}
		return false;
		
		
    }
    public boolean Isdelimiter(char inchar, //Test 
    		                   String b
    		                   )
    {
    	String s = m_delimitter; //" ,";
    	for (int i = 0; i < s.length(); i++){
    		if (inchar == s.charAt(i)){
    	
    		return true;
    	    }
    	    else {
    		// System.out.print(false);
    	    	
    	    }
    	}
		return false;
    }
    public String[] Array2(String a , String b){
        char p ;
        int n = 10 , presentplace = 0;
        String[] A = new String[n];
        StringBuilder word = new StringBuilder();
        
       for (int i = 0; i < a.length(); i++){
           p = a.charAt(i);
           //when i = 0
           
           if ( i == 0)
           {
        	   if ( (Isdelimiter(p , b) == false))
        	    {
            	  word.append(p); //store the character in the word          	  
        	    }
        	   continue;
           }
           
           //if ( p == ' ' && ' ' != a.charAt(i-1)){ //it is a new word
           if(Isdelimiter(p , b) && (Isdelimiter(a.charAt(i-1) , b) == false))
           { 
         	  A[presentplace ++] = word.toString(); //store the existing word in an array
         	  word = new StringBuilder();//create new string for the next word
         	 System.out.print("newword");
           }
           else if ( (Isdelimiter(p , b) == false))
     	   {
         	  word.append(p); //store the character in the word
           }
           else
        	   System.out.print("No condition"+a);
           
       }
       
       if (word.length() > 0)
    	   A[presentplace ++] = word.toString();
       
       
    return A;
    }
    //public String Matmult(String a1 , String a2 , String a3 , String b1 , String b2 , String b3){
    	//String ai = Split(a1);
    }

	