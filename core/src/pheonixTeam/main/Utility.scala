package pheonixTeam.main

object Utility {
  def foreach(theList: List[Any], theFunction: (Any) => Unit): Unit =
  {
    for (i <- 0 until theList.length){
      theFunction(theList(i))
    }
  }
}