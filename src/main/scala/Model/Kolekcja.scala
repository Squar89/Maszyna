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

          /* sprawdzam czy dana linia jest poprawna składniowo */
          if (parametry.length != 3
            || !Kolekcja.zbadajPoprawnośćNazwyFarby(parametry(0))
            || !Kolekcja.zbadajPoprawnośćToksyczności(parametry(1))
            || !Kolekcja.zbadajPoprawnośćJakości(parametry(2))) {
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
        case _: IOException =>
          source.close()
          throw new IOException()
        case _: NumberFormatException =>
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
    if (!plikKonfiguracja.isFile) {
      throw new IOException()
    }
    else {
      val source: BufferedSource = Source.fromFile(plikKonfiguracja)

      try {
        for (linia: String <- source.getLines()) {
          val parametry: Array[String] = linia.split(' ')

          /* sprawdzam czy dana linia jest poprawna składniowo */
          if (parametry.length != 5
            || !Kolekcja.zbadajPoprawnośćNazwyPigmentu(parametry(0))
            || !Kolekcja.zbadajPoprawnośćNazwyFarby(parametry(1))
            || !Kolekcja.zbadajPoprawnośćNazwyFarby(parametry(2))
            || !Kolekcja.zbadajPoprawnośćZmiany(parametry(3))
            || !Kolekcja.zbadajPoprawnośćZmiany(parametry(4))) {
            throw new IOException()
          }
          else {
            /* sprawdzam czy istnieje juź pigment o podanej nazwie */
            if (kolekcjaPigmentów.exists(x => x.getNazwa() == parametry(0))) {
              throw new IOException()
            }
            else {
              kolekcjaPigmentów =
                new Pigment(parametry(0), parametry(1), parametry(2), parametry(3), parametry(4)) :: kolekcjaPigmentów
            }
          }
        }
      }
      catch {
        case _: NumberFormatException =>
          source.close()
          throw new IOException()
        case _: IOException =>
          source.close()
          throw new IOException()
      }
      finally {
        source.close()
      }
    }
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

  private def zbadajPoprawnośćNazwyFarby(nazwaFarby: String): Boolean = {
    return nazwaFarby.charAt(0).isLetter && nazwaFarby.forall(x => x.isLetterOrDigit || x == '-')
  }

  private def zbadajPoprawnośćToksyczności(toksyczność: String): Boolean = {
    return toksyczność.toInt >= 0 && toksyczność.toInt <= Kolekcja.limitToksyczności
  }

  private def zbadajPoprawnośćJakości(jakość: String): Boolean = {
    return jakość.toInt >= 0 && jakość.toInt <= Kolekcja.limitJakości
  }

  private def zbadajPoprawnośćNazwyPigmentu(nazwaPigmentu: String): Boolean = {
    return nazwaPigmentu.forall(x => x.isLetterOrDigit)
  }

  private def zbadajPoprawnośćZmiany(zmiana: String): Boolean = {
    return ((zmiana.charAt(0) == 'x' || zmiana.charAt(0) == '+' || zmiana.charAt(0) == '=') && zmiana.drop(1).toDouble > 0)
  }

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
