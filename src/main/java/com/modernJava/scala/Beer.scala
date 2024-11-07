package com.modernJava.scala

import scala.collection.IterableOnce.iterableOnceExtensionMethods
import scala.io.Source

object Beer {
  def main(args: Array[String]): Unit = {
//    var n : Int = 2
//    while (n <= 6) {
//      println(s"Hello ${n} bottles of beer")
//      n += 1
//    }
    2 to 6 foreach{ n => println(s"Hello ${n} bottles of beer")}

    val authorsToAge = Map("Raoul" -> 23, "Mario" -> 40, "Alan" -> 53)
    println(authorsToAge)

    val authors = List("Raoul", "Mario", "Alan")
//    val numbers = Set(1, 1, 2, 3, 5, 8)
    println(authors)
//    println(numbers)

//    val numbers = Set(2, 5, 3)
//    val newNumbers = numbers + 8;
//    println(numbers)
//    println(newNumbers)

    val fileLines = Source.fromFile("data.txt").getLines().toList
//    val linesLongUpper =
//      fileLines.filter(l => l.length > 10)
//              .map(l => l.toUpperCase())
//    println(linesLongUpper)

//    val linesLongUpper = fileLines filter (_.length > 10) map (_.toUpperCase())
    val linesLongUpper = (fileLines) filter (_.length > 10) map (_.toUpperCase)
    println(linesLongUpper)

    val raoul = ("Raoul", "+ 44 007007007")
    val alan = ("Alan", "+ 44 003133700")
    println(raoul)
    println(alan)

    val book = (2018, "Modern Java in Action", "Manning")
    val numbers = (42, 1337, 0, 3, 14)
    println(book._1)
    println(numbers._4)
  }
}
