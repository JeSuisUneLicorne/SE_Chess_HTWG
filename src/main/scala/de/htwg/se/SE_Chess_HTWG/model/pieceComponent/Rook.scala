package de.htwg.se.SE_Chess_HTWG.model.pieceComponent

import de.htwg.se.SE_Chess_HTWG.model.gridComponent.{Cell, GridInterface}
import de.htwg.se.SE_Chess_HTWG.model.movement.{Move, MovementHelper}
import de.htwg.se.SE_Chess_HTWG.util.MovementResult
import de.htwg.se.SE_Chess_HTWG.util.MovementResult.MovementResult

private[pieceComponent] class Rook(val isWhite: Boolean, var row: Int, var col: Int, var hasMoved: Boolean = false) extends PieceInterface {
  override def toString: String = if (isWhite) "\u2656" else "\u265C"
  override def toSimpleString: String = "R"
  val imageName = if (isWhite) "rook_w" else "rook_b"

  def executeMove(grid: GridInterface, move: Move): MovementResult = {
    if (getPossibleSquares(grid) contains move.getToCell) move.doMove() else MovementResult.ERROR
  }

  def getPossibleSquares(grid: GridInterface): List[Cell] = {
    val rowsToEighthRow = ((row + 1) until 8).toList
    val colsToEightCol = ((col + 1) until 8).toList
    val rowsToFirstRow = (0 until row).reverse.toList
    val colsToFirstRow = (0 until col).reverse.toList

    MovementHelper.getSquaresUntilColliding(grid, (rowsToEighthRow zip List.fill(8)(col)), isWhite):::
      MovementHelper.getSquaresUntilColliding(grid, (List.fill(8)(row) zip colsToFirstRow), isWhite):::
      MovementHelper.getSquaresUntilColliding(grid, (rowsToFirstRow zip List.fill(8)(col)), isWhite):::
      MovementHelper.getSquaresUntilColliding(grid, (List.fill(8)(row) zip colsToEightCol), isWhite)
  }
}
