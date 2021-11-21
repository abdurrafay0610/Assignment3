import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader implements Runnable
{
	String f;
	static BST head = new BST();
	ArrayList<String> word = new ArrayList<String>();
	//constructor
	FileReader(String file)
	{
		this.f=file;
	}
	//io for vocabulary
	public BST vocabulary(String file)
	{
		try 
		{
			File myObj = new File(file);
		    Scanner myReader = new Scanner(myObj);
		    while (myReader.hasNextLine()) 
		    {
		        String data = myReader.nextLine();
		        int value = Hash.hash(data);
		        head.Insert(data, value);
		    }
		    myReader.close();
		} 
		catch (FileNotFoundException e) 
		{
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
		return head;
	}
	//io for other files
	public void run() 
	{
		try 
		{
			File myObj = new File(f);
		    Scanner myReader = new Scanner(myObj);
		    String str = "";
		    while (myReader.hasNextLine()) 
		    {
		        String data = myReader.nextLine();
		        for(int i=0;i<data.length();i++)
		        {
		        	if(Character.compare(data.charAt(i),' ')!=0)
		        	{   		
		        		str+=data.charAt(i);
		        	}
		        	else
		        	{
		        		word.add(str);
		        		str="";
		        	}
		        }
		        word.add(str);
		        str="";
		    }
		    myReader.close();
		    
		    synchronized(this)
		    {
		    	for(int i=0;i<word.size();i++)
		    	{	
		    		head = head.Searchf(word.get(i), head);
		    	}
		    }
		    
		} 
		catch (FileNotFoundException e) 
		{
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
		
	}
}
