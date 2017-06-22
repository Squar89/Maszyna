package Model

import java.io.File
import java.io.IOException
import scala.io.{BufferedSource, Source}

/**
  * Created by squar on 21/06/2017.
  */
class Kolekcja(val plikKonfiguracyjny: File) {
  private[Model] var kolekcjaFarb: List[Farba] = Nil
  private[Model] var kolekcjaPigmentów: List[Pigment] = Nil
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
          case List(linia1: String, linia2: String) =>
            wczytajFarby(new File(linia1))
            wczytajKonfigurację(new File(linia2))
          case _ => throw new IOException()
        }
      }
      catch {
        case _: IOException =>
          source.close()
          throw new IOException()
      }
      finally {
        source.close()
      }
    }
  }

  @throws(classOf[IOException])
  private def wczytajFarby(plikFarby: File): Unit = {
    if (!plikFarby.isFile) {
      throw new IOException()
    }
    else {
      val source: BufferedSource = Source.fromFile(plikFarby)

      try {
        for (linia: String <- source.getLines()) {
          val parametry: Array[String] = linia.split(' ')

          /* sprawdzam czy podane dane są poprawne składniowo */
          if (parametry.length != 3 || !parametry(0).charAt(0).isLetter
            || !(parametry(1).toInt >= 0 && parametry(1).toInt <= Kolekcja.limitToksyczności)
            || !(parametry(2).toInt >= 0 && parametry(2).toInt <= Kolekcja.limitJakości)) {
            throw new IOException()
          }
          else {
            /* sprawdzam czy istnieje już farba o podanym kolorze */
            if (kolekcjaFarb.exists(x => x.getKolor() == parametry(0))) {
              throw new IOException()
            }
            else {
              kolekcjaFarb = new Farba(parametry(0), parametry(1).toDouble, parametry(2).toDouble) :: kolekcjaFarb
            }
          }
        }
      }
      catch {
        case _: IOException | NumberFormatException =>
          source.close()
          throw new IOException()
      }
      finally {
        source.close()
      }
    }
  }

  @throws(classOf[IOException])
  private def wczytajKonfigurację(plikKonfiguracja: File): Unit = {
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
  private val limitToksyczności: Int = 100
  private val limitJakości: Int = 100

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
