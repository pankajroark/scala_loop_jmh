package org.openjdk.jmh.samples

import org.openjdk.jmh.annotations._

@Fork(1)
@Warmup(iterations = 5)
@Measurement(iterations = 4)
@State(Scope.Benchmark)
class ToBenchmark {

  val lOuter = Array(1, 2, 3, 4, 5, 6)
  val lInner = Array(1, 2, 3, 4, 5, 6, 7)

  @Benchmark
  def forLoop(): Unit = {
    // this method was intentionally left blank.
    var l = List.empty[Int]
    for (x <- lOuter) {
      for (y <- lInner) {
        l = y :: x :: l
      }
    }
  }

  @Benchmark
  def iterator(): Unit = {
    // this method was intentionally left blank.
    (for {
      x <- lOuter.toIterator
      y <- lInner
    } yield {
      y
    }).toList
  }

  @Benchmark
  def whileLoop(): Unit = {
    // this method was intentionally left blank.
    var l = List.empty[Int]
    val oIter = lOuter.iterator
    while (oIter.hasNext) {
      val o = oIter.next

      val iIter = lInner.iterator
      while (iIter.hasNext) {
        val i = iIter.next
        l = i :: o :: l
      }
    }
  }

  @Benchmark
  def whileLoopInt(): Unit = {
    // this method was intentionally left blank.
    var l = List.empty[Int]
    var i = 0
    var j = 0
    while (i < lOuter.size) {
      while (j < lInner.size) {
        l = lInner(j) :: lOuter(i) :: l
        j += 1
      }
      i += 1
    }
  }
}
