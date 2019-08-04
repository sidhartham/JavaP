package fract;

import java.util.ArrayList;


public class JuliaSet {
	
	ArrayList< double[][]> m_Datasets = new ArrayList< double[][]>();
	
	ArrayList <Integer> m_datasetindex = new ArrayList<Integer>() ;
	
	int m_iNoOfDataSets = 0 ;
	
	int m_maxindex = 10000;
	
boolean InitDataSets( int iCount)
{
	m_Datasets = new ArrayList< double[][]>();
	 m_datasetindex = new ArrayList<Integer>() ;
	 
	for ( int ii = 0 ; ii < iCount; ii++)
	{
		m_Datasets.add(new double[2][m_maxindex]);
	}
	
	for ( int ii = 0 ; ii < iCount; ii++)
	{
		m_datasetindex.add(0);
	}
	m_iNoOfDataSets = iCount  ;
	return true;
}
public ArrayList< double[][]> ReturnXYDatasets()
{
	return Meff() ; // 
	//return m_Datasets ;
}


//Arra list- List of points(Dimensions of the double array) that constitutes part of fractal
//dimensions of the double array

//out:
//array list in which 100% memory is used

//how to approach

public ArrayList< double[][]> Meff() //effective memory
{
	
	ArrayList< double[][]> finalAL = new ArrayList< double[][]>();
	//loop is created to get all the double arrays in arraylist
	for (int i = 0; i < m_Datasets.size(); i++){//to remove the individual arrays from the array list
		int prsindex = m_datasetindex.get(i);
		double[][] a =null;// new double[2][prsindex]; //elements in A
		a = m_Datasets.get(i);
			
		if(a.length == prsindex){
			finalAL.add(a);
		}
		else
		{
		double[][] hfarray = new double[2][prsindex];
		if(a.length >= 0 && a.length < prsindex ){
			for (int ii = 0 ; ii < 2 ; ii ++)
			{
				for (int iii = 0 ; iii < prsindex; iii++)
				{
					hfarray[ii][iii] = a[ii][iii];
				}
			}
			finalAL.add(hfarray);
		
		}
		
		}
	}	
	return finalAL;
}
public boolean CreateJset() //returns true if datasets generated
{
	int blowval = 2;
	int rec = 3;
	int imc = 4;
	
	int maxiter = 50 ;
	InitDataSets(maxiter+1) ;
	
	double epsillon = 0.001;
	//for(double rez = 0.4; rez < 0.45; rez = rez+epsillon){
		//for (double imz = -0.4; imz < -0.35; imz= imz +epsillon){
			
	  for(double rez = -2; rez < 2; rez = rez+epsillon){
		for (double imz = -2; imz < 2; imz= imz +epsillon){
			
			//create complex number
			ComplexNumber z = new ComplexNumber();
		//	z.SetXY(rez, imz );
			 int iter = 0;
			for ( iter = 0 ; iter < maxiter; iter++)
			{
				//zn+1 = f(zn)
				z = z.Square2();
				//z.add(rec , imc);
				z.add(rez, imz);
				//System.out.println(z.Modulus() + "," + String.valueOf(rez) +"," + String.valueOf(imz) + "," + String.valueOf(iter));
				if (z.Modulus() <= blowval)
				{
					continue;
				}
				else
					break ;
			
			}
			
			//ave the complex number in a dataset corresponding to iteration
			double[][] prsdataset = this.m_Datasets.get(iter);
			int prsindex = this.m_datasetindex.get(iter) ; //Get the array index for prsdataset
			if( prsindex < m_maxindex)
			{
				prsdataset[0][prsindex] =imz ;
				prsdataset[1][prsindex] = rez ;
				
				prsindex++;
				this.m_datasetindex.set(iter, prsindex);  //Set the incremented the array index for prsdataset
				
			}
		}
	}
	
	return true;
}
}
