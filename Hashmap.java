import java.util.HashMap;

class Solution {
    public static void main(String args[]) {
        HashMap<Integer, String> hm1 = new HashMap<>(5, 0.75f);
        HashMap<Integer, String> hm2 = new HashMap<Integer, String>(3, 0.5f);

        hm1.put(1, "one");
        hm1.put(2, "two");
        hm1.put(3, "three");

        hm2.put(4, "four");
        hm2.put(5, "five");
        hm2.put(6, "six");

        System.out.println("Mappings of HashMap hm1 are : " + hm1);
        System.out.println("Mapping of HashMap hm2 are : " + hm2);
    }
}
