package string

object LongestSubstring extends App {

/*
Given a string s, find the length of the longest substring without repeating characters.
*/

/*
Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

  def lengthOfLongestSubstring(s: String): Int = {
    var longest = 0
    var i = 0
    var j = 0
    val n = s.length
    var set = Set[Char]()

    while (i < n && j < n) {
      if (!set.contains(s(j))) {
        set += s(j)
        j += 1
        longest = Math.max(longest, j - i)
      } else {
        set -= s(i)
        i += 1
      }
    }

    longest

  }

  val s = "abcabcbb"
  val res = lengthOfLongestSubstring(s)
  println(res)

}



