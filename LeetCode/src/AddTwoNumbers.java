public class AddTwoNumbers {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return l1 == null ? l2 : l1;
      
        ListNode result = new ListNode();
        ListNode ans = result;
        int carry = 0;
        while(l1 != null && l2 != null){
            int sum = carry + l1.val + l2.val;
            int digit = sum%10;
            carry = sum/10;
            l1 = l1.next;
            l2 = l2.next;
            result.next = new ListNode(digit);
            result = result.next;
        }

        while(l1 != null){
            int sum = carry + l1.val;
            int digit = sum%10;
            carry = sum/10;
            result.next = new ListNode(digit);
            l1 = l1.next;
            result = result.next;
        }

        while(l2 != null){
            int sum = carry + l2.val;
            int digit = sum%10;
            carry = sum/10;
            result.next = new ListNode(digit);
            l2 = l2.next;
            result = result.next;
        }

        if(carry != 0) result.next = new ListNode(carry);
        return ans.next;
    }
}
