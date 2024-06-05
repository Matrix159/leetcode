package problems.twopointer

/**
 * # 344. Reverse String
 * ## Two Pointer
 *
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 * You must do this by modifying the input array in-place with O(1) extra memory.
 */
fun reverseString(s: CharArray): Unit {
  var left = 0
  var right = s.size - 1

  while (left < right) {
    val temp = s[left]
    s[left] = s[right]
    s[right] = temp
    left++
    right--
  }
}