package Model

import java.io.{File, IOException}
import Wyjątki.ZłyPigmentException
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

  def dodajPigment(): Unit = {
    kolekcja.dodajPigment()
  }

  def mieszaj(farba: Farba): Unit = {
    kolekcja.setAktualnaFarba(farba)

    System.out.println("Zaczynam mieszanie. " + farba.toStringSzczegółowy)
  }

  def koniecMieszania(): Unit = {
    kolekcja.setAktualnaFarba(null)

    System.out.println("Koniec mieszania.")
  }

  @throws(classOf[ZłyPigmentException])
  @throws(classOf[IllegalArgumentException]) /* jeżeli wcześniej nierozpoczęto mieszania */
  def użyjPigmentu(pigment: Pigment): Unit = {//TODO bug z obliczaniem toksyczności i jakości, możliwe że wchodzi na minus
                                              //TODO NVM, jest całkowicie popsute :V
    /* dodanie pigmentu wymaga rozpoczęcia mieszania */
    require(kolekcja.getAktualnaFarba != null, "Nierozpoczęto mieszania!")

    kolekcja.aplikujPigment(pigment)//TODO teraz nawet wywala jakies exception?

    /* komunikat wypisywany w przypadku poprawnego dodania pigmentu */
    System.out.println(pigment.toStringSzczegółowy)
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
