package se.minesweeper.model

import scala.io.StdIn._

//case class Field()
/*
object Field {
    def main(args:Array[String]) = {
        println("Welcome to Minesweeper \n")
        val salutation = "Hi " + signUp(args)
        println(salutation)
        showGrid()
    }
    // enters player name
    def signUp(playerNames:Array[String]):Person = {
        val name = if (playerNames.length > 0)
            playerNames.head
        else
            readLine("Dude enter your name: ")
        val age = 33
        Person(name,age)
    }

    // test branch features creation
    // input number and shows grid
    def showGrid()= {
        println("Enter size of grid: ")
        val size = scala.io.StdIn.readInt()
        
        println(mesh(size,size))
        
    }
    //grid construction
    val eol = sys.props("line.separator")
    
    def cells(cellWidth: Int=5, cellNum: Int=5): String = ("|" + " " * 3) * cellNum + "|" + eol
    def mesh(cellWidth: Int=5, cellNum: Int=5): String =(bar(cellWidth, cellNum) + cells(cellWidth, cellNum)) * cellNum + bar(cellWidth, cellNum)


}

case class Person(name: String, age: Int) {
    override def toString = name + "("+age+")"
}
*/
case class Field(matrix: Matrix[Marker]):
  def this(size: Int, filling: Marker) = this(new Matrix(size, filling))
  val size = matrix.size
  val eol = sys.props("line.separator")
  def bar(cellWidth: Int = 3, cellNum: Int = 3): String = (("+" + "-" * 3) * cellNum) + "+" + eol
  def cells(row: Int, cellWidth: Int = 3) =
    matrix.row(row).map(_.toString).map(" " * ((cellWidth - 1) / 2) + _ + " " * ((cellWidth - 1) / 2)).mkString("|", "|", "|") + eol
  def mesh(cellWidth: Int = 3) =
    (0 until size).map(cells(_, cellWidth)).mkString(bar(cellWidth, size), bar(cellWidth, size), bar(cellWidth, size))
  override def toString = mesh()
  def put(marker: Marker, x: Int, y: Int) = copy(matrix.replaceCell(x, y, marker))