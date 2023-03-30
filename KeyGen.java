import java.util.ArrayList;

public class KeyGen
{
    //parameters of NTRU
    private int deg;
    private int p;
    private int q;
    private int df;
    private int dg;
    private ArrayList<Integer> publicKey = new ArrayList<Integer>(deg+1);
    private ArrayList<ArrayList<Integer>> privateKey = new ArrayList<ArrayList<Integer>>(2);

    public KeyGen(int degree,int p,int q, int df, int dg){
        this.deg = degree;
        this.p = p;
        this.q = q;
        this.df = df;
        this.dg = dg;
    }

    public void KeyGeneration()
    {   
        //creation of random polynomials
        ArrayList<Integer> f = RandPol.RandP(df,df - 1,deg + 1);
        ArrayList<Integer> g = RandPol.RandP(dg,dg,deg + 1); 

        //Calculating Inverses

        
        ArrayList<Integer> finvp = InverseGFp.CalculateInverse(p, f); 
        ArrayList<Integer> finvq = InverseGFq.CalculateInverse(q, f);
        while(finvp == null || finvq == null)
        {
            f = RandPol.RandP(df,df - 1,deg + 1);
            finvp = InverseGFp.CalculateInverse(p, f); 
            finvq = InverseGFq.CalculateInverse(q, f);
        }

        for(int i=0;i<finvp.size();i++)
            finvq.set(i,finvq.get(i)*p);

            
        //set public key
        publicKey = PolMulQ.PolMulq(g, finvq, q);  
       

        //setting private key
        privateKey.add(f);
        privateKey.add(finvp);
    }

    public ArrayList<ArrayList<Integer>> getPrivateKey()
    {
        return privateKey;    
    }

    public ArrayList<Integer> getPublicKey(){
        return publicKey;
    }

}