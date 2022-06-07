import java.util.*;
import java.util.stream.Collectors;

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

    /**
     * Given a string s, return the longest palindromic substring in s.
     * 
     * @param s
     * @return longest palindromic substring in s
     */
    public String longestPalindrome(String s) { 
        int length = s.length();
        String result = "";
        int longest = 0;
        boolean[][] dt = new boolean[length][length];
        char[] arr = s.toCharArray();
        for(int end = 0; end < length; end++){
            for(int start = end; start >= 0; start--){
                if(end - start < 3){
                    dt[start][end] = arr[start] == arr[end];
                }else{
                    dt[start][end] = arr[start] == arr[end] && dt[start + 1][end - 1];
                }
                if(dt[start][end] && end - start + 1 > longest){
                    longest = end - start + 1;
                    result = s.substring(start, end + 1);
                }
            }
        }
        return result;
    }

    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
     * 
     * @param s
     * @param numRows
     * @return
     */
    public String convertString(String s, int numRows){
        // 012345678910111213
        // PAYPALISHI R I N G

        // P   A   H   N -> 0   4   8    12
        // A P L S I I G -> 1 3 5 7 9 11 13
        // Y   I   R     -> 2   6   10 

        // P     I    N  -> 0   6    12
        // A   L S  I G  -> 1 5 7 11 13
        // Y A   H R     -> 2 4 8 10
        // P     I       -> 3   9

        // 2*numRows - 2;
        if(numRows == 1){
            return s;
        }
        char[] arr = s.toCharArray();
        int length = s.length();
        int step = 2*numRows - 2;
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < numRows; i++){
            for(int j = i; j < length; j += step){
                result.append(arr[j]);
                if(i != 0 && i != numRows - 1 && j + step - 2*i < length){
                    result.append(arr[j + step - 2*i]);
                }
            }
        }

        return result.toString();
    }

    /**
     * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
     * 
     * @param x
     * @return reverse
     */
    public int reverse(int x){
        if(x == 0)
            return x;
        boolean isNegative = false;
        if(x < 0){
            isNegative = true;
            x *= -1;
        }
        long result = 0;
                
        while(x > 0){
            result = result*10 + x%10;
            x /= 10;
        }
        return result > Integer.MAX_VALUE ? 0 : isNegative ? (int)result*-1 : (int)result;
    }
    /**
     * Convert a string to a 32-bit signed integer
     * 
     * @param s
     * @return integer value of string
     */
    public int myAtoi(String s){
        if(s.isEmpty()){
            return 0;
        }
        long result = 0;
        boolean isNegative = false;
        char[] arr = s.trim().toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= '0' && arr[i] <= '9'){
                result = result*10 + (int)arr[i] - 48;
                if(result > Integer.MAX_VALUE){
                    break;
                }
            }else if(i == 0){
                isNegative = arr[i] == '-';
                if(!isNegative && arr[i] != '+')
                    break;
            }else{
                break;
            }
        }
        return result > Integer.MAX_VALUE ? 
            (isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE) : (isNegative ? (-1)*(int)result : (int)result);
    }

    /**
     * Given an integer x, return true if x is palindrome integer.
     * 
     * @param x
     * @return true if x is palindrome
     */
    public boolean isPalindrome(int x){
        if(x < 0){
            return false;
        }else if(x < 10){
            return true;
        }else{
            int reverse = 0;
            int temp = x;
            while(temp > 0){
                reverse = reverse*10 + temp%10;
                temp /= 10;
            }
            return reverse == x;
        }
    }

    /**
     * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
     * '.' Matches any single character.​​​​
     * '*' Matches zero or more of the preceding element.
     * The matching should cover the entire input string (not partial).
     * 
     * @param s
     * @param p
     * @return true if string match pattern.
     */
    public boolean isMatch(String s, String p){
        return s.matches(p);
    }


    /**
     * Find two lines that together with the x-axis form a container, such that the container contains the most water.
     * Return the maximum amount of water a container can store.
     * 
     * @param height
     * @return maximum amount of water a container can store.
     */
    public int maxArea(int[] height){
        int i = 0;
        int max = 0;
        int min = 0;
        int distance = height.length - 1;
        while(distance > 0){
            if(height[i] < height[i + distance]){
                min = height[i];
                i++;
            }else{
                min = height[i + distance];
            }
            max = Math.max(max, min*distance);
            distance--;
        }
        return max;
    }

    /**
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     * 
     * @param num
     * @return
     */
    public String intToRoman(int num){
        int[] key = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,3,2,1};
        String[] value = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","III","II","I"};
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 15 && num >=1; i++) {
            while(num >= key[i]){
                sb.append(value[i]);
                num -= key[i];
            }
        }        
        return sb.toString();
    }

    /**
     * Given a roman numeral, convert it to an integer.
     * 
     * @param s
     * @return converted integer.
     */
    public int romanToInt(String s){
        int start = 0;
        int i = 0;
        int[] key = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,3,2,1};
        String[] value = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","III","II","I"};
        int result = 0;
        int length = s.length();
        while(i < 15 && start < length){
            if(s.indexOf(value[i], start) == start){
                start += value[i].length();
                result += key[i];
            }else{
                i++;
            }
        }
        return result;
    }

    /**
     * Function to find the longest common prefix string amongst an array of strings.
     * 
     * @param strs
     * @return longest common prefix, blank otherwise.
     */
    public String longestCommonPrefix(String[] strs){
        int j = 0;
        while(true){
            try{
                for(int i = 1; i < strs.length; i++){
                    if(strs[i].charAt(j) != strs[0].charAt(j)){
                        return strs[0].substring(0, j);
                    }
                }
                j++;
            }catch(IndexOutOfBoundsException e){
                return strs[0].substring(0, j);
            }
        }
    }
}
