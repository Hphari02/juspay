/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        List<Integer> mergedList = new ArrayList<>();
        
        // Merge all lists into one sorted list
        for (ListNode list : lists) {
            List<Integer> listValues = convertToList(list);
            mergedList = mergeTwoSortedLists(mergedList, listValues);
        }
        
        // Convert merged list to ListNode format
        return convertToLinkedList(mergedList);
    }
    
    private List<Integer> convertToList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        return list;
    }
    
    private List<Integer> mergeTwoSortedLists(List<Integer> l1, List<Integer> l2) {
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;
        
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) < l2.get(j)) {
                merged.add(l1.get(i));
                i++;
            } else {
                merged.add(l2.get(j));
                j++;
            }
        }
        
        while (i < l1.size()) {
            merged.add(l1.get(i));
            i++;
        }
        
        while (j < l2.size()) {
            merged.add(l2.get(j));
            j++;
        }
        
        return merged;
    }
    
    private ListNode convertToLinkedList(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        
        ListNode dummyHead = new ListNode(-1); // Dummy head
        ListNode current = dummyHead;
        
        for (int value : list) {
            current.next = new ListNode(value);
            current = current.next;
        }
        
        return dummyHead.next; // Skip dummy head
    }
}
