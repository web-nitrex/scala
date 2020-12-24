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

    val list_prices = {
      val readData = new ArrayBuffer[(String, Double, Double, Double, Double)]()

      for (line <- bufferedSource.getLines.drop(1)) {

        val cols = line.split(";")
        // do whatever you want with the columns here

         if(cols.length==5) readData += ((cols(0), cols(1).toDouble, cols(2).toDouble, cols(3).toDouble, cols(4).toDouble))
      }

      readData
    }

    bufferedSource.close

    if(list_prices.size>0)
      {
        println("NASDAQ:GOOG =" + list_prices.map(t=>t._2).sum/list_prices.size)
        println("NASDAQ:MSFT =" + list_prices.map(t=>t._3).sum/list_prices.size)
        println("NASDAQ:AMZN =" + list_prices.map(t=>t._4).sum/list_prices.size)
        println("NASDAQ:FB =" + list_prices.map(t=>t._5).sum/list_prices.size)
      }


  }





}
