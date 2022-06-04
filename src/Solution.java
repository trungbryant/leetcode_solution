import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution{
    /**
     * Return indices of two numbers such that they add up to target.
     * 
     * @param nums
     * @param target
     * @return list indices that element satified target, empty list otherwise.
     */
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            Integer remainId = map.get(target - nums[i]);
            if(remainId != null){
                return new int[]{remainId, i};
            }else{
                map.put(nums[i], i);
            }
        }
        return new int[2];
    }

    /**
     * Return the sum as linked list which two non-empty linked lists representing two non-negative integers. 
     * The digits are stored in reverse order, and each of their nodes contains a single digit.
     * Function to add two numbers.
     * 
     * @param l1
     * @param l2
     * @return the sum as linked list
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode res = new ListNode();
        ListNode tem = res;
        int plus = 0;
        while((l1 != null && l2 != null) || plus != 0){
            int sum = plus;
            plus = 0;
            sum += l1 != null ? l1.val : 0;
            sum += l2 != null ? l2.val : 0;
            if(sum >= 10){
                plus = sum/10;
                sum %= 10;
            }    
            tem.next = new ListNode(sum);
            l2 = l2 != null ? l2.next : l2;
            l1 = l1 != null ? l1.next : l1;
            tem = tem.next;   
        }
        if(l1 != null){
            tem.next = l1;
        }
        if(l2 != null){
            tem.next = l2;
        }
        return res.next;
    }

    /**
     * Return the length of longest substring without repeating characters.
     * 
     * @param s
     * @return longest substring.
     */
    public int lengthOfLongestSubString(String s){
        Set<Character> set = new HashSet<>();
        int start = 0;
        int end  = 0;
        int longest = 0;
        char[] arr = s.toCharArray();
        for(end = 0; end < arr.length; end++){
            if(set.contains(arr[end])){
                longest = Math.max(longest, end - start);
                for(int i = start; i < end; i++){
                    
                    if(arr[i] == arr[end]){
                        start = i+1;
                        break;
                    }
                    set.remove(arr[i]); 
                }
                                
            }else{
                set.add(arr[end]);
            }
        }
        return Math.max(longest, set.size());
    }

    /**
     * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
     * The overall run time complexity should be O(log (m+n)))
     * 
     * @param nums1
     * @param nums2
     * @return the median of the two sorted arrays
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int k = 0;
        double median = 0.0;
        int min = 0;
        double avg = (double) (nums1.length + nums2.length)/2;
        while(k <= (nums1.length + nums2.length)/2){
            if(i < nums1.length && j < nums2.length){
                if(nums1[i] < nums2[j]){
                    min = nums1[i];
                    i++;
                }else{
                    min = nums2[j];
                    j++;
                }
            }else if(i < nums1.length ){
                min = nums1[i];
                i++;
            }else{
                min = nums2[j];
                j++;
            }
            if(k == (int) avg - 1 && avg == (int) avg){
                median += min;
            }
            else if(k == (int)avg){
                median += min;
                if(avg == (int) avg){
                    median /= 2;
                }
            }
            k++;
        }
        return median;
    }
}
