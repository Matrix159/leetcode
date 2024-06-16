package problems.slidingwindow

import kotlin.math.max

/**
 * # 1004. Max Consecutive Ones III
 * ## Sliding window
 *
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can
 * flip at most k 0's.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 *
 * Example 2:
 *
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 *
 * Constraints:
 *     1 <= nums.length <= 10^5
 *     nums[i] is either 0 or 1.
 *     0 <= k <= nums.length
 */
fun longestOnes(nums: IntArray, k: Int): Int {
  var ans = 0

  var curr = 0
  var left = 0

  for (right in nums.indices) {
    if(nums[right] == 0) {
      curr += 1
    }
    while (curr > k) {
      // If the left side of the window is a 0 and we've used up our k-amount, we can subtract from our
      // used amount since it's leaving the window
      if (nums[left] == 0) {
        curr--
      }
      left++
    }

    ans = max(ans, right - left + 1)
  }

  return ans
}