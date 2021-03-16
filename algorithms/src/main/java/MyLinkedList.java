import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyLinkedList {


    public static void main(String[] args) {
        int[] list = { 1,2,3,4,5};
        ListNode last=null;
        ListNode head = null;

        for (int n : list){
            ListNode node = new ListNode(n);
            if (head == null){
                head = node;

            } else {
                last = head;
                while(last.next!= null){
                    last = last.next;
                }
                last.next = node;
            }
        }

        System.out.println("args = " + Arrays.deepToString(args));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}