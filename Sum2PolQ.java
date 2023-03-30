//tested - working correct
import java.util.*;

class Sum2PolQ
{
    //methods
    public static ArrayList<Integer>  Add(ArrayList<Integer> pol1, ArrayList<Integer>pol2, int q)
    {
        int i;
        ArrayList<Integer> answer = new ArrayList<Integer>(pol1.size());
        
        for(i = 0; i < pol1.size(); i++)
        {
            answer.add(Math.floorMod((pol1.get(i) + pol2.get(i)) , q)); 
        }

        return answer;
    }
}

