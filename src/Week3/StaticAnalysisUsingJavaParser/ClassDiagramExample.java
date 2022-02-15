package Week3.StaticAnalysisUsingJavaParser;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.FileInputStream;

public class ClassDiagramExample {

    private int int1 = 0, int2 = 0;
    private String str1 = "";

    public static void main(String[] args) throws Exception {
        String fileName = "src/Week3/ClassDiagramExample.java";
        //String fileName = "src/Week3/ClassDiagramVisitor.java";
        FileInputStream in = new FileInputStream(fileName);

        CompilationUnit cu;
        try{
            cu = StaticJavaParser.parse(in);
        } finally {
            in.close();
        }

        new ClassDiagramVisitor().visit(cu, null);
    }
}
