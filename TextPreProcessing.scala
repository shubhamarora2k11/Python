import scala.util.matching.Regex

object HelloWorld {
   def main(args: Array[String]) {
      
      val str = "host on ABCD-CDEF-xyz"
      
      var replaced    = "(\\w+(\\-||)\\w+\\.\\w+\\.[a-z0-9.]*)".r.replaceAllIn(str, "")
      
      replaced = "[0-9]".r.replaceAllIn(replaced, "")
      replaced = "on\\s\\w+-\\w+".r.replaceAllIn(replaced, "")
      replaced = "\\.\\/.+".r.replaceAllIn(replaced, "")
      replaced = "((\\w+||)\\@vm\\-\\_.+\\@)".r.replaceAllIn(replaced, "")
      replaced = "['_()%:.,/>/<\\[\\]\\\\*#-]".r.replaceAllIn(replaced, " ")
      replaced = "\\s[A-Za-z]\\z".r.replaceAllIn(replaced, "")
      replaced = "\\s[A-Za-z]\\s".r.replaceAllIn(replaced, "")
      replaced = "\\s\\s+".r.replaceAllIn(replaced, " ")
      
      replaced = replaced.toLowerCase()
      
      //additional
      
      replaced = "database\\s.+\\sstatus".r.replaceAllIn(replaced, "database status")
      replaced = "host\\s\\w+.+\\sis unreachable".r.replaceAllIn(replaced, "host is unreachable")
      replaced = ".+\\sping\\sdevice\\savailability".r.replaceAllIn(replaced, "ping device availability")
      replaced = ".+\\svmware\\svcenter".r.replaceAllIn(replaced, "vmware vcenter")
      
      println(replaced)
      
   }
}
