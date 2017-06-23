package Wyjątki

/**
  * Created by squar on 23/06/2017.
  */
case class ZłyPigmentException(private val komunikat: String = "") extends Exception(komunikat) {

}
