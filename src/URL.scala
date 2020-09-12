object URL{
    def apply(protocol:String,domain:String,path:String, params:Map[String,String]):String = {
    val protocolwithdomain = protocol + "://" + domain
    val urlwithpath =protocolwithdomain + path
    val queryString = new StringBuilder("")
         for((key,value)<-params){queryString.append(key+"="+value+"&")}
    val url=urlwithpath + "?" + queryString
    url}

    def unapply(url:String):Option[(String , String, String,Map[String,String])] = {
    val proto= url split "://"
    if(proto.length == 2) {
   val protocol = proto(0)
   val domain = proto(1).takeWhile(_ != '/')
   val prePath = proto(1).takeWhile(_ != '?')
   val path = prePath.dropWhile(_ != '/')
   val preparam = url.substring(url.indexOf('?')+1)
   val preparam1=preparam split "&"
   val premap1=preparam1(0) split "="
   val premap2=preparam1(1) split "="
   val premap3=preparam1(2) split "="
   val param= Map(premap1(0) -> premap1(1),premap2(0) -> premap2(1), premap2(0) -> premap2(1),premap3(0) -> premap3(1))
    Some(protocol,domain,path,param)}
  else None
  }
    }
object Main extends App {
     val param =  Map("state" -> "hash", "isauthcode" -> "true", "code" -> "112")
  println("")
  val UrlObj = URL("https","aws.amazon.com","/console/home",param)
  println(s"Url: $UrlObj")
  println("")
  val URL(protocol,domain,path ,params) = UrlObj
  println(s"protocol= $protocol")
  println(s"domain= $domain")
  println(s"path= $path")
  println(s"params= $params")
}