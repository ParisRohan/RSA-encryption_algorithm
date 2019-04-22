import java.util.Scanner;
import java.util.ArrayList;
public class RSA 
{
	public int gcd(int PHIn,int i)
	{
		if(PHIn==0)
			return i;
		else
			return gcd(i%PHIn,PHIn);
	}
	public int encrypt(int P,int n,int e)
	{
		int C=(int) (Math.pow(P, e)%n);
		return C;
	}
	public long decrypt(int C,int n,float d)
	{
		long M=(long) (Math.pow(C, d)%n);
		return M;
	} 
	
	public static void main(String[] args) 
	{
		int P,Q,M,PHIn,n,e,C;
		float d=0;
		int count=0;
		ArrayList<Integer> coprime=new ArrayList<Integer>();
		RSA obj=new RSA();
		Scanner sc=new Scanner(System.in);
		System.out.println("\n Please enter 2 prime numbers P and Q");
		P=sc.nextInt();
		Q=sc.nextInt();
		n=P*Q;
		PHIn=(P-1)*(Q-1); //PHIn is euler's totient function
		
		System.out.println("\n Message to be encoded");
		M=sc.nextInt();
		
		for(int i=2;i<PHIn;i++)		//calculating coprimes
		{
			if(obj.gcd(PHIn,i)==1)
			{
				count++;
				coprime.add(i);
			}
		}
		System.out.println("\n Please choose a coprime number from the following "+coprime);
		e=sc.nextInt();
		System.out.println("\n PUBLIC KEY= {"+e+","+n+"}");
		
		for(int i=1;i<30;i++)
		{
			d=((PHIn*i)+1)/e;
			if(((PHIn*i)+1)%e==0)
				break;
		}
		System.out.println("\n PRIVATE KEY= {"+d+","+n+"}");
		
		C=obj.encrypt(M,n,e);
		System.out.println("\n Cipher text ="+C);
		
		System.out.println("\n Plain text ="+obj.decrypt(C,n,d)); //Check decrypted msg
	}

}
