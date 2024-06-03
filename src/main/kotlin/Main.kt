import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import java.util.HashMap


fun main() {
//  println(
//    Solution().getAverages(arrayOf(40527, 53696, 10730, 66491, 62141, 83909, 78635, 18560).toIntArray(), 2)
//      .joinToString(", ")
//  )
  println(Testing().fibonacci(6))
}

class Testing {
  var memo = mutableMapOf<Int, Int>()

  fun fibonacci(n: Int): Int {
    if (n == 0) {
      return 0
    }
    if (n == 1) {
      return 1
    }

    if (memo.containsKey(n)) {
      println("Contained ${n}")
      return memo[n]!!
    }

    memo[n] = fibonacci(n - 1) + fibonacci(n - 2)
    return memo[n]!!
  }
}

class Solution {

  /**
   * Fixed window
   * You are given an integer array nums consisting of n elements, and an integer k.
   *
   * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
   * Any answer with a calculation error less than 10-5 will be accepted.
   */
  fun findMaxAverage(nums: IntArray, k: Int): Double {
    var sum = 0.0
    for (i in 0..<k) {
      sum += nums[i]
    }

    var ans = sum
    for (i in k..<nums.size) {
      sum += nums[i] - nums[i - k]
      ans = max(ans, sum)
    }

    return ans / k
  }

  /**
   * Sliding window
   * Given a binary array nums and an integer k, return the maximum number of
   * consecutive 1's in the array if you can flip at most k 0's.
   */
  fun longestOnes(nums: IntArray, k: Int): Int {
    var ans = 0

    var curr = 0
    var left = 0

    for (right in nums.indices) {
      if (nums[right] == 0) {
        curr += 1
      }
      while (curr > k) {
        if (nums[left] == 0) {
          curr--
        }
        left++
      }

      ans = max(ans, right - left + 1)
    }

    return ans
  }

  /**
   * Prefix sum
   * Given an array of integers nums, you start with an initial positive value startValue.
   *
   * In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).
   *
   * Return the minimum positive value of startValue such that the step by step sum is never less than 1.
   */
  fun minStartValue(nums: IntArray): Int {
    var prefixSum = IntArray(nums.size)
    prefixSum[0] = nums[0]
    var minPrefix = prefixSum[0]

    for (i in 1 until nums.size) {
      prefixSum[i] = prefixSum[i - 1] + nums[i]
      minPrefix = min(prefixSum[i], minPrefix)
    }

    if (minPrefix < 1) {
      return abs(minPrefix) + 1
    } else {
      return 1
    }
  }

  /**
   * Prefix sum, could have been done with sliding window
   * You are given a 0-indexed array nums of n integers, and an integer k.
   *
   * The k-radius average for a subarray of nums centered at some index i with the radius k is the average of all elements in nums between the indices i - k and i + k (inclusive). If there are less than k elements before or after the index i, then the k-radius average is -1.
   *
   * Build and return an array avgs of length n where avgs[i] is the k-radius average for the subarray centered at index i.
   *
   * The average of x elements is the sum of the x elements divided by x, using integer division. The integer division truncates toward zero, which means losing its fractional part.
   *
   *     For example, the average of four elements 2, 3, 1, and 5 is (2 + 3 + 1 + 5) / 4 = 11 / 4 = 2.75, which truncates to 2.
   *
   */
  fun getAverages(nums: IntArray, k: Int): IntArray {
    val prefixSum = LongArray(nums.size)
    prefixSum[0] = nums[0].toLong()

    val ansArray = IntArray(nums.size)

    for (i in 1 until nums.size) {
      prefixSum[i] = prefixSum[i - 1] + nums[i]
    }

    for (i in nums.indices) {
      if (k == 0) {
        ansArray[i] = nums[i]
        continue
      }
      if (i - k < 0 || i + k > nums.size - 1) {
        ansArray[i] = -1
      } else {
        val lowerBound = if (i - k == 0) 0 else prefixSum[i - (k + 1)]
        val totalItems = k * 2 + 1
        ansArray[i] = ((prefixSum[i + k] - lowerBound) / totalItems).toInt()
      }
    }
    return ansArray
  }

  /**
   * HashMap
   * A pangram is a sentence where every letter of the English alphabet appears at least once.
   *
   * Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
   */
  fun checkIfPangram(sentence: String): Boolean {
    val charSet = mutableSetOf<Char>()

    for (i in sentence) {
      charSet.add(i)
    }
    return charSet.size == 26
  }

  /**
   * You are given an integer array matches where matches[i] = [winneri, loseri] indicates that the player winneri defeated player loseri in a match.
   *
   * Return a list answer of size 2 where:
   *
   *     answer[0] is a list of all players that have not lost any matches.
   *     answer[1] is a list of all players that have lost exactly one match.
   *
   * The values in the two lists should be returned in increasing order.
   *
   * Note:
   *
   *     You should only consider the players that have played at least one match.
   *     The testcases will be generated such that no two matches will have the same outcome.
   *
   */
  fun findWinners(matches: Array<IntArray>): List<List<Int>> {

//    // player losses
//    val winners = mutableSetOf<Int>()
//    val losers = mutableSetOf<Int>()
//    for (i in matches.indices) {
//      val loss = matches[i][1]
//      if (!losses.containsKey(i)) {
//        losses[i] = 1
//        continue
//      }
//      losses[i]?.let {
//        losses[i] = it + loss
//      }
//    }
//
    return emptyList()
  }

  /**
   * Frequency hash map
   * Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
   *
   * You can use each character in text at most once. Return the maximum number of instances that can be formed.
   */
  fun maxNumberOfBalloons(text: String): Int {
    val frequencyInText = mutableMapOf<Char, Int>()
    val frequencyInPattern = mutableMapOf<Char, Int>()

    val stringToFind = "balloon"

    for (value in text) {
      val existingCount = frequencyInText.getOrDefault(value, 0)
      frequencyInText[value] = existingCount + 1
    }

    for (value in "balloon") {
      val existingCount = frequencyInPattern.getOrDefault(value, 0)
      frequencyInPattern[value] = existingCount + 1
    }

    var answer = Int.MAX_VALUE
    for (value in stringToFind) {
      if (frequencyInPattern.getOrDefault(value, 0) == 0) {
        continue
      }
      answer = min(answer, frequencyInText.getOrDefault(value, 0) / frequencyInPattern.getOrDefault(value, 0))
    }

    return answer
  }

  class ListNode(var `val`: Int) {
    var next: ListNode? = null
  }

  /**
   * Linked Lists
   * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
   */
  fun deleteDuplicates(head: ListNode?): ListNode? {
    var pointer = head
    while (pointer?.next != null) {
      if (pointer.`val` == pointer.next!! .`val`) {
        pointer.next = pointer.next?.next
      } else {
        pointer = pointer.next
      }
    }

    return head
  }
}

