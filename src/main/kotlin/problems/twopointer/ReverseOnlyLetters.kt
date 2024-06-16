package problems.twopointer

/**
 * # 917. Reverse Only Letters
 * # Two pointer
 *
 * Given a string s, reverse the string according to the following rules:
 *
 *     All the characters that are not English letters remain in the same position.
 *     All the English letters (lowercase or uppercase) should be reversed.
 *
 * Return s after reversing it.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ab-cd"
 * Output: "dc-ba"
 *
 * Example 2:
 *
 * Input: s = "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 *
 * Example 3:
 *
 * Input: s = "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 100
 *     s consists of characters with ASCII values in the range [33, 122].
 *     s does not contain '\"' or '\\'.
 */
fun reverseOnlyLetters(s: String): String {
  val arr = s.toCharArray()
  var i = 0
  while (i < arr.size) {
    var start = i
    while (i < arr.size && arr[i].toChar() != ' ') {
      i++
    }
    var end = i - 1
    while (start < end) {
      val temp = arr[start]
      arr[start] = arr[end]
      arr[end] = temp
      start++
      end--
    }
    i++
  }
  return String(arr)
}