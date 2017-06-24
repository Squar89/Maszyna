package Model

/**
  * Created by squar on 21/06/2017.
  */
class Pigment(private[this] val nazwa: String, private[Model] val pierwszaFarba: String, private[Model] val drugaFarba: String,
              private[Model] var toksycznośćZmiana: String, private[Model] var jakośćZmiana: String) {
  def getNazwa(): String = {
    nazwa
  }

  def getToksycznośćZmiana(): String = {
    toksycznośćZmiana
  }

  def setToksycznośćZmiana(nowaWartość: String): Unit = {
    toksycznośćZmiana = nowaWartość
  }

  def getJakośćZmiana(): String = {
    jakośćZmiana
  }

  def setJakośćZmiana(nowaWartość: String): Unit = {
    jakośćZmiana = nowaWartość
  }

  def getPierwszaFarba(): String = {
    pierwszaFarba
  }

  def getDrugaFarba(): String = {
    drugaFarba
  }

  override def toString: String = {
    s"$nazwa ($pierwszaFarba -> $drugaFarba)"
  }

  def toStringSzczegółowy: String = {
    s"Zastosowany pigment: $nazwa, zmiana toksyczności: $toksycznośćZmiana, zmiana jakości: $jakośćZmiana"
  }
}
