package Model

import java.io.File
import java.io.IOException
import scala.io.{BufferedSource, Source}

/**
  * Created by squar on 21/06/2017.
  */
class Kolekcja(val plikKonfiguracyjny: File) {
  private[Model] var kolekcjaFarb: List[Farba] = _
  private[Model] var kolekcjaPigmentów: List[Pigment] = _
  private[this] var aktualnaFarba: Farba = _

  @throws(classOf[IOException])
  private[Model] def wczytajKolekcję(): Unit = {
    /* rzucam wyjątki i łapię je w modelu */
    if (!plikKonfiguracyjny.isFile) {
      throw new IOException()
    }
    else {
      val source: BufferedSource = Source.fromFile(plikKonfiguracyjny)

      try {
        val liniePliku: List[String] = source.getLines.toList
        liniePliku match {
          case List(linia1: String, linia2: String) => {
            wczytajFarby(new File(linia1))
            wczytajKonfigurację(new File(linia2))
          }
          case _ => throw new IOException()
        }
      }
      catch {
        case e: IOException => {
          source.close()
          throw new IOException()
        }
      }
      finally {
        source.close()
      }
    }
  }

  @throws(classOf[IOException])
  private def wczytajFarby(file: File): Unit = {
    //TODO
  }

  @throws(classOf[IOException])
  private def wczytajKonfigurację(file: File): Unit = {
    //TODO
  }

  private[Model] def dodajFarbę(): Unit = {
    //TODO
  }

  private[Model] def dodajPigment(): Unit = {
    //TODO
  }

  //Bardzo możliwe że nie będzie w ogóle potrzebne
  private[Model] def getAktualnaFarba(): Farba = {
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
