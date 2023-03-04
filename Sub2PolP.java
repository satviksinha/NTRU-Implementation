import java.util.ArrayList;

class Sub2PolP{
    //method for performing subtraction of two polynomials 
    public static ArrayList<Integer>  Sub(ArrayList<Integer> pol1, ArrayList<Integer>pol2, int p)
    {
        ArrayList<Integer> sub2polp = new ArrayList<Integer>(pol1.size());
        for(int i=0;i<pol1.size();i++){
            sub2polp.set(i,(pol1.get(i) - pol2.get(i)) % p);
        } 
        
        return sub2polp;
    }
}