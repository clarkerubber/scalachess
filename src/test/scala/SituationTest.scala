package chess

class SituationTest extends ChessTest {

  "a game" should {
    "detect check" should {
      "by rook" in {
        ("""
K  r
""" as White).check must beTrue
      }
      "by knight" in {
        ("""
  n
K
""" as White).check must beTrue
      }
      "by bishop" in {
        ("""
  b

   
     K
""" as White).check must beTrue
      }
      "by pawn" in {
        ("""
    p
     K
""" as White).check must beTrue
      }
      "not" in {
        ("""
   n
K
""" as White).check must beFalse
      }
    }
    "detect check mate" in {
      "by rook" in {
        ("""
PP
K  r
""" as White).checkMate must beTrue
      }
      "by knight" in {
        ("""
PPn
KR
""" as White).checkMate must beTrue
      }
      "not" in {
        ("""
  n
K
""" as White).checkMate must beFalse
      }
    }
    "stale mate" in {
      "stuck in a corner" in {
        ("""
prr
K
""" as White).staleMate must beTrue
      }
      "not" in {
        ("""
  b
K
""" as White).staleMate must beFalse
      }
    }
  }
}
