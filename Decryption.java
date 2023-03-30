import java.util.ArrayList;

public class Decryption
{
    //parameters of NTRU
    private int p;
    private int q;

    public Decryption(int p,int q){
        this.p = p;
        this.q = q;
    }

    public ArrayList<Integer> Decrypt(ArrayList<ArrayList<Integer>> privateKey,ArrayList<Integer> e)
    {   
        //Star Multiplication
        ArrayList<Integer> a = PolMulQ.PolMulq(e, privateKey.get(0), q);
       
        int range = q/2;
        for(int i=0;i<a.size();i++){
            if(a.get(i)< -1*range)
                a.set(i,a.get(i)+q);
            else if(a.get(i)>range)
                a.set(i,a.get(i)-q);
        }

        //Modulo p
        for(int i=0;i<a.size();i++){
            a.set(i,Math.floorMod(a.get(i),p));
        }

        // System.out.println("****" +a+"****");

        //Star Multiplication
        ArrayList<Integer> c = PolMulP.PolMulp(a, privateKey.get(1), p);

        //System.out.println("THIS IS C" +c+"THIS IS C");
        
        return c;
    }
}