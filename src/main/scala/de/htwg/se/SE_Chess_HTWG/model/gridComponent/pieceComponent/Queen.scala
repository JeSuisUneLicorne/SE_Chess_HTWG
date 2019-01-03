package de.htwg.se.SE_Chess_HTWG.model.gridComponent.pieceComponent

import scala.math.abs

case class Queen(override val isWhite: Boolean) extends Piece {
  override def toString: String = if (isWhite) { "\u2655" } else { "\u265B"}

  override def isValidMove(fromRow: Int, fromCol: Int, toRow: Int, toCol: Int): Boolean = {
    (fromRow == toRow || fromCol == toCol) || abs(fromCol - toCol) == abs(fromRow - toRow)
  }
}
