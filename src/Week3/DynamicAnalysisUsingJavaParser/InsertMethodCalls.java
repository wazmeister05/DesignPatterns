package Week3.DynamicAnalysisUsingJavaParser;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InsertMethodCalls {

    public static void main(String[] args) throws Exception {
        String fileName = "C:\\Users\\GA\\IdeaProjects\\DesignPatterns\\src\\Week3\\DynamicAnalysisUsingJavaParser\\Test.java";
        FileInputStream in = new FileInputStream(fileName);
        CompilationUnit cu;
        try{
            cu = StaticJavaParser.parse(in);
        } finally {
            in.close();
        }
        new ModifyMethods().visit(cu, null);
        // write the modified cu to console
        byte[] modfile = cu.toString().getBytes();
        Path file = Paths.get(fileName);
        Files.write(file, modfile);
    }

    private static class ModifyMethods extends VoidVisitorAdapter{

        @Override
        public void visit(MethodDeclaration n, Object arg){
            // create a method call expression
            // but you can add any sort of code you want
            MethodCallExpr callPrint = new MethodCallExpr();
            // the scope of the method call is System.out
            callPrint.setScope(new NameExpr("System.out"));
            // the method we want to call is println
            callPrint.setName("println");

            // or we can build up callPrint this way...
            // MethodCallExpr callPrint = new MethodCallExpr(new NameExpr("System.out"), "println");

            // we want to pass println the name of the method it finds as the argument
            callPrint.addArgument(new StringLiteralExpr(n.getNameAsString()));

            // and make that print statement the first thing that happens in the method
            n.getBody().get().addStatement(0, callPrint);

            // or can update the body of the method this way...
            // n.getBody().ifPresent(l -> l.addStatement(0, callPrint));

            // OR can update the body of the method this way...
            // BlockStmt b = n.getBody().get();
            // b.addStatement(0, callPrint);
            // n.setBody(b);

            // beware trailing comments. They will be moved;
        }
    }
}
