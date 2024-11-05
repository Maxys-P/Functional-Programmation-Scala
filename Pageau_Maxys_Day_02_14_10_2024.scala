// Databricks notebook source
// MAGIC %md
// MAGIC ## Composable
// MAGIC
// MAGIC f(g(x))

// COMMAND ----------

def f(x: Int): Int = x * 2
def g(x: Int): Int = x + 2
def h(x: Int): Int = f(g(x))


// COMMAND ----------


val input = 4
println(s"f($input) = ${f(input)}")
println(s"f(g($input)) = ${g(input)}")
println(s"g($input) = ${h(input)}")

// COMMAND ----------

// MAGIC %md
// MAGIC ##Scala Programming language
// MAGIC
// MAGIC You need to have the same type ! This is not Python

// COMMAND ----------

val name: String = "Scala"
val age: Int = 25

// COMMAND ----------

val x : Int = 10 +"10"

// COMMAND ----------

// MAGIC %md
// MAGIC ##Operator

// COMMAND ----------

val x = 2
val y = 3
val z = x + y

// COMMAND ----------

// MAGIC %md
// MAGIC '+' is not built in Scala. It's a method for Int class

// COMMAND ----------

val z = x.+(y)

// COMMAND ----------

// MAGIC %md
// MAGIC ##Traits
// MAGIC + Traits define an interface shared by related classes.
// MAGIC + They help create modular, reusable, and extensible code.
// MAGIC + Traits include a set of methods.
// MAGIC + In Java, interfaces only have method signatures.
// MAGIC + Classes inheriting a trait must implement its methods.

// COMMAND ----------

trait Shape {
  def area(): Int //méthode abstraite, sans implémentation
}

class Square(length: Int) extends Shape {
  def area = length * length //implémentation concrète de la méthode abstraite
}

class Rectangle(length: Int, width: Int) extends Shape {
  def area = length * width
}

val square = new Square(10)
val area = square.area

// COMMAND ----------

// MAGIC %md
// MAGIC ##Tuples
// MAGIC - A tuples is a container for storing elements of differents types
// MAGIC - It's immutable
// MAGIC - One based index

// COMMAND ----------

val threeElements = ("10", 10, true)

// COMMAND ----------

val first = threeElements._1
val second = threeElements._2

// COMMAND ----------

// MAGIC %md
// MAGIC ## Collections
// MAGIC If the elements have the same type, we use collections
// MAGIC
// MAGIC Zero-based inex
// MAGIC
// MAGIC Sequence,
// MAGIC Array,
// MAGIC List,
// MAGIC Vector,
// MAGIC Sets,
// MAGIC Maps

// COMMAND ----------

// MAGIC %md
// MAGIC ###Array
// MAGIC Mutable

// COMMAND ----------

val arr = Array(1, 2, 3, 4)
arr(0) = 50
val first = arr(0)

// COMMAND ----------

// MAGIC %md
// MAGIC ###List
// MAGIC Immutable
// MAGIC
// MAGIC One of the most commonly used

// COMMAND ----------

val list = List(1, 2, 3, 4)
val list2 = (1 to 10).toList
val list3 = arr.toList

// COMMAND ----------

// MAGIC %md
// MAGIC It supports isEmpty

// COMMAND ----------

// MAGIC %md
// MAGIC ### Vector
// MAGIC
// MAGIC Hybrid between List and Array
// MAGIC
// MAGIC Allows fast random access and fast functional updates

// COMMAND ----------

val v1 = Vector(1, 2, 3, 4, 5)
val v2 = v1 :+ 6
val v3 = v2 :+ 7

// COMMAND ----------

// MAGIC %md
// MAGIC ### Sets
// MAGIC Unordered collection of distinct elements
// MAGIC
// MAGIC No duplicate
// MAGIC
// MAGIC Can't access element by their index
// MAGIC
// MAGIC Support contains and isEmpty

// COMMAND ----------

val fruits = Set("apple", "orange", "banana", "ananas")
fruits.contains("fraise")

// COMMAND ----------

fruits.contains("banana")

// COMMAND ----------

fruits.isEmpty

// COMMAND ----------

// MAGIC %md
// MAGIC ### Map
// MAGIC Collection of pairs key-value
// MAGIC
// MAGIC Same as dictionnary or hash map
// MAGIC

// COMMAND ----------

val capitals = Map("France"->"Paris", "Allemagne"->"Berlin", "Royaume-Uni"->"Londre")
val franceCapital = capitals("France")

// COMMAND ----------

// MAGIC %md
// MAGIC ### Higher-Order Methods on Collection Classes
// MAGIC Real power of Scala : collections comes from their higher-order methods
// MAGIC - A higher-order method takes a function as its input parameter
// MAGIC - It is important to note that higher-order method doesn't mutate a collection
// MAGIC - These includes:
// MAGIC   - map
// MAGIC   - flatmap
// MAGIC   - filter
// MAGIC   - foreach
// MAGIC   - reduce
// MAGIC
// MAGIC #### I. Map
// MAGIC The map method of scala collection applies its input function to all the elements in the collection and return another collection

// COMMAND ----------

val myList = List(1.0, 2.0, 3.0, 4.0)
val multipliedList = myList.map((x:Double) => x * 2)
val beauty = myList.map(_*2)

// COMMAND ----------

// MAGIC %md
// MAGIC if the type or the multiplier (2 here) is Double then the results will be double

// COMMAND ----------

// MAGIC %md
// MAGIC #### II. FlatMap
// MAGIC Method similar to map, but with a difference: the function you provide to flat map must return a collection for each element in the original collection.  
// MAGIC When applied, it returns a flattened collection, it combines all the collections into one.  
// MAGIC Map would return a collection of collection.

// COMMAND ----------

val line = "Scala isn't fun"

// COMMAND ----------

val SingleSpace = " "

// COMMAND ----------

val words = line.split(SingleSpace)

// COMMAND ----------

val arrayOfListOfChars = words.map{x => x.toList}

// COMMAND ----------

val arrayOfChars = words.flatMap{x => x.toList}

// COMMAND ----------

// MAGIC %md
// MAGIC #### III. Filter
// MAGIC Used to filter a collection based on predicate (true or false).

// COMMAND ----------

val numbers = (1 to 10).toList
val pair = numbers.filter(_%2 == 0)

// COMMAND ----------

// MAGIC %md
// MAGIC #### IV. Foreach
// MAGIC Used to apply a function on every element, doesn't return anything

// COMMAND ----------

val line2 = List("Scala", "is", "soooo", "fun")
line2.foreach(println)

// COMMAND ----------

// MAGIC %md
// MAGIC #### V. Reduce
// MAGIC Returns a single value
// MAGIC
// MAGIC Used to reduce a collection (such as a list) to a single value by applying a binary operation repeatedly to pairs of elements in the collection until only one remains

// COMMAND ----------

val reduceList = List(2,4,6,8,10)

// COMMAND ----------

val sum = reduceList.reduce{(x,y) => x+y}

// COMMAND ----------

val min = reduceList.reduce{(x,y) => if (x<y) x else y}
