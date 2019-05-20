object MyCurry {
  def curry[A, B, C](f: (A, B) => C): A => B => C = {
    (a: A) => (b: B) => f(a, b)
  }

  def uncurry[A, B, C](f: A => B => C): (A, B) => C = {
    (a: A, b: B) => f(a)(b)    
  }

  def compose[A, B, C](f: B => C, g: A => B): A => C = {
    (a: A) => f(g(a))
  }

  def main(args: Array[String]): Unit = {
    val x = (a: Int, b: String) => {
      if (a > 0 && b == "test") {
        true
      } else {
        false
      }
    }

   val partialX = curry(x)
   val y = partialX(1)

   println(y("test"))
   println(y("asdf"))
 
   val z = partialX(-1)
   println(z("test"))
   println(z("asdf"))
  }
}
