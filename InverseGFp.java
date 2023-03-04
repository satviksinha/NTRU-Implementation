import Jama.*;
import java.util.ArrayList;
import java.util.Collections;

public class InverseGFp 
{
    public static ArrayList<Integer>CalculateInverse(int p, ArrayList<Integer> pol)
    {
        ArrayList<Integer> output = new ArrayList<Integer>(pol.size());
        double [][] mat = new double[pol.size()][pol.size()];
        double [] congruence = new double[pol.size()];
        congruence[0] = 1;

        ArrayList<Integer> temp = new ArrayList<Integer>(pol.size());
        temp.set(0,pol.get(0));
        for(int i = 1; i < pol.size(); i++)
        {
            temp.set(i, pol.get(pol.size() - i));
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
        Matrix B = new Matrix(congruence,1);
        Matrix X = A.solve(B);

        for(int i = 0; i < X.getRowDimension(); i++)
        {
            output.set(i,(int)X.get(i,0) % p);
        }
        return output;
    }
}
