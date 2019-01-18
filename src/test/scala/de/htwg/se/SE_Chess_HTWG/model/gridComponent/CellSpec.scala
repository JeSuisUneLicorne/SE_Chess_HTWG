package de.htwg.se.SE_Chess_HTWG.model.gridComponent

import de.htwg.se.SE_Chess_HTWG.model.pieceComponent.Rook
import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CellSpec extends WordSpec with Matchers {
  "A Cell" when { "new with white and no piece" should {
    val cell = Cell(None, true, false)
    "not be set" in {
      cell.isSet should be(false)
    }
    "be white in"  in {
      cell.isWhite should be(true)
    }
    "have the right string representation of the square" in {
      cell.toString should be("\u25af")
    }
  }}

  "A Cell" when { "new with black and no piece" should {
    val cell = Cell(None, false, false)
    "not be set" in {
      cell.isSet should be(false)
    }
    "be white in"  in {
      cell.isWhite should be(false)
    }
    "have the right string representation of the square" in {
      cell.toString should be("\u25ae")
    }
  }}

  "A Cell" when { "new with black and a rook" should {
    val cell = Cell(Some(Rook(true, 1, 1, false)), false, false)
    "be set" in {
      cell.isSet should be(true)
    }
    "be black in"  in {
      cell.isWhite should be(false)
    }
    "have the right string representation of the piece" in {
      cell.toString should be("\u2656")
    }
  }}
}
