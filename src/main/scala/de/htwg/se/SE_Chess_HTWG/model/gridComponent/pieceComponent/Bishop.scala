package de.htwg.se.SE_Chess_HTWG.model.gridComponent.pieceComponent

import math.abs

case class Bishop(override val isWhite: Boolean) extends Piece {
  override def toString: String = if (isWhite) { "\u2657" } else { "\u265D"}

  override def isValidMove(fromRow: Int, fromCol: Int, toRow: Int, toCol: Int): Boolean = {
    abs(fromCol - toCol) == abs(fromRow - toRow)
  }
}
