import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode ans=new ListNode();
        ListNode temp=ans;

        int carry=0;
        while(l1!=null || l2!=null || carry!=0){
            int sum=0;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }

            sum+=carry;
            carry=sum/10;
            ListNode cur=new ListNode(sum%10);
            temp.next=cur;
            temp=temp.next;
        }
        return ans.next;
        
    }
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode head1 = new ListNode(sc.nextInt());
        for (int i = 0; i < n; i++) {
            head1.next = new ListNode(sc.nextInt());
            head1 = head1.next;
        }
       int m = sc.nextInt();
        ListNode head2 = new ListNode(sc.nextInt());
        for (int i = 0; i < m; i++) {
            head2.next = new ListNode(sc.nextInt());
            head2 = head2.next;
        }
        Solution solution = new Solution();
        ListNode addedListNode = solution.addTwoNumbers(head1, head2);

       while(addedListNode.next!=null) {
            System.out.println(addedListNode.val);
            addedListNode = addedListNode.next;
        } 
    }
}
