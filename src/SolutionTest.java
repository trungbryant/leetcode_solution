import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SolutionTest {
    Solution solution = new Solution();
    @Test
    public void testTwoSumCase01(){
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] expected = new int[]{0,1};
        assertArrayEquals(expected ,solution.twoSum(nums, target));
    }

    @Test
    public void testTwoSumCase02(){
        int[] nums = new int[]{3,2,4};
        int target = 6;
        int[] expected = new int[]{1,2};
        assertArrayEquals(expected ,solution.twoSum(nums, target));
    }

    @Test
    public void testTwoSumCase03(){
        int[] nums = new int[]{3,3};
        int target = 6;
        int[] expected = new int[]{0,1};
        assertArrayEquals(expected ,solution.twoSum(nums, target));
    }

    @Test
    public void testAddTwoNumbersCase01(){
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode expected = new ListNode(7, new ListNode(0, new ListNode(8)));
        ListNode actual = solution.addTwoNumbers(l1, l2);
        assertNotNull(actual);
        while(expected != null && actual != null ){
            assertEquals(expected.val, actual.val);
            expected = expected.next;
            actual = actual.next;
        }
    }

    @Test
    public void testAddTwoNumbersCase02(){
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode expected = new ListNode(0);
        ListNode actual = solution.addTwoNumbers(l1, l2);
        assertNotNull(actual);
        while(expected != null && actual != null ){
            assertEquals(expected.val, actual.val);
            expected = expected.next;
            actual = actual.next;
        }
    }

    @Test
    public void testAddTwoNumbersCase03(){
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode expected = new ListNode(8, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(1))))))));
        ListNode actual = solution.addTwoNumbers(l1, l2);
        assertNotNull(actual);
        while(expected != null && actual != null ){
            assertEquals(expected.val, actual.val);
            expected = expected.next;
            actual = actual.next;
        }
    }

    @Test
    public void testAddTwoNumbersCase04(){
        ListNode l1 = new ListNode(1, new ListNode(8));
        ListNode l2 = new ListNode(0);
        ListNode expected = new ListNode(1, new ListNode(8));
        ListNode actual = solution.addTwoNumbers(l1, l2);
        assertNotNull(actual);
        while(expected != null && actual != null ){
            assertEquals(expected.val, actual.val);
            expected = expected.next;
            actual = actual.next;
        }
    }

    @Test
    public void testLengthOfLongestSubstringCase01(){
        String s = "abcabcbb";
        int expected = 3;
        assertEquals(expected, solution.lengthOfLongestSubString(s));
    }

    @Test
    public void testLengthOfLongestSubstringCase02(){
        String s = "bbbbb";
        int expected = 1;
        assertEquals(expected, solution.lengthOfLongestSubString(s));
    }

    @Test
    public void testLengthOfLongestSubstringCase03(){
        String s = "pwwkew";
        int expected = 3;
        assertEquals(expected, solution.lengthOfLongestSubString(s));
    }

    @Test
    public void testLengthOfLongestSubstringCase04(){
        String s = " ";
        int expected = 1;
        assertEquals(expected, solution.lengthOfLongestSubString(s));
    }

    @Test
    public void testLengthOfLongestSubstringCase05(){
        String s = "au";
        int expected = 2;
        assertEquals(expected, solution.lengthOfLongestSubString(s));
    }

    @Test
    public void testFindMedianSortedArraysCase01(){
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        double expected = 2.00000;
        assertTrue(expected == solution.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testFindMedianSortedArraysCase02(){
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        double expected = 2.50000;
        assertTrue(expected == solution.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testFindMedianSortedArraysCase03(){
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{2,3};
        double expected = 2.50000;
        assertTrue(expected == solution.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testLongestPalindromeCase01(){
        String s = "babad";
        String expected = "bab";
        assertEquals(expected, solution.longestPalindrome(s));
    }

    @Test
    public void testLongestPalindromeCase02(){
        String s = "cbbd";
        String expected = "bb";
        assertEquals(expected, solution.longestPalindrome(s));
    }

    @Test
    public void testConvertStringCase01(){
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String expected = "PAHNAPLSIIGYIR";

        assertEquals(expected, solution.convertString(s, numRows));
    }

    @Test
    public void testConvertStringCase02(){
        String s = "PAYPALISHIRING";
        int numRows = 4;
        String expected = "PINALSIGYAHRPI";

        assertEquals(expected, solution.convertString(s, numRows));
    }

    @Test
    public void testReverseCase01(){
        int x = 123;        // 001111011
        int expected = 321; // 101000001
        assertEquals(expected, solution.reverse(x));
    }

    @Test
    public void testReverseCase02(){
        int x = -123;       // -001111011
        int expected = -321;// -101000001
        assertEquals(expected, solution.reverse(x));
    }

    @Test
    public void testReverseCase03(){
        int x = 120;        // 1111000
        int expected = 21;  // 0010101
        assertEquals(expected, solution.reverse(x));
    }

    @Test
    public void testReverseCase04(){
        int x = 1534236469;
        int expected = 0;
        assertEquals(expected, solution.reverse(x));
    }

    @Test
    public void testMyAtoiCase01(){
        String s = "42";
        int expected = 42;
        assertEquals(expected, solution.myAtoi(s));
    }

    @Test
    public void testMyAtoiCase02(){
        String s = "     -42";
        int expected = -42;
        assertEquals(expected, solution.myAtoi(s));
    }

    @Test
    public void testMyAtoiCase03(){
        String s = "4193 with words";
        int expected = 4193;
        assertEquals(expected, solution.myAtoi(s));
    }

    @Test
    public void testMyAtoiCase04(){
        String s = "00000-42a1234";
        int expected = 0;
        assertEquals(expected, solution.myAtoi(s));
    }

    @Test
    public void testMyAtoiCase05(){
        String s = "9223372036854775808";
        int expected = 2147483647;
        assertEquals(expected, solution.myAtoi(s));
    }

    @Test
    public void testIsPalindromeCase01(){
        int x = 121;
        assertTrue(solution.isPalindrome(x));
    }

    @Test
    public void testIsPalindromeCase02(){
        int x = -121;
        assertFalse(solution.isPalindrome(x));
    }

    @Test
    public void testIsPalindromeCase03(){
        int x = 10;
        assertFalse(solution.isPalindrome(x));
    }
}
