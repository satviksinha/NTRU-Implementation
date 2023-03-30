import java.util.ArrayList;

public class Encryption
{
    //parameters of NTRU
    private int deg;
    private int q;
    private int dr;

    public Encryption(int degree,int q, int dr){
        this.deg = degree;
        this.q = q;
        this.dr = dr;
    }

    public ArrayList<Integer> Encrypt(ArrayList<Integer> publicKey,ArrayList<Integer> m)
    {   
        //creation of random polynomial
        ArrayList<Integer> r = RandPol.RandP(dr,dr,deg + 1);

        //Calculating Encrypted Message
        ArrayList<Integer> temp = PolMulQ.PolMulq(publicKey, r, q);
        ArrayList<Integer> e = Sum2PolQ.Add(m, temp, q);

        return e;
    }

    
}

