package problems.twopointer

/**
 * # 977. Squares of a Sorted Array
 * ## Two Pointer
 *
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 *
 * Example 1:
 *
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 *
 * Example 2:
 *
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 */
fun sortedSquares(nums: IntArray): IntArray {
  var first = 0
  var second = nums.size - 1
  var lastInsertedIndex = nums.size - 1

  val resultArray = IntArray(nums.size)
  while (lastInsertedIndex >= 0) {
    // Need to insert from the end of the array
    val squareFirst = nums[first] * nums[first]
    val squareSecond = nums[second] * nums[second]
    if (squareFirst > squareSecond) {
      resultArray[lastInsertedIndex] = squareFirst
      first++
    } else {
      resultArray[lastInsertedIndex] = squareSecond
      second--
    }
    lastInsertedIndex--
  }
  return resultArray
}