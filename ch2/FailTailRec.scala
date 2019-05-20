object FailTailRec {

  // Annotation will force the compile to fail
  // because tailrec cannot be optimized due to
  // additional expression after recursion call
  def failFactorial(n: Int): Int = {
    @annotation.tailrec
    def go(n: Int, acc: Int): Int =
      if (n <= 0) acc
      else go(n-1, n*acc) + 1

    go(n, 1)
  }
}
