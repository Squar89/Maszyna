package Model

import java.io.{File, IOException}

import Wyjątki.{ZłaFarbaException, ZłyPigmentException}

import scala.collection.JavaConverters._

/**
  * Created by squar on 21/06/2017.
  */
@throws(classOf[IOException])
class Maszyna(){
  private[this] var kolekcja: Kolekcja = null

  /* ten wyjątek powinien być łapany w interfejsie, gdzię będzie można odpowiednio zareagować */
  @throws(classOf[IOException])
  def konfiguruj(): Unit = {
    kolekcja = new Kolekcja(Maszyna.plikKonfiguracyjny)
  }

  def dodajFarbę(): Unit = {
    kolekcja.dodajFarbę()
  }

  def dodajPigment(): Unit = {//TODO wygląda na to, że nie działa zaokrąglanie
    kolekcja.dodajPigment()
  }

  @throws(classOf[ZłaFarbaException])
  def mieszaj(kolorFarby: String): Unit = {
    val aktualnaFarba: Farba = kolekcja.znajdźFarbę(kolorFarby)
    kolekcja.setAktualnaFarba(aktualnaFarba)

    System.out.println("Zaczynam mieszanie. " + aktualnaFarba.toStringSzczegółowy)
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
    System.out.println(wybranyPigment.toStringSzczegółowy)
    System.out.println("Wynik mieszania: " + kolekcja.getAktualnaFarba.toStringSzczegółowy)
  }

  def pobierzListęFarb(): java.util.List[Farba] = {
    kolekcja.getKolekcjaFarb.asJava
  }

  def pobierzListęPigmentów(): java.util.List[Pigment] = {
    kolekcja.getKolekcjaPigmentów.asJava
  }
}

object Maszyna {
  private val plikKonfiguracyjny: File = new File("maszyna.conf")
}
