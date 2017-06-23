package Model

import java.io.{File, IOException}
import Wyjątki.{ZłaFarbaException, ZłyPigmentException}

/**
  * Created by squar on 21/06/2017.
  */
class Maszyna() {
  /* ten wyjątek powinien być łapany w interfejsie, gdzię będzie można odpowiednio zareagować */
  @throws(classOf[IOException])
  private[this] val kolekcja: Kolekcja = new Kolekcja(Maszyna.plikKonfiguracyjny)

  def dodajFarbę(): Unit = {
    kolekcja.dodajFarbę()
  }

  def dodajPigment(): Unit = {
    kolekcja.dodajPigment()
  }

  @throws(classOf[ZłaFarbaException])
  def mieszaj(kolorFarby: String): Unit = {
    val aktualnaFarba: Farba = kolekcja.znajdźFarbę(kolorFarby)
    kolekcja.setAktualnaFarba(aktualnaFarba)

    System.out.println("Zaczynam mieszanie. " + aktualnaFarba.toString)
  }

  def koniecMieszania(): Unit = {
    kolekcja.setAktualnaFarba(null)

    System.out.println("Koniec mieszania.")
  }

  @throws(classOf[ZłyPigmentException])
  @throws(classOf[IllegalArgumentException]) /* jeżeli wcześniej nierozpoczęto mieszania */
  def użyjPigmentu(nazwaPigmentu: String): Unit = {
    val wybranyPigment: Pigment = kolekcja.znajdźPigment(nazwaPigmentu)
    /* dodanie pigmentu wymaga rozpoczęcia mieszania */
    require(kolekcja.getAktualnaFarba != null, "Nierozpoczęto mieszania!")

    kolekcja.aplikujPigment(wybranyPigment)

    /* komunikat wypisywany w przypadku poprawnego dodania pigmentu */
    System.out.println(wybranyPigment.toString)
    System.out.println("Wynik mieszania: " + kolekcja.getAktualnaFarba.toString)
  }

  def pobierzListęFarb(): List[String] = {
    kolekcja.eksportujListęFarb()
  }

  def pobierzListęPigmentów(): List[(String, String)] = {
    kolekcja.eksportujListęPigmentów()
  }
}

private object Maszyna {
  private val plikKonfiguracyjny: File = new File("maszyna.conf")
}
