import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        HashMap<Integer, Integer> mymap = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        if (B > A.size()) {
            return ans;
        }

        for (int i = 0; i < B; i++) {
            int num = A.get(i);
            mymap.put(num, mymap.getOrDefault(num, 0) + 1);
        }

        ans.add(mymap.size());

        for (int i = B; i < A.size(); i++) {
            int numToAdd = A.get(i);
            mymap.put(numToAdd, mymap.getOrDefault(numToAdd, 0) + 1);

            int numToRemove = A.get(i - B);
            mymap.put(numToRemove, mymap.get(numToRemove) - 1);
            if (mymap.get(numToRemove) == 0) {
                mymap.remove(numToRemove);
            }

            ans.add(mymap.size());
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr= new ArrayList<Integer>();
        for(int i=0;i<n ;i++){
            arr.add(sc.nextInt());
        }
        int m = sc.nextInt();
        Solution solution = new Solution();
        ArrayList<Integer> result = solution.dNums(arr, m);
        for(int i=0; i<result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
