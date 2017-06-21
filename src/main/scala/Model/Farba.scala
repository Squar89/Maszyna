package Model

/**
  * Created by squar on 21/06/2017.
  */
class Farba(private[this] val kolor: String, protected[Model] var toksyczność: Double, protected[Model] var jakość: Double) {
  def getKolor(): String = {
    return kolor
  }

  def getToksyczność(): Double = {
    return toksyczność
  }

  def getJakość(): Double = {
    return jakość
  }

}
