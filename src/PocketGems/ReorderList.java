package PocketGems;

//class ListNode {
//	 int val;
//	 ListNode next;
//	 ListNode(int x) { val = x; }
//}

public class ReorderList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		reorderList(l1);
	}
	
	public static void reorderList(ListNode head) {
		ListNode temp = head;
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        ListNode pt1 = head, pt2 = head;
        while(pt2.next != null && pt2.next.next != null){
            pt1 = pt1.next;
            pt2 = pt2.next.next;
        }
        ListNode second = reverse(pt1.next);
        pt1.next = null;
        ListNode cur1 = head;
        ListNode cur2 = second;
        while(cur1 != null && cur2 != null){
        	head = head.next;
        	cur1.next = second;
        	cur1 = head;
        	second = second.next;
        	cur2.next = head;
        	cur2 = second;
        }
//        ListNode secondHead = second;
//        ListNode result = new ListNode(1);
//        ListNode temp = result;
//        int flag = 1;
//        while(head != secondHead && head != null && second != null){
//            if(flag == 0){
//                result.next = head;
//                head = head.next;
//                flag = 1;
//            }
//            else{
//                result.next = second;
//                second = second.next;
//                flag = 0;
//            }
//            result = result.next;
//        }
        head = temp;
        return;
    }
    
    public static ListNode reverse(ListNode head){
        if(head.next == null){
            return head;
        }
        ListNode prev = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

}
