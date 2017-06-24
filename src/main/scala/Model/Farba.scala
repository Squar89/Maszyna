package Model

/**
  * Created by squar on 21/06/2017.
  */
class Farba(private[this] val kolor: String, private[Model] var toksyczność: Double, private[Model] var jakość: Double) {
  def getKolor(): String = {
    kolor
  }

  def getToksyczność(): Double = {
    toksyczność
  }

  def setToksyczność(nowaWartość: Double): Unit = {
    toksyczność = nowaWartość
  }

  def getJakość(): Double = {
    jakość
  }

  def setJakość(nowaWartość: Double): Unit = {
    jakość = nowaWartość
  }

  override def toString: String = {
    s"$kolor"
  }

  def toStringSzczegółowy: String = {
    s"Wybrany farba: $kolor, toksyczność: $toksyczność, jakość: $jakość"
  }
}