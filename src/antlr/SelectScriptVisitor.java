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
	 * Visit a parse tree produced by {@link SelectScriptParser#dict_id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDict_id(SelectScriptParser.Dict_idContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(SelectScriptParser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#exit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExit(SelectScriptParser.ExitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ex_else}
	 * labeled alternative in {@link SelectScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEx_else(SelectScriptParser.Ex_elseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ex_ior}
	 * labeled alternative in {@link SelectScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEx_ior(SelectScriptParser.Ex_iorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ex_le}
	 * labeled alternative in {@link SelectScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEx_le(SelectScriptParser.Ex_leContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ex_ne}
	 * labeled alternative in {@link SelectScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEx_ne(SelectScriptParser.Ex_neContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ex_neg}
	 * labeled alternative in {@link SelectScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEx_neg(SelectScriptParser.Ex_negContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ex_not}
	 * labeled alternative in {@link SelectScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEx_not(SelectScriptParser.Ex_notContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ex_or}
	 * labeled alternative in {@link SelectScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEx_or(SelectScriptParser.Ex_orContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ex_pos}
	 * labeled alternative in {@link SelectScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEx_pos(SelectScriptParser.Ex_posContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ex_div_mod_mul}
	 * labeled alternative in {@link SelectScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEx_div_mod_mul(SelectScriptParser.Ex_div_mod_mulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ex_and}
	 * labeled alternative in {@link SelectScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEx_and(SelectScriptParser.Ex_andContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ex_spec}
	 * labeled alternative in {@link SelectScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEx_spec(SelectScriptParser.Ex_specContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ex_pow}
	 * labeled alternative in {@link SelectScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEx_pow(SelectScriptParser.Ex_powContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ex_ge}
	 * labeled alternative in {@link SelectScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEx_ge(SelectScriptParser.Ex_geContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ex_xor}
	 * labeled alternative in {@link SelectScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEx_xor(SelectScriptParser.Ex_xorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ex_inot}
	 * labeled alternative in {@link SelectScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEx_inot(SelectScriptParser.Ex_inotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ex_shift}
	 * labeled alternative in {@link SelectScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEx_shift(SelectScriptParser.Ex_shiftContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ex_lt}
	 * labeled alternative in {@link SelectScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEx_lt(SelectScriptParser.Ex_ltContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ex_in}
	 * labeled alternative in {@link SelectScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEx_in(SelectScriptParser.Ex_inContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ex_ex}
	 * labeled alternative in {@link SelectScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEx_ex(SelectScriptParser.Ex_exContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ex_ixor}
	 * labeled alternative in {@link SelectScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEx_ixor(SelectScriptParser.Ex_ixorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ex_add_sub}
	 * labeled alternative in {@link SelectScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEx_add_sub(SelectScriptParser.Ex_add_subContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ex_iand}
	 * labeled alternative in {@link SelectScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEx_iand(SelectScriptParser.Ex_iandContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ex_gt}
	 * labeled alternative in {@link SelectScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEx_gt(SelectScriptParser.Ex_gtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ex_eq}
	 * labeled alternative in {@link SelectScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEx_eq(SelectScriptParser.Ex_eqContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#import_s2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_s2(SelectScriptParser.Import_s2Context ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(SelectScriptParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#function_del}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_del(SelectScriptParser.Function_delContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#function_mem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_mem(SelectScriptParser.Function_memContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#if_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_expr(SelectScriptParser.If_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(SelectScriptParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#loc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoc(SelectScriptParser.LocContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(SelectScriptParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#pipe}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipe(SelectScriptParser.PipeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#pipe_allowed}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipe_allowed(SelectScriptParser.Pipe_allowedContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#procedure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedure(SelectScriptParser.ProcedureContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#procedure_params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedure_params(SelectScriptParser.Procedure_paramsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#recur_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecur_expr(SelectScriptParser.Recur_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference(SelectScriptParser.ReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#repository}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepository(SelectScriptParser.RepositoryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#selection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection(SelectScriptParser.SelectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#sel_as}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSel_as(SelectScriptParser.Sel_asContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#sel_connect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSel_connect(SelectScriptParser.Sel_connectContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#sel_dir}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSel_dir(SelectScriptParser.Sel_dirContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#sel_from}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSel_from(SelectScriptParser.Sel_fromContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#sel_group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSel_group(SelectScriptParser.Sel_groupContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#sel_limit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSel_limit(SelectScriptParser.Sel_limitContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#sel_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSel_list(SelectScriptParser.Sel_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#sel_order}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSel_order(SelectScriptParser.Sel_orderContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#sel_select}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSel_select(SelectScriptParser.Sel_selectContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#sel_start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSel_start(SelectScriptParser.Sel_startContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#sel_stop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSel_stop(SelectScriptParser.Sel_stopContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#sel_where}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSel_where(SelectScriptParser.Sel_whereContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet(SelectScriptParser.SetContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#special}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecial(SelectScriptParser.SpecialContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#special2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecial2(SelectScriptParser.Special2Context ctx);
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
	 * Visit a parse tree produced by {@link SelectScriptParser#try_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTry_expr(SelectScriptParser.Try_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(SelectScriptParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectScriptParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(SelectScriptParser.VariableContext ctx);
}