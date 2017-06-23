package Model

/**
  * Created by squar on 21/06/2017.
  */
class Pigment(private[this] val nazwa: String,private[Model] val pierwszaFarba: String, private[Model] val drugaFarba: String,
              private[Model] var toksycznośćZmiana: String, private[Model] var jakośćZmiana: String) {
  def getNazwa(): String = {
    return nazwa
  }

  def getToksycznośćZmiana(): String = {
    return toksycznośćZmiana
  }

  def getJakośćZmiana(): String = {
    return jakośćZmiana
  }

  def getPierwszaFarba(): String = {
    return pierwszaFarba
  }

  def getDrugaFarba(): String = {
    return drugaFarba
  }

  override def toString: String = {
    s"Wybrany pigment: $nazwa, zmiana toksyczności: $toksycznośćZmiana, zmiana jakości: $jakośćZmiana"
  }
}
