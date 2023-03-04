import java.util.ArrayList;
import java.util.Collections;

public class RandPol{
    public static ArrayList<Integer> RandP(int positives,int negatives,int size)
    {
        ArrayList<Integer> output = new ArrayList<Integer>(Collections.nCopies(size,0));
        for(int i=0;i<positives+negatives;i++){
            if(i<positives)
                output.set(i,1);
            else
                output.set(i,-1);
        }
        Collections.shuffle(output);
        return output;
    } 
}