package underscores

// // From https://github.com/non/kind-projector/issues/20
// import scala.language.higherKinds

object KindProjectorWarnings {
//  existential tree (Foo[(Bar[Int, _$1] forSome {
//    type _$1
//  }), _$2] forSome {
//    type _$2
//  })<=>List(<synthetic> type _$2) =>> (_root_.scala.AnyRef {
//    type Λ$[β$0$ >: _root_.scala.Nothing <: _root_.scala.Any] = Foo[(_root_.scala.AnyRef {
//      type Λ$[β$1$ >: _root_.scala.Nothing <: _root_.scala.Any] = Bar[Int, β$1$]
//    })#Λ$, β$0$]
//  })#Λ$ [12:5]

//  existential tree (Foo[(Bar[Int, _$1] forSome {
  //  type _$1
  //}), _$2] forSome {
  //  type _$2
  //})<=>List(<synthetic> type _$2) =>> (_root_.scala.AnyRef {
  //  type Λ$[β$1$ >: _root_.scala.Nothing <: _root_.scala.Any] = Foo[((_root_.scala.AnyRef {
  //    type Λ$[β$0$ >: _root_.scala.Nothing <: _root_.scala.Any] = Bar[Int, β$0$]
  //  })#Λ$ forSome {
  //    type _$1
  //  }), β$1$]
  //})#Λ$ [12:5]

  trait Foo[F[_], A]
  trait Bar[A, B]

  def f[G[_]]: Unit = ()

  f[Foo[Bar[Int, _], _]] // shadowing warning
}
