

object ParsingEmail extends App{
  val Email = """([\w\.]+)@([\w\.]+)""".r
  ParsingEmail.emailParser("shradhasaxena@gmail.com")
  println("")
  ParsingEmail.emailParser("shivani.saxena@gmail.com")
  println("")
  def emailParser(emailId:String):Unit ={
    emailId match {
         case Email(user,domain)=> println(s"User: $user \nDomain: $domain")
         case _ => println("Invalid email id")
     }

}
}