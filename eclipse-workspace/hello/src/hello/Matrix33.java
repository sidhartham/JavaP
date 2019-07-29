package hello;

import java.util.Scanner;

public class Matrix33 {
	double m_matrix[][] = new double[3][3];
	//double m_matrix1[][] = new double[3][3];
public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	System.out.println("enter the first matrix row wise");
	String a = scan.nextLine();
	
	/*System.out.println("enter the second matrix");
	String b = scan.nextLine();*/
	
	scan.close();
	
	Matrix33 x1 = new Matrix33();
	//Matrix33 x2 = new Matrix33();
	Matrix33 x3 = new Matrix33();
	//Matrix33 x4 = new Matrix33();
	
	double[] y1 = x1.Array(a);
	
	x1.Addrow(y1);
	
	x1.Print();
	//x2.Print();
	x3 = x1.Inverse(x1);
	
	if(x3 != null)
	x3.Print();
	//x1.Modulus();
	
	
}
public void Addrow(double[] y1 ){
	//elements of array y will be added to first row of the matrix A
    for (int ithrow = 0; ithrow < 3 ; ithrow++ ){
	
	for (int r1 = 0 ; r1 < 3; r1++)
	m_matrix [ithrow][r1] = y1[3 * ithrow + r1];
    }
}
public void Print(){ //m_matrix has to be printed
	StringBuilder word = new StringBuilder();
	
    for ( int i = 0; i < m_matrix.length; i++){
    for ( int j = 0; j < m_matrix.length; j++){
			
    	double num = m_matrix[i][j] ;
    	//System.out.println("[" + num + "]");
    	double p = num;
    	
    	word.append(p);
    	if( j != 2)
    		word.append(' ');
    }
    System.out.println(word);
    word = new StringBuilder();//create a new string builder object
    
    }
    
}
public double[] Array(String a){
    char p;
    int jthcolumn = 0;
    
    double[] A = new double[10];
    StringBuilder word = new StringBuilder();
    
   for (int i = 0; i < a.length(); i++){
       p = a.charAt(i);
       //when i = 0
       
       
       if ( p == ' '){ //it is a new word
    	   
     	  A[jthcolumn++] = Double.parseDouble(word.toString()); //store the existing word in an array
     	  word = new StringBuilder();//create new string for the next word
       }
       else if ( p != ' ')
 	    {
     	  word.append(p); //store the character in the word
       }
       }
   if (word.length() > 0)
	   A[jthcolumn++] = Double.parseDouble(word.toString());
   
return A;
}
private int Subtract3For13( int num)
{
	int ret = num %3;
	return ret;
}
public double Modulus(){
	double mod = 0;
	//double[] A = new double[3];
	int i = 0;
	for(int j = 0; j < m_matrix.length; j ++){
			//Subtract 3 or multiple of 3 such that the number is between 1 - 3
			
			//find ja+ and j+2 ;
			int jp1 = Subtract3For13(j+1);
		    int jp2 = Subtract3For13(j+2);
		    int ip1 = Subtract3For13(i+1);
		    int ip2 = Subtract3For13(i+2);
		    mod = mod + m_matrix[i][j]*(m_matrix[ip1][jp1]*m_matrix[ip2][jp2] - m_matrix[ip1][jp2]*m_matrix[ip2][jp1]);
		    mod += m_matrix[i][j]*(m_matrix[ip1][jp1]*m_matrix[ip2][jp2] - m_matrix[ip1][jp2]*m_matrix[ip2][jp1]);
		   //System.out.println( A[j] = m_matrix[i][j]*(m_matrix[ip1][jp1]*m_matrix[ip2][jp2] - m_matrix[ip1][jp2]*m_matrix[ip2][jp1]));
		    
	}
	//System.out.println(mod = A[0] + A[1] + A[2]);
	return mod;
}
public void Multiply1(Matrix33 inmatrix){
	double[] z = new double[9];
	
	double d = 0;
	int g = 0;
	for(int i1 = 0; i1 < m_matrix.length; i1 ++){
		for(int j1 = 0; j1 < m_matrix.length; j1 ++){
			for(int i2 = 0; i2 < m_matrix.length; i2 ++){
					
					d += m_matrix[i1][i2]*inmatrix.m_matrix[i2][j1];
				    
			}
			z[g ++] = d;
			d = 0;
		}
	}
	Addrow(z);
	Print();
	
}
public Matrix33 Multiply2(Matrix33 inmatrix){
	Matrix33 Z = new Matrix33();
	//double[][] z = new double[3][3];
	double d = 0;
	
	for(int i1 = 0; i1 < m_matrix.length; i1 ++){
		for(int j1 = 0; j1 < m_matrix.length; j1 ++){
			for(int i2 = 0; i2 < m_matrix.length; i2 ++){
					
					System.out.println(d += m_matrix[i1][i2]*inmatrix.m_matrix[i2][j1]);
				    
			}
			Z.m_matrix[i1][j1] = d;
			d = 0;
		}
	}
	return Z;
	}
public Matrix33 Inverse(Matrix33 Inmatrix){
	Matrix33 I = new Matrix33();
	Matrix33 Wtrans = new Matrix33();
	
	double d ;
	
	if(Inmatrix.Modulus() == 0){
		System.out.println("Matrix is non invertible");
		return null;
	}
	else{
	
	for(int i = 0; i < m_matrix.length; i ++){
		for(int j = 0; j < m_matrix.length; j ++){
			
			int jp1 = Subtract3For13(j+1);
		    int jp2 = Subtract3For13(j+2);
		    int ip1 = Subtract3For13(i+1);
		    int ip2 = Subtract3For13(i+2);
					
			d = m_matrix[ip1][jp1]*m_matrix[ip2][jp2] - m_matrix[ip1][jp2]*m_matrix[ip2][jp1];
			Wtrans.m_matrix[j][i] = d;
			
			I.m_matrix[i][j] = Wtrans.m_matrix[i][j] / Inmatrix.Modulus();
		}
	}
	}
	
	return I;
	
}
}
