package lox;

import lox.Expr.Assign;
import lox.Expr.Binary;
import lox.Expr.Call;
import lox.Expr.Get;
import lox.Expr.Grouping;
import lox.Expr.Literal;
import lox.Expr.Logical;
import lox.Expr.Set;
import lox.Expr.Super;
import lox.Expr.This;
import lox.Expr.Unary;
import lox.Expr.Variable;

public class AstPrinter implements Expr.Visitor<String> {
    String print(Expr expr) {
        return expr.accept(this);
    }

    @Override
    public String visitBinaryExpr(Binary expr) {
        return parenthesize(expr.operator.lexeme,
                        expr.left, expr.right);
    }

    @Override
    public String visitGroupingExpr(Grouping expr) {
        return parenthesize("group", expr.expression);
    }

    @Override
    public String visitLiteralExpr(Literal expr) {
        if (expr.value == null) return "nil";
        return expr.value.toString();
    }

    @Override
    public String visitUnaryExpr(Unary expr) {
        return parenthesize(expr.operator.lexeme, expr.right);
    }

    private String parenthesize(String name, Expr... exprs) {
        StringBuilder builder = new StringBuilder();

        builder.append("(").append(name);
        for (Expr expr : exprs) {
            builder.append(" ");
            builder.append(expr.accept(this));
        }
        builder.append(")");

        return builder.toString();
    }

    @Override
    public String visitVariableExpr(Variable expr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitVariableExpr'");
    }

    @Override
    public String visitAssignExpr(Assign expr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitAssignExpr'");
    }

    @Override
    public String visitLogicalExpr(Logical expr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitLogicalExpr'");
    }

    @Override
    public String visitCallExpr(Call expr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitCallExpr'");
    }

    @Override
    public String visitGetExpr(Get expr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitGetExpr'");
    }

    @Override
    public String visitSetExpr(Set expr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitSetExpr'");
    }

    @Override
    public String visitThisExpr(This expr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitThisExpr'");
    }

    @Override
    public String visitSuperExpr(Super expr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitSuperExpr'");
    }

  }
