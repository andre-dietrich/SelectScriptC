// Generated from SelectScript.g4 by ANTLR 4.5.3
package S2;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SelectScriptParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SelectScriptVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(SelectScriptParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(SelectScriptParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(SelectScriptParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#dict}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDict(SelectScriptParser.DictContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#dict_elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDict_elem(SelectScriptParser.Dict_elemContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(SelectScriptParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(SelectScriptParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#repo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepo(SelectScriptParser.RepoContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet(SelectScriptParser.SetContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(SelectScriptParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#stmt_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt_list(SelectScriptParser.Stmt_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(SelectScriptParser.ValueContext ctx);
}