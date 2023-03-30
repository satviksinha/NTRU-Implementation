//tested - working correctly
import java.util.*;

class Sub2PolP{
    //method for performing subtraction of two polynomials 
    public static ArrayList<Integer>  Sub(ArrayList<Integer> pol1, ArrayList<Integer>pol2, int p)
    {
        ArrayList<Integer> sub2polp = new ArrayList<Integer>(pol1.size());
        for(int i=0;i<pol1.size();i++){
            sub2polp.add(Math.floorMod((pol1.get(i) - pol2.get(i)) ,p));
        } 
        
        return sub2polp;
    }

    public static void main(String args[])
    {
        ArrayList<Integer> pol1 = new ArrayList<Integer>(List.of(3,0,4,5));
        ArrayList<Integer> pol2 = new ArrayList<Integer>(List.of(6,2,4,5));
        ArrayList<Integer> ans = Sub(pol1,pol2,3);

        for(int i = 0; i < ans.size(); i++)
        {
            System.out.println(ans.get(i));
        }
    }
}