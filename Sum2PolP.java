import java.util.ArrayList;

class Sum2PolP
{
    //methods
    public static ArrayList<Integer>  Add(ArrayList<Integer> pol1, ArrayList<Integer>pol2, int p)
    {
        int i;
        ArrayList<Integer> answer = new ArrayList<Integer>(pol1.size());
        
        for(i = 0; i < pol1.size(); i++)
        {
            answer.set(i, (pol1.get(i) + pol2.get(i)) % p); 
        }

        return answer;
    }
}

