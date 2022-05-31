import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void testTwoSumCase01(){
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] expected = new int[]{0,1};
        assertArrayEquals(expected ,new Solution().twoSum(nums, target));
    }

    @Test
    public void testTwoSumCase02(){
        int[] nums = new int[]{3,2,4};
        int target = 6;
        int[] expected = new int[]{1,2};
        assertArrayEquals(expected ,new Solution().twoSum(nums, target));
    }

    @Test
    public void testTwoSumCase03(){
        int[] nums = new int[]{3,3};
        int target = 6;
        int[] expected = new int[]{0,1};
        assertArrayEquals(expected ,new Solution().twoSum(nums, target));
    }

    @Test
    public void testAddTwoNumbersCase01(){
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode expected = new ListNode(7, new ListNode(0, new ListNode(8)));
        ListNode actual = new Solution().addTwoNumbers(l1, l2);
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
        ListNode actual = new Solution().addTwoNumbers(l1, l2);
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
        ListNode actual = new Solution().addTwoNumbers(l1, l2);
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
        ListNode actual = new Solution().addTwoNumbers(l1, l2);
        assertNotNull(actual);
        while(expected != null && actual != null ){
            assertEquals(expected.val, actual.val);
            expected = expected.next;
            actual = actual.next;
        }
    }
}
