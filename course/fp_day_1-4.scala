// Databricks notebook source
// MAGIC %md
// MAGIC # Day 1

// COMMAND ----------

print("Hello World!")

// COMMAND ----------

var x = 1
x = 2

// COMMAND ----------

val y = 1
y = 2

// COMMAND ----------

val y: Int = "Test"

// COMMAND ----------

def add(firstInput: Int, secondInput:Int): Int = {
  val sum = firstInput + secondInput
  return sum
}
val addNumber = add(5376,6256)

// COMMAND ----------

def addSimple(firstInput: Int, secondInput:Int): Int = firstInput + secondInput
val addSimpleNumber = add(5376,6256)

// COMMAND ----------

def encode(n: Int, f:(Int) => Long): Long = {
  val x = n * 10
  f(x)
}
val higherOrderFunctionTest1 = encode(10, (x: Int) => (x + 100))
val higherOrderFunctionTest2 = encode(5, (x: Int) => (x + 100))
val higherOrderFunctionTest3 = encode(5, x => x + 100)
val higherOrderFunctionTest4 = encode(5, _ + 100)

// COMMAND ----------

class Car(mk: String, ml: String, cr: String) {
  val make = mk
  val model = ml
  var color = cr
  def repaint(newColor: String) = {
    color = newColor
  }
}
val mustang = new Car("Ford", "Mustang", "Red")
val corvette = new Car("GM", "Corvette", "Black")

// COMMAND ----------

case class Message(from: String, to: String, content: String)

val request = Message("harry", "sam", "discussion")

// COMMAND ----------

def colorToNumber(color: String): Int = {
  val num = color match {
    case "Red" => 1
    case "Blue" => 2
    case "Green" => 3
    case "Yellow" => 4
    case _ => 0
  }
  num
}

val colorName = "Red"
val colorCode = colorToNumber(colorName)
println(s"$colorName => $colorCode")

// COMMAND ----------

def f(x: Int, y: Int, operator: String): Double = {
  operator match {
    case "+" => x + y
    case "-" => x - y
    case "*" => x * y
    case "/" => x.toDouble / y
  }
}

val sum = f(10, 20, "+")
val product = f(10, 20, "*")

def square(x: Int): Int = f(x, x, "*").toInt
def cube(x: Int): Int = f(x, f(x, x, "*").toInt, "*").toInt
def sqrt(x: Int): Double = f(x, x, "/")


// COMMAND ----------

// MAGIC %md
// MAGIC # Day 2

// COMMAND ----------

def f(x: Int): Int = x * 2
def g(x: Int): Int = x + 2
def h(x: Int): Int = f(g(x))

val x = 4

println(s"f(x) = ${f(x)}")
println(s"g(x) = ${g(x)}")
println(s"f(g(x)) = ${f(g(x))}")
println(s"h(x) = ${h(x)}")

// COMMAND ----------


val name: String = "Scala"
val age: Int = 25
val language: Int = "Scala"

// COMMAND ----------


def add(x: Int, y: Int): Int = x + y
val sum = add(10, 20)
println(s"sum = $sum")

// COMMAND ----------

val sumTest = add(10, "20")
println(s"sumTest = $sumTest")

// COMMAND ----------

val x: Int = 10
val y: Int = 20
val z1: Int = x + y
val z2: Int = x.+(y)

// COMMAND ----------

trait Shape {
  def area: Int
}

class Square(length: Int) extends Shape {
  def area: Int = length * length
}

class Rectangle(length: Int, width: Int) extends Shape {
  def area: Int = length * width
}

val square = new Square(10)val area = square.area

// COMMAND ----------

val twoElements = ("10", true)
val threeElements = ("10", "harry", true)
val first = threeElements._1
val second = threeElements._2
val third = threeElements._3

// COMMAND ----------

val  arr = Array(10, 20, 30, 40)
arr(0) = 50
val first = arr(0)

val xs = List(10, 20, 30, 40)
val ys = (1 to 100).toList
val zs = arr.toList
zs.head
zs.tail
zs.isEmpty

val v1 = Vector(10, 20, 30, 40)
val v2 = v1 :+ 50
val v3 = v2 :+ 60
val v4 = v3(4)

// COMMAND ----------

val fruits = Set("apple", "orange", "pear", "banana")
fruits.contains("ananas")
fruits.isEmpty

// COMMAND ----------

val capitals = Map("France" -> "Paris", "USA" -> "Washington D.C.", "UK" -> "London")
val capitalOfFrance = capitals("France")

// COMMAND ----------

val myList = List(1, 2, 3, 4)
val myAnotherList = myList.map((x: Int)=> x * 10.0)
val myAnonymousList = myList.map(_ * 10.0)
val interType = myList.map { x => x * 10.0 }
val functionLiteral = myList.map { _ * 10.0 }

// COMMAND ----------

val line = "Scala is fun"
val SingleSpace = " "
val words = line.split(SingleSpace)
val arrayOfListOfChars = words.flatMap{x => x.toList}

// COMMAND ----------

val myNewList = (1 to 100).toList
val myFiltered = myNewList.filter{_ % 2 == 0}

// COMMAND ----------

val words = "Scala is fun".split(" ")
words.foreach(println)

// COMMAND ----------

val reduceList = List(2, 4, 6, 8, 10)
val sum = reduceList.reduceLeft((x, y) => x + y)

// COMMAND ----------

// MAGIC %md
// MAGIC # Day 4

// COMMAND ----------

// MAGIC %md
// MAGIC ## Pure Functions

// COMMAND ----------

def multiply(a: Int, b: Int): Int = a * b

// COMMAND ----------

val result_after_first_call = multiply(3, 4)

// COMMAND ----------

val result_after_second_call = multiply(3, 4)

// COMMAND ----------

var total = 0

def addToTotal(a: Int): Int = {
  total += a
  total
}

// COMMAND ----------

val total_after_first_call = addToTotal(5)

// COMMAND ----------

val total_after_second_call = addToTotal(5)

// COMMAND ----------

// MAGIC %md
// MAGIC ## Immutability

// COMMAND ----------

val list = List(1,2,3)

// COMMAND ----------

list = List(0, 1, 2, 3)

// COMMAND ----------

val list2 = -1 :: list

// COMMAND ----------

val newList = 0 :: list

// COMMAND ----------

// MAGIC %md
// MAGIC ## Higher Order Functions

// COMMAND ----------

val greet = (name: String) => s"Hello, $name!"

// COMMAND ----------

println(greet("Alex"))

// COMMAND ----------

def applyTwice(f: Int => Int, x: Int): Int = f(f(x))

// COMMAND ----------

val increment = (x: Int) => x + 1

// COMMAND ----------

println(applyTwice(increment, 5))

// COMMAND ----------

// MAGIC %md
// MAGIC Returning Functions from functions

// COMMAND ----------

def multiplier(factor: Int): Int => Int = {
  (x: Int) => x * factor
}

// COMMAND ----------

val triple = multiplier(3)
println(triple(20))

// COMMAND ----------

// MAGIC %md
// MAGIC ## Anonymous Functions and Function Literals
// MAGIC

// COMMAND ----------

//(val1: Type1, val2: Type2) => expression

(x: Int, y: Int) => x + y

// COMMAND ----------

val numbers = List(1, 2, 3, 4, 5)

// COMMAND ----------

// MAGIC %md
// MAGIC Underscore Notation

// COMMAND ----------

val double = numbers.map(_ * 2)
println(double)

// COMMAND ----------

val incremented = numbers.map(_ + 1)
println(incremented)

// COMMAND ----------

// MAGIC %md
// MAGIC Currying

// COMMAND ----------

def add(x: Int)(y: Int): Int = x + y

// COMMAND ----------

println(add(5)(10))

// COMMAND ----------

// MAGIC %md
// MAGIC Partial Application

// COMMAND ----------

val addFive = add(5)_

// COMMAND ----------

println(addFive(10))

// COMMAND ----------

def log(level: String)(message: String): Unit = {
  println(s"[$level] $message")
}

// COMMAND ----------

val infoLog = log("INFO")_
val errorLog = log("ERROR")_

// COMMAND ----------

infoLog("This is an info message")
errorLog("This is an error message")

// COMMAND ----------

// MAGIC %md
// MAGIC ## Functional Collections

// COMMAND ----------

val numbers = List(1, 2, 3, 4, 5)

val doubled = numbers.map(_ * 2)
println(doubled)

// COMMAND ----------

val nestedNumbers = List(List(1,2), List(3,4), List(5))

val incremented = nestedNumbers.flatMap(list => list.map(_ + 1))
println(incremented)

// COMMAND ----------

val doubledEvens = numbers.collect{ case x if x % 2 == 0 => x * 2}
println(doubledEvens)

// COMMAND ----------

val evens = numbers.filter(_ % 2 == 0)
println(evens)

// COMMAND ----------

val odds = numbers.filterNot(_ % 2 == 0)
println(odds)

// COMMAND ----------

val lessThanFour = numbers.takeWhile(_ < 4)
println(lessThanFour)

// COMMAND ----------

val fromFourOnwards = numbers.dropWhile( _ < 4)
println(fromFourOnwards)

// COMMAND ----------

val sum = numbers.reduce(_ + _)
println(sum)

// COMMAND ----------

val words = List("Scala", "is", "fun")
val sentence = words.foldLeft("Programming in")(_ + " " + _)
println(sentence)

// COMMAND ----------

val sentenceRight = words.foldRight("!")(_ + " " + _)
println(sentence)

// COMMAND ----------

val maxNumber = numbers.reduceLeft((x,y) => if (x > y) x else y)
println(maxNumber)

// COMMAND ----------

val minNumber = numbers.reduceRight((x,y) => if (x < y) x else y)
println(minNumber)

// COMMAND ----------

val sumOfSquares = numbers.aggregate(0)(
  (acc, num) => acc + num * num,
  (acc1, acc2) => acc1+ acc2
)
println(sumOfSquares)

// COMMAND ----------

// MAGIC %md
// MAGIC ## Lazy Evaluation

// COMMAND ----------

lazy val expensiveComputation = {
  println("Performing expensive computation...")
  Thread.sleep(1000)
  42
}

// COMMAND ----------

println("Before accessing 'expensiveComputation'")
println(expensiveComputation)
println(expensiveComputation)

