// Databricks notebook source
println("Hello world!")

// COMMAND ----------

var x = 10
val y = 10

// COMMAND ----------

x = 20

// COMMAND ----------

y = 20

// COMMAND ----------

def add(firstInput: Int, secondInput: Int): Int = {
  val sum = firstInput + secondInput
  return sum
}

// COMMAND ----------

val addNumbers = add(6 ,7)

// COMMAND ----------

def addSimple(firstInput: Int, secondInput: Int) = firstInput + secondInput

// COMMAND ----------

val addNumbersSimple = addSimple(6, 7)

// COMMAND ----------

def encode(n: Int, f: (Int) => Long): Long = {
  val x = n * 10
  f(x)
}

// COMMAND ----------

val functionTest = encode(10, (x:Int) => (x+100))

// COMMAND ----------

val functionTest2 = encode(10, x => x + 100)

// COMMAND ----------

// MAGIC %md
// MAGIC _ can replace a literal function

// COMMAND ----------

val functionTest3 = encode(10, _ + 100)

// COMMAND ----------

class Car(mk: String, ml: String, cr: String){
  val make = mk
  val model = ml
  var color = cr
  def repaint(newColor: String) = {
    color = newColor
  }
}

// COMMAND ----------

val mustang = new Car("Ford", "Mustang", "Red")
val corvette = new Car("GM", "Corvette", "Black")

// COMMAND ----------

corvette.repaint("Blue")

// COMMAND ----------

case class Message(from: String, to: String, content:String)

// COMMAND ----------

val request = Message("harry", "ron", "Hello Harry!")

// COMMAND ----------

def colorToNumber(color: String): Int = {
  val num = color match{
    case "Red" => 1
    case "Blue" => 2
    case "Green" => 3
    case "Yellow" => 4
    case _ => 0
  }
  num
}

// COMMAND ----------

val colorName = "Red"
val colorCode = colorToNumber(colorName)
println(s"The color code for $colorName is $colorCode")

// COMMAND ----------

def f(x: Int, y: Int, operator: String): Double = {
  operator match {
    case "+" => x + y
    case "-" => x - y
    case "*" => x * y
    case "/" => x / y.toDouble
  }
}

// COMMAND ----------

val sum = f(10, 20, "+")
val product = f(10, 20, "*")
