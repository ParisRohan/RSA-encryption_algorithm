# RSA-encryption_algorithm
RSA encryption/decryption algorithm in java

1)Get prime-numbers 'P','Q' and Message 'M' from user

2)Calculate n=P*Q;
            PHIn=(P-1)*(Q-1);  //PHIn is euler's totient's function
            
3)Choose 'e' such that gcd(e,PHIn)=1  and 1<e<PHIn
  PUBLIC KEY={e,n}
  
4)Calculate 'd' as follows,
                          d=((PHIn*i)+1)/e;   //where i=1,2.....
                          //d must be whole number i.e no fraction is allowed
  PRIVATE KEY={d,n}
  
5)Encryption:-
              Cipher 'C'= (M^e)%n ;
       
6)Decryption:-
              M= (C^d)%n ; 
