package Model

/**
  * Created by squar on 21/06/2017.
  */
class Pigment(private[this] val nazwa: String,
              protected[Model] var toksycznośćZmiana: String, protected[Model] var jakośćZmiana: String,
              protected[Model] val pierwszaFarba: String, protected[Model] val drugaFarba: String) {
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


}
