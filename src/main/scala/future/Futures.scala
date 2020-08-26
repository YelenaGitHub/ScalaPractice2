package future

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import Math.pow

import scala.concurrent.duration._
import scala.util.Random

object Futures extends App{

  /*
  есть лист целых рандомных чисел меньших 10
val list = List(2,0, 4, -2)

нужно сделать функцию которая
возведет  2 в степень каждого элемента 2^x параллельно
и посчитает сумму этих чисел
  */

  val list = (1 to 10).map(_ => Random.nextInt() % 10)

  val listFuture: Seq[Future[Double]] = list.map(e => Future { pow(2, e) })
  val futuresList = Future.sequence(listFuture)
  val res = futuresList.map(_.sum)

  val res2 = Future.traverse(list)(e => Future( pow(2, e))).map(_.sum)
  val res3 = seq(listFuture).map(_.sum)
  val res4 = seq2(listFuture).map(_.sum)

  println(Await.result(res, 2000.seconds))
  println(Await.result(res2, 2000.seconds))
  println(Await.result(res3, 2000.seconds))
  println(Await.result(res4, 2000.seconds))

  // sequence, from List[Future[A]] to Future[List[A]]
  def seq[A](list: Seq[Future[A]]): Future[Seq[A]] = {
    list.foldLeft(Future(Seq.empty[A])) { (acc, x) =>
      acc.flatMap(elem => x.map(addElem => elem :+ addElem))
    }
  }

  def seq2[A](list: Seq[Future[A]]): Future[Seq[A]] = {
    list.foldLeft(Future(Seq.empty[A])) { (acc, x) =>
      for {
        elem <- acc
        addElem <- x
      } yield elem :+ addElem
    }
  }

}
