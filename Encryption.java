import java.util.ArrayList;

public class Encryption
{
    //parameters of NTRU
    private int deg;
    private int q;
    private int df;

    public Encryption(int degree,int q, int df){
        this.deg = degree;
        this.q = q;
        this.df = df;
    }

    public ArrayList<Integer> Encrypt(ArrayList<Integer> publicKey,ArrayList<Integer> m)
    {   
        //creation of random polynomial
        ArrayList<Integer> r = RandPol.RandP(df,df - 1,deg + 1);

        //Calculating Encrypted Message
        ArrayList<Integer> temp = PolMulQ.PolMulq(publicKey, r, q);
        ArrayList<Integer> e = Sum2PolQ.Add(m, temp, q);

        return e;
    }
}