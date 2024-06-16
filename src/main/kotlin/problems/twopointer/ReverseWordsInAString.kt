package problems.twopointer

/**
 * # Reverse Words in a String III
 * ## Two pointer
 *
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 *
 * Example 2:
 *
 * Input: s = "Mr Ding"
 * Output: "rM gniD"
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 5 * 104
 *     s contains printable ASCII characters.
 *     s does not contain any leading or trailing spaces.
 *     There is at least one word in s.
 *     All the words in s are separated by a single space.
 */
fun reverseWords(s: String): String {
  val arr = s.toCharArray()
  var i = 0
  while (i < arr.size) {
    var start = i
    while (i < arr.size && arr[i] != ' ') {
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