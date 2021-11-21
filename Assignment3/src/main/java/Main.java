import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);  // Create a Scanner object
		BST head = new BST();					//BST to store words of vocabulary
		ArrayList<String> filename = new ArrayList<String>();	//to get file names
		ArrayList<FileReader> Freader = new ArrayList<FileReader>();	//will have the files
		
		System.out.println("Kindly enter vocabulary file name:");
		String file = input.nextLine();
		
		//Reading vocabulary file and making BST
		FileReader vocabulary = new FileReader(file);//will be used to process vocabulary file
		Freader.add(vocabulary);
		filename.add(file);	
		head=Freader.get(0).vocabulary(file);
		
		
		while(!(file.equals("over")))
		{
			System.out.println("Enter file name or enter over if you are done");
			file = input.nextLine();
			if(!(file.equals("over")))
			{
				filename.add(file);
			}
		}
		
		//printing total number of files and thier names
		System.out.println("Total number of files input(including vocabulary file) are: "+filename.size());
		System.out.println("File names are:");
		for(int i=0;i<filename.size();i++)
		{
			System.out.println(filename.get(i));
		}
		
		//processing the files
		for(int i=1;i<filename.size();i++)
		{
			FileReader obj = new FileReader(filename.get(i));
			Freader.add(obj);
			Thread t1 = new Thread(Freader.get(Freader.size()-1));
			t1.start();
		}
		
		head = Freader.get(0).head;
		int condition = 6;
		while(condition!=0)
		{
			System.out.println("To see BST insert 1");
			System.out.println("To see vectors of input files press 2");
			System.out.println("To see viewing match words and thier frequency input 3");
			System.out.println("To make query input 4");
			System.out.println("To exit enter 0");
			
			condition = input.nextInt();
			
			if(condition==1)
			{
				head.Display(head);
			}
			else if(condition==2)
			{
				
			}
			else if(condition==3)
			{
				head.fDisplay(head);
			}
			else if(condition==4)
			{
				
			}
		}
	}
}
