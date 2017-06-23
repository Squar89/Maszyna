package Model

import java.io.File
import java.io.IOException

import Wyjątki.ZłyPigmentException

import scala.io.{BufferedSource, Source}
import scala.util.Random

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

  @throws(classOf[IOException])
  private def wczytajFarby(plikFarby: File): Unit = {
    if (!plikFarby.isFile) {
      throw new IOException()
    }
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

        /* sprawdzam czy istnieje już farba o podanym kolorze */
        if (kolekcjaFarb.exists(x => x.getKolor() == parametry(0))) {
          throw new IOException()
        }

        kolekcjaFarb = new Farba(parametry(0), parametry(1).toDouble, parametry(2).toDouble) :: kolekcjaFarb
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

  @throws(classOf[IOException])
  private def wczytajKonfigurację(plikKonfiguracja: File): Unit = {
    if (!plikKonfiguracja.isFile) {
      throw new IOException()
    }
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

        /* sprawdzam czy istnieje juź pigment o podanej nazwie */
        if (kolekcjaPigmentów.exists(x => x.getNazwa() == parametry(0))) {
          throw new IOException()
        }
        kolekcjaPigmentów =
          new Pigment(parametry(0), parametry(1), parametry(2), parametry(3), parametry(4)) :: kolekcjaPigmentów
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

  private[Model] def losujFarbę(): Farba = {
    /* Zwraca losowo wybraną farbę z kolekcji farb */
    kolekcjaFarb.apply(Random.nextInt(kolekcjaFarb.length - 1))
  }

  private def losujNazwęFarby(): String = {
    val alfabet: String = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-"
    def losowyZnakZAlfabetu: Char = {
      alfabet.charAt(Random.nextInt(alfabet.length - 1))
    }
    var nazwa: String = ""

    nazwa += losowyZnakZAlfabetu
    while (!nazwa.charAt(0).isLetter) {
      nazwa = "" + losowyZnakZAlfabetu
    }
    while (kolekcjaFarb.exists(x => x.getKolor() == nazwa)) {
      nazwa += losowyZnakZAlfabetu
    }

    nazwa
  }

  private def losujNazwęPigmentu(): String = {
    val alfabet: String = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
    def losowyZnakZAlfabetu: Char = {
      alfabet.charAt(Random.nextInt(alfabet.length -1))
    }
    var nazwa: String = ""

    nazwa += losowyZnakZAlfabetu
    while (kolekcjaPigmentów.exists(x => x.getNazwa() == nazwa)) {
      nazwa += losowyZnakZAlfabetu
    }

    nazwa
  }
  private[Model] def dodajFarbę(): Unit = {
    kolekcjaFarb = new Farba(losujNazwęFarby(), Kolekcja.losujToksyczność(), Kolekcja.losujJakość()) :: kolekcjaFarb
  }

  private[Model] def dodajPigment(): Unit = {
    if (kolekcjaFarb != Nil) {
      kolekcjaPigmentów = new Pigment(losujNazwęPigmentu(), losujFarbę().getKolor(), losujFarbę().getKolor(),
        Kolekcja.losujZmianę(), Kolekcja.losujZmianę()) :: kolekcjaPigmentów
    }
    else {
      kolekcjaPigmentów = new Pigment(losujNazwęPigmentu(), losujNazwęFarby(), losujNazwęFarby(),
        Kolekcja.losujZmianę(), Kolekcja.losujZmianę()) :: kolekcjaPigmentów
    }
  }

  private[Model] def aplikujPigment(pigment: Pigment): Farba = {
    /* aplikuje pigment do aktualnej farby */
    if (aktualnaFarba.getKolor() != pigment.getPierwszaFarba()) {
      throw ZłyPigmentException("Danego pigmentu nie można mieszać z aktualną farbą!")
    }
    //TODO

    new Farba("", 0, 0)//TODO
  }

  //Bardzo możliwe że nie będzie w ogóle potrzebne
  private[Model] def getAktualnaFarba: Farba = {
    aktualnaFarba
  }
}

object Kolekcja {
  private val limitToksyczności: Int = 100
  private val limitJakości: Int = 100

  private def zbadajPoprawnośćNazwyFarby(nazwaFarby: String): Boolean = {
    nazwaFarby.charAt(0).isLetter && nazwaFarby.forall(x => x.isLetterOrDigit || x == '-')
  }

  private def zbadajPoprawnośćToksyczności(toksyczność: String): Boolean = {
    toksyczność.toInt >= 0 && toksyczność.toInt <= Kolekcja.limitToksyczności
  }

  private def zbadajPoprawnośćJakości(jakość: String): Boolean = {
    jakość.toInt >= 0 && jakość.toInt <= Kolekcja.limitJakości
  }

  private def zbadajPoprawnośćNazwyPigmentu(nazwaPigmentu: String): Boolean = {
    nazwaPigmentu.forall(x => x.isLetterOrDigit)
  }

  private def zbadajPoprawnośćZmiany(zmiana: String): Boolean = {
    (zmiana.charAt(0) == 'x' || zmiana.charAt(0) == '+' || zmiana.charAt(0) == '=') && zmiana.drop(1).toDouble > 0
  }

  private def losujToksyczność(): Int = {
    Random.nextInt(limitToksyczności)
  }

  private def losujJakość(): Int = {
    Random.nextInt(limitJakości)
  }

  private def losujZmianę(): String = {
    val alfabet: String = "*+-"
    def losowyZnakZAlfabetu: Char = {
      alfabet.charAt(Random.nextInt(alfabet.length - 1))
    }
    def losowaZmiana: String = {
      /* losuje liczbę rzeczywistą z przedziału (0 - 100) z zaokrągleniem do części setnych */
      "" + ((Random.nextDouble() * Random.nextInt(limitToksyczności)) % 0.01)
    }

    "" + losowyZnakZAlfabetu + losowaZmiana
  }
}
