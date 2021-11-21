//For creating a unique hash for words
public class Hash 
{
	static public int hash(String s)
	{
		int hashvalue=0;
		
		int size = s.length();
		
		for(int i=0; i<size; i++)
		{
			hashvalue = hashvalue*2;
			
			char c = s.charAt(i);
			hashvalue=hashvalue + (int)c;
		}
		
		return hashvalue;
	}
}
