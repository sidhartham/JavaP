package hello;


public class ComplexNumber {
	double m_x , m_y ;

	public  void Square(){
		//ComplexNumber x = new ComplexNumber();
		double Sreal, Simg;
		m_x = ( m_x*m_x - m_y*m_y );
		m_y = ( 2*m_x*m_y ) ;
	}
	
	public ComplexNumber Square2(){
		ComplexNumber z = new ComplexNumber();
		double Sreal, Simg;
		Sreal = ( m_x*m_x - m_y*m_y );
		Simg = ( 2*m_x*m_y ) ;
		z.SetXY(Sreal, Simg);
		return z;
	}
	
	public void add(double rec , double imc){
		
		m_x = m_x + rec;
		m_y = m_y + imc;
	}
	
	double RealPart()
	{
		return m_x;
	}
	
	double ImgPart()
	{
		return m_y;
	}
	public double Modulus(){
		double mod = Math.sqrt(m_x * m_x + m_y * m_y);
		return mod;
	}
	
	void SetXY(double Sreal, double Simg)
	{
		m_x = Sreal;
		m_y = Simg;
	}
	
}
