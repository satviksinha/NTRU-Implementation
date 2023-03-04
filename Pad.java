import java.util.ArrayList;

public class Pad 
{   
    public static ArrayList<ArrayList<Integer>> Padding(ArrayList<Integer> pol1, ArrayList<Integer> pol2)
    {
        int s1 = pol1.size();
        int s2 = pol2.size();
        
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>(2) ;
       
        if(s1 > s2)
        {
            answer.set(0,pol1);
            for(int i = 0; i < s1-s2; i++)
            {
                pol2.add(0);
            }

            answer.set(1,pol2);

        }

        else if(s1 < s2)
        {
            answer.set(1,pol2);
            for(int i = 0; i < s2-s1; i++)
            {
                pol1.add(0);
            }
            answer.set(0,pol1);
        }

        return answer;
    }    
}
