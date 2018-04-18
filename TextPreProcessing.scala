import scala.util.matching.Regex

object HelloWorld {
   def main(args: Array[String]) {
       
      val pattern  = "(\\w+(\\-||)\\w+\\.\\w+\\.[a-z0-9.]*)".r
      val pattern2 = "[0-9]".r
      val pattern3 = "((\\w+||)\\@vm\\-\\_.+\\@)".r
      val pattern4 = "['()%:.,/>-]".r
      //val pattern5 = "\\s\\s+".r
      
      val str = "High Queue Latency Threshold Violation Detected. Currently .% of the (CPU Utilization) data values,  out of a total of , in the last  minutes violated"
      
      var replaced    = pattern.replaceAllIn(str, "")
      replaced = "\\.\\/.+".r.replaceAllIn(replaced, "")
      replaced = pattern2.replaceAllIn(replaced, "")
      replaced = pattern3.replaceAllIn(replaced, "")
      replaced = pattern4.replaceAllIn(replaced, " ")
      replaced = "\\s\\s+".r.replaceAllIn(replaced, " ")
      replaced = "\\s[A-Za-z]\\z||\\s".r.replaceAllIn(replaced, "")
      
      println(replaced.toLowerCase())
      
   }
}
