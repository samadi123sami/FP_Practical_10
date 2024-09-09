package prac10_22001816

object Q5 {
  def countLetterOccurrences(words: List[String]): Int = {
    val lengths = words.map(_.length)
    val totalLetters = lengths.reduce(_ + _)
    totalLetters
  }

  def main(args: Array[String]): Unit = {
    val words = List("apple", "banana", "cherry", "date")
    val total = countLetterOccurrences(words)
    println(s"Total count of letter occurrences: $total")
  }
}
