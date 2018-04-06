package main

object Start extends App {

  def findMissing(): Unit ={
    val a  = Array[Int](1,2,3,4,5,6,8,9)
    val n = 9
    var sum =1
    for (i <- a){
      println(i +"Next")
      sum = sum ^ i
      println(sum)
    }
    println(3%2)

  }

  findMissing
  

}
