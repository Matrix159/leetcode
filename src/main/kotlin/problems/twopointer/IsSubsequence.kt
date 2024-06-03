package problems.twopointer

/**
 * # 392. Is Subsequence
 * ## Two Pointer
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a sequence of characters that can be obtained by deleting some (or none) of the
 * characters from the original string, while maintaining the relative order of the remaining characters. For example,
 * "ace" is a subsequence of "abcde" while "aec" is not.
 */
fun isSubsequence(s: String, t: String): Boolean {
  var sIndex = 0
  var tIndex = 0

  while (sIndex < s.length && tIndex < t.length) {
    if (s[sIndex] == t[tIndex]) {
      sIndex++
    }

    tIndex++
  }

  return sIndex == s.length
}