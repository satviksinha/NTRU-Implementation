import Jama.*;
import java.util.*;  

public class InverseGFp 
{
    private static int modInverse(int n,int p){
        for(int i=1;i<p;i++)
        {
            if(Math.floorMod((i*n) , p) == 1)
            {
                return i;
            }
        }
        
        return -1;
    }

    public static void main(String args[])
    {
        ArrayList<Integer> input = new ArrayList<Integer>();
        for(int i=0;i<20;i++){
            input.add(Math.random() > 0.5 ? 1 : 0);
        }
       
        ArrayList<Integer> temp = CalculateInverse(3,input);

        if(temp == null)
            System.out.println("Inverse doesn't exist");
        // else
        //     for(int i = 0; i < temp.size(); i++)
        //         System.out.println(temp.get(i));
    }


    public static ArrayList<Integer>CalculateInverse(int p, ArrayList<Integer> pol)
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
        Matrix X ;
        try
        {
            X = A.solve(B);
        }

        catch(Exception e)
        {
            return null;
        }
        
        double determinant = A.det();
        //System.out.println("determinant" + determinant);
        

        int h = modInverse(Math.floorMod(Math.round(determinant), p),p);
        //System.out.println("determinant" + h);
        
        if(h == -1)
        {
            //inverse does not exist for the given polynomial
            return null;
        }
       
        for(int i = 0; i < X.getRowDimension(); i++)
        {
            output.add(Math.floorMod(Math.round(X.get(i,0)*determinant*h),p));
            //System.out.println("output" + output.get(i));
        }
        
        return output;
        
    }
}
