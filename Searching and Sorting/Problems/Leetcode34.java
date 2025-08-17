//34. Find First and Last Position of Element in Sorted Array
public class Leetcode34 {

        public int[] searchRange(int[] nums, int target) {
            int first = findFirst(nums, target);
            int last = findLast(nums, target);
            return new int[] {first, last};
        }

        private int findFirst(int[] nums, int target) {
            int low = 0, high = nums.length - 1;
            int result = -1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (nums[mid] == target) {
                    result = mid;
                    high = mid - 1;
                } else if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            return result;
        }

        private int findLast(int[] nums, int target) {
            int low = 0, high = nums.length - 1;
            int result = -1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (nums[mid] == target) {
                    result = mid;
                    low = mid + 1;
                } else if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return result;
        }
}
