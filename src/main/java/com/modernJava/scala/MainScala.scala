package com.modernJava.scala

object MainScala {
  def main(args: Array[String]): Unit = {
    def isJavaMentioned(tweet: String) : Boolean = tweet.contains("Java")
    def isShortTweet(tweet: String) : Boolean = tweet.length < 20

    val tweets = List(
      "I love the new features in Java 8",
      "How's it going?",
      "An SQL query walks into a bar, sees two tables ans says 'Can I join you?'"
    )
    tweets.filter(isJavaMentioned).foreach(println)
    tweets.filter(isShortTweet).foreach(println)

    val isLongTweet : String => Boolean =
      (tweet : String) => tweet.length > 60
//    val isLongTweet : String => Boolean =
//      new Function1 [String, Boolean] {
//        def apply(tweet: String): Boolean = tweet.length > 60
//      }
    val check = isLongTweet.apply("A very short tweet")
    println(check)

    var count = 0
    val inc = () => count+=1
    inc()
    println(count)
    inc()
    println(count)

//    val r = multiply(2, 10)
//    val r = multiplyCurry(2)(10)
    val multiplyByTwo : Int => Int = multiplyCurry(2)
    val r = multiplyByTwo(10)
    println("r: " + r)

    val h = new Hello()
    h.sayThankYou()

    val s = new Student("Raoul", 1)
    println(s.name)
    s.id = 1337
    println(s.id)

    println(new Empty().isEmpty())

    val b1 = new Box() with Sized
    println(b1.isEmpty())
    val b2 = new Box()
//    b2.isEmpty()
  }

  def multiply(x : Int, y: Int) = x + y

  def multiplyCurry(x: Int)(y: Int) = x * y
}
