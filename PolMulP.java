import java.util.ArrayList;

public class PolMulP
{
    // This function multiplies two poylomials from a polynomial ring of degree n - 1 
    // result : A polynomial in the same ring with coefficients reduced modulo q
    
    public static ArrayList<Integer> PolMulp(ArrayList<Integer> pol1, ArrayList<Integer> pol2,int p)
    {
        ArrayList<Integer> output = new ArrayList<Integer>(pol1.size());
        
        for(int k=0;k<output.size();k++)
        {
            int coefficient = 0;
            for(int i=0;i<pol1.size();i++){
                if(k>=i)
                    coefficient+= pol1.get(i)*pol2.get(k-i);
                else
                    coefficient+= pol1.get(i)*pol2.get(pol1.size() + k - i);
            }
            output.set(k,coefficient % p);
        }
        
        return output;
    }  
}