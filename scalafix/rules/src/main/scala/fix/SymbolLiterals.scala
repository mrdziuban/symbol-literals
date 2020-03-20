package fix

import scalafix.v1._
import scala.meta._

class SymbolLiterals extends SyntacticRule("SymbolLiterals") {
  override def fix(implicit doc: SyntacticDocument): Patch =
    doc.tree.collect {
      case tree @ Lit.Symbol(sym) => Patch.replaceTree(tree, s"""Symbol("${sym.name}")""")
    }.asPatch
}
