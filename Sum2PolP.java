//tested - working correct
import java.util.*;

class Sum2PolP
{
    //methods
    public static ArrayList<Integer>  Add(ArrayList<Integer> pol1, ArrayList<Integer>pol2, int p)
    {
        int i;
        ArrayList<Integer> answer = new ArrayList<Integer>(pol1.size());
        
        for(i = 0; i < pol1.size(); i++)
        {
            answer.add(Math.floorMod((pol1.get(i) + pol2.get(i)) , p)); 
        }

        return answer;
    }

    // public static void main(String args[])
    // {
    //     ArrayList<Integer> pol1 = new ArrayList<Integer>(List.of(3,0,4,5));
    //     ArrayList<Integer> pol2 = new ArrayList<Integer>(List.of(6,2,4,5));
    //     ArrayList<Integer> ans = Add(pol1,pol2,3);

    //     for(int i = 0; i < ans.size(); i++)
    //     {
    //         System.out.println(ans.get(i));
    //     }
    // }
}

