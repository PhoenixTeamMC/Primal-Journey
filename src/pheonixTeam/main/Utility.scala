package pheonixTeam.main

import scala.actors.A

object Utility {
  def foreach(theList: List[A], theFunction: (A) => Unit): Unit =
  {
    for (i <- 0 until theList.length){
      theFunction(theList(i))
    }
  }
}
