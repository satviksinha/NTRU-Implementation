import java.util.ArrayList;

public class Driver 
{
    public static void main(String args[])
    {   
        
        ArrayList<Integer> plaintext = new ArrayList<Integer>();
        for(int i = 0; i < 16; i++)
        {
            plaintext.add((int)Math.round(Math.random()*100) % 2);
        }
        KeyGen kg = new KeyGen(15,3,5,3,2);
        kg.KeyGeneration();
        System.out.println("Private: " + kg.getPrivateKey());
        System.out.println("public: " + kg.getPublicKey());
        Encryption enc = new Encryption(15, 5, 4);
        ArrayList<Integer> ciphertext = enc.Encrypt(kg.getPublicKey(),plaintext);
        System.out.println("CipherText is:  " + ciphertext);
        Decryption dec = new Decryption(3,5);
        System.out.println("Original plain Text is: " + plaintext);
        plaintext = dec.Decrypt(kg.getPrivateKey(), ciphertext);
        System.out.println("Decrypted plain Text is: " + plaintext);
    }    

}
