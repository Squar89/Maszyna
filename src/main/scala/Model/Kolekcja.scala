package Model

import java.io.File
import scala.io.Source

/**
  * Created by squar on 21/06/2017.
  */
class Kolekcja(val plikKonfiguracyjny: File) {
  protected[Model] var kolekcjaFarb: List[Farba] = _
  protected[Model] var kolekcjaPigmentów: List[Pigment] = _
  private[this] var aktualnaFarba: Farba = _

  protected[Model] def wczytajKolekcję(): Unit = {
    try {
      var liniePliku: List[String] = Source.fromFile(plikKonfiguracyjny).getLines.toList
      if (liniePliku == Nil) 
    }

    //TODO
  }

  private def wczytajFarby(file: File): Unit = {
    //TODO
  }

  private def wczytajKonfigurację(file: File): Unit = {
    //TODO
  }

  protected[Model] def dodajFarbę(): Unit = {
    //TODO
  }

  protected[Model] def dodajPigment(): Unit = {
    //TODO
  }

  //Bardzo możliwe że nie będzie w ogóle potrzebne
  protected[Model] def getAktualnaFarba(): Farba = {
    return aktualnaFarba
  }
}

object Kolekcja {
  private def losujFarbę(kolekcjaFarb: List[Farba]): Farba = {
    //TODO
    return new Farba("", 0, 0)
  }

  private def losujToksycznośćLubJakość(): Int = {
    //TODO
    return 321312
  }

  private def losujZmianęToksycznościLubJakości(): String = {
    //TODO
    return "TODO"
  }
}
