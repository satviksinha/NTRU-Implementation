//tested - working correctly
import java.util.ArrayList;

public class PolMulP
{
    // This function multiplies two poylomials from a polynomial ring of degree n - 1 
    // result : A polynomial in the same ring with coefficients reduced modulo p
    
    public static ArrayList<Integer> PolMulp(ArrayList<Integer> pol1, ArrayList<Integer> pol2,int p)
    {
        ArrayList<Integer> output = new ArrayList<Integer>(pol1.size());
        
        for(int k=0;k<pol1.size();k++)
        {
            int coefficient = 0;
            for(int i=0;i<pol1.size();i++){
                if(k>=i)
                    coefficient+= pol1.get(i)*pol2.get(k-i);
                else
                    coefficient+= pol1.get(i)*pol2.get(pol1.size() + k - i);
            }
            output.add(Math.floorMod(coefficient,p));
        }
        
        return output;
    }  

    // public static void main(String args[])
    // {
    //     ArrayList<Integer> input1 = new ArrayList<Integer>();
    //     input1.add(1);
    //     input1.add(1);
    //     input1.add(3);
    //     ArrayList<Integer> input2 = new ArrayList<Integer>();
    //     input2.add(1);
    //     input2.add(2);
    //     input2.add(3);

    //     ArrayList<Integer> output = PolMulp(input1,input2,5);
    //     for(int i = 0; i < output.size(); i++)
    //         System.out.println(output.get(i));   
    // }
}