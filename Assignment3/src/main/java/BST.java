//BST class
public class BST
{
	String word;
	int value;
	
	int frequency;
	
	BST right;
	BST left;
	
	//Constructors
	BST()
	{
		word = null;
		value = 0;
		frequency = 0;
		right = null;
		left = null;
	}
	
	BST(String word, int value)
	{
		this.word = word;
		this.value = value;
		
		frequency = 0;
		
		right = null;
		left = null;
	}
	
	BST(BST node)
	{
		this.word = node.word;
		this.value = node.value;
		
		frequency = 0;
		
		right = null;
		left = null;
	}
	
	//Insertion
	public void Insert(BST node)
	{
		BST ptr = this;
		int condition=0;
		if(this.word==null)
		{
			this.word=node.word;
			this.value=node.value;
		}
		else
		{
			while(condition!=1)
			{
				if(ptr.value>node.value)
				{
					if(ptr.left==null)
					{
						condition = 1;
						ptr.left=node;
					}
					else
					{
						ptr = ptr.left;
					}
				}
				else if(ptr.value<node.value)
				{
					if(ptr.right==null)
					{
						condition = 1;
						ptr.right=node;
					}
					else
					{
						ptr = ptr.right;
					}
				}
			}
		}
	}
	public void Insert(String word,int value)
	{
		BST node = new BST (word,value);
		this.Insert(node);
	}
	//frequency ftn
	public BST Searchf(String s,BST head)
	{
		int v = Hash.hash(s);
		BST ptr = head;
		
		
//		System.out.println("hash:"+v+" word:"+s+" Current word is:"+head.word);//for debugging
		
		if(ptr!=null)
		{
			if(ptr.value==v)
			{
				//System.out.println("Word found:"+word);
				ptr.frequency++;
				return ptr;
			}
			else
			{
				if(ptr.value<v && ptr.right!=null)
				{
					ptr.right=ptr.right.Searchf(s, ptr.right);
				}
				else if(ptr.value>v && ptr.left!=null)	
				{
					ptr.left=ptr.left.Searchf(s, ptr.left);
				}
			}
		}
		
		return ptr;
	}
	//display ftn
	public void Display(BST head)
	{
		if(head == null)
		{
			
		}
		else
		{
			System.out.println(head.word);
			Display(head.left);
			Display(head.right);
		}
	}
	public void fDisplay(BST head)
	{
		if(head == null)
		{
			
		}
		else
		{
			System.out.println("Word:"+head.word);
			System.out.println("Frequency:"+head.frequency);
			System.out.println("");
			fDisplay(head.left);
			fDisplay(head.right);
		}
	}
}