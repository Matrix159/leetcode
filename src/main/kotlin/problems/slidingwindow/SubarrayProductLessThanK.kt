package problems.slidingwindow

import kotlin.math.max

/**
 * # 713. Subarray Product Less Than K
 * ## Sliding window
 *
 * Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product
 * of all the elements in the subarray is strictly less than k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,5,2,6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are:
 * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 *
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 0
 * Output: 0
 */
fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
  if (k <= 1) {
    return 0
  }

  var left = 0
  var sum = 1
  var answer = 0

  for (right in nums.indices) {
    sum *= nums[right]
    while (sum >= k) {
      sum /= nums[left]
      left++
    }
    answer += right - left + 1
  }

  return answer
}