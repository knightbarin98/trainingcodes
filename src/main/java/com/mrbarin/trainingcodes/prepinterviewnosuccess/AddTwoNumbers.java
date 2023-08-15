package com.mrbarin.trainingcodes.prepinterviewnosuccess;

public class AddTwoNumbers {
	
	public static void main (String [] args)
	{
		AddTwoNumbers a = new AddTwoNumbers();
		
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while(l1 != null || l2 !=null || carry != 0){
            int v1 = l1 !=null ? l1.val : 0;
            int v2 = l2 !=null ? l2.val : 0;

            int val = v1+v2+carry;
            carry = val / 10;
            val = val % 10;
            cur.next = new ListNode(val);

            cur = cur.next;
            l1 = l1 !=null ? l1.next : null;
            l2 = l2 !=null ? l2.next : null;
        
        }

        return dummy.next;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
