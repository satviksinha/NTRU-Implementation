import Jama.*;
import java.util.ArrayList;
import java.util.Collections;  

public class InverseGFq
{
    private static int modInverse(int n,int q){
        for(int i=1;i<q;i++)
        {
            if((i*n) % q == 1)
            {
                return i;
            }
        }
        
        return -1;
    }

    public static void main(String args[])
    {
        ArrayList<Integer> input = new ArrayList<Integer>();
        input.add(0);
        input.add(1);
        input.add(1);
        ArrayList<Integer> temp = CalculateInverse(2,input);

        if(temp == null)
            System.out.println("Inverse doesn't exist");
        else
            for(int i = 0; i < temp.size(); i++)
                System.out.println(temp.get(i));
    }


    public static ArrayList<Integer>CalculateInverse(int q, ArrayList<Integer> pol)
    {
        ArrayList<Integer> output = new ArrayList<Integer>(pol.size());
        double [][] mat = new double[pol.size()][pol.size()];
        double [] congruence = new double[pol.size()];
        congruence[0] = 1;
       

        ArrayList<Integer> temp = new ArrayList<Integer>(pol.size());
        
        temp.add(pol.get(0));
      
        for(int i = 1; i < pol.size(); i++)
        {
            temp.add(pol.get(pol.size() - i));
        }
        
        for(int i = 0; i < mat.length; i++)
        {
            for(int j  = 0; j < mat[0].length; j++ )
            {
                mat[i][j] = temp.get(j);
            }
            Collections.rotate(temp, 1);
        }
       
        Matrix A = new Matrix(mat);
        Matrix B = new Matrix(congruence,congruence.length);
        Matrix X = A.solve(B);
        
        double determinant = A.det();

        int h = modInverse(Math.floorMod((int)determinant, q),q);
        //System.out.println(Math.floorMod(-4,3));
        if(h == -1)
        {
            //inverse does not exist for the given polynomial
            return null;
        }
       
        for(int i = 0; i < X.getRowDimension(); i++)
        {
            output.add(((int)(X.get(i,0)*determinant*h))%q);
        }
        
        return output;
    }
}
