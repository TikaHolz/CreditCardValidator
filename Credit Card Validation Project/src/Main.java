import java.io.File;
import java.io.IOException;
import java.util.Scanner;
//hello this is a comment 
//i like pie
// i am not a russian hacker
public class Main
	{
	static long [] creditCardNum = new long[16];
	static int validCounter = 0;
	static int invalidCounter = 0;
	static long total = 0;


	public static void main(String[] args) throws IOException
		{
		
		addEveryOtherNumber();
		System.out.println("There are " + validCounter + " valid numbers.\nThere are " + invalidCounter + " invalid numbers.");
		
	
		}
	public static void addEveryOtherNumber() throws IOException
		{
		//linking text file
		Scanner file = new Scanner(new File("new 2.txt"));	
		while(file.hasNextLong())
			{	
			long num = file.nextLong();	
			for(int i = 15; i >= 0; i--) 
				{
				creditCardNum[i] = num % 10;
				num = num/10;
				}

			//adding up the multiplied numbers if they are greater than 10
			for(int n = 0; n<creditCardNum.length; n += 2)
				{
				creditCardNum[n] =creditCardNum[n] * 2;
				if(creditCardNum[n] >= 10)
					{
					long digit1 = creditCardNum[n] % 10;
					long digit2 = creditCardNum[n] / 10;
					creditCardNum[n] = digit1 + digit2;
					}				
				}
			total = 0;
			for(int i = 0; i<creditCardNum.length; i++)
				{
				total += creditCardNum[i];
				
				}
			ifValid();

			}
		}
	public static void ifValid()
		{
			
		if(total % 10 == 0)
			{
			validCounter++;
			}
		else
			{
			invalidCounter++;
			}
		}

	}
