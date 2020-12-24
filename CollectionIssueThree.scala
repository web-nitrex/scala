package collection

import scala.collection.mutable.ArrayBuffer

/**
 * Считать из файла hdata_stock.csv данные в буфер
 * Преобразовать считанные данные в Tuple5
 * Вывести построчно в консоль считанные полученный результат
 */

object CollectionIssueThree {

  def main(args: Array[String]): Unit = {

    val bufferedSource = io.Source.fromFile("hdata_stock.csv")

    //результирующий кортеж,куда будет записываться сумма столбцов
    var result = Tuple4(0.0, 0.0, 0.0, 0.0)

    //количество считанных строк
    var size=0

    for (line <- bufferedSource.getLines.drop(1)) {

      val cols = line.split(";")
      // do whatever you want with the columns here

      if(cols.length==5)
      {
        result = (result._1+cols(1).toDouble, result._2+cols(2).toDouble, result._3+cols(3).toDouble, result._4+cols(4).toDouble)
        size=size+1
      }

    }

    bufferedSource.close

    if(size>0)
      {
        println("NASDAQ:GOOG =" + result._1/size)
        println("NASDAQ:MSFT =" + result._2/size)
        println("NASDAQ:AMZN =" + result._3/size)
        println("NASDAQ:AMZN =" + result._4/size)
      }

  }
}
