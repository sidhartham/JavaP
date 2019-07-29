package hello;


public class numtostring{
	public String oldNumToWords(int num){
		
		if((num % 100) / 10 != 1){
			
			int o , t , h , th;
			th = num / 1000;
			h = (num % 1000) / 100;
			t = (num % 100) / 10;
			o = num % 10;
			
			String O , T , H , Th;
			O = "NI";T = "NI";H = "NI";Th = "NI";
			if(th != 0 && h != 0){
				Th = DigitToWord(th) + " thousand and ";
			}
			else if(th != 0 && h == 0)
				Th = DigitToWord(th) + " thousand ";
			else 
				Th = "";
			
			if(h != 0 && t == 0 && o != 0){
				H = DigitToWord(h) + " hundred and ";
			}
			else if(h != 0 && t == 0){
				H = DigitToWord(h) + " hundred ";
			}
			else if(h != 0 && t != 0){
				H = DigitToWord(h) + " hundred and ";
			}
			else
				H = "";
			
			if(t != 0){
				T = TensToWords(t) + " ";
			}
			else
				T = "";
			
			if(o != 0){
				O = DigitToWord(o);
			}
			else
				O = "";
			
			return Th + H + T + O;
		}
		else {
			
			int tno , h , th;
			th = num / 1000;
			h = (num % 1000) / 100;
			tno = (num % 100);
			
			String TnO , H , Th;
			if(th != 0 && h != 0){
				Th = DigitToWord(th) + " thousand and ";
			}
			if(th != 0)
				Th = DigitToWord(th) + " thousand ";
			else 
				Th = "";
			
			if(h != 0){
				H = DigitToWord(h) + " hundred and ";
			}
			else
				H = "";
			
			if(tno != 0){
				TnO = TensIsOne(tno) + " ";
			}
			else
				TnO = "";
			
			return Th + H + TnO;
		}
			
	}
	public String DigitToWord(int num){
		if(num == 1)
			return "one";
		if(num == 2)
			return "two";
		if(num == 3)
			return "three";
		if(num == 4)
			return "four";
		if(num == 5)
			return "five";
		if(num == 6)
			return "six";
		if(num == 7)
			return "seven";
		if(num == 8)
			return "eight";
		if(num == 9)
			return "nine";
		else
			return null;
	}
	public String TensToWords(int num){
		if(num == 2)
			return "twenty";
		if(num == 3)
			return "thirty";
		if(num == 4)
			return "forty";
		if(num == 5)
			return "fifty";
		if(num == 6)
			return "sixty";
		if(num == 7)
			return "seventy";
		if(num == 8)
			return "eighty";
		if(num == 9)
			return "ninety";
		else
			return null;
	}
	public String TensIsOne(int num){
		if(num == 10)
			return "ten";
		if(num == 11)
			return "eleven";
		if(num == 12)
			return "twelve";
		if(num == 13)
			return "thirteen";
		if(num == 14)
			return "fourteen";
		if(num == 15)
			return "fifteen";
		if(num == 16)
			return "sixteen";
		if(num == 17)
			return "seventeen";
		if(num == 18)
			return "eighteen";
		if(num == 19)
			return "nineteen";
		else
			return null;
	}
	/*public String NewNumToWords(int num){
		
	}*/
}
