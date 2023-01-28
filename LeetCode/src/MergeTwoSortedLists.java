class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class MergedTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode listNode = new ListNode();
        ListNode current = listNode;
        while(list1 != null && list2 != null){
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            }else{
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        current.next = (list1 != null) ? list1 : list2;
        return listNode.next;
    }
}
