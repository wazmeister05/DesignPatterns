package Week3.StaticAnalysisUsingJavaParser;

import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.List;

public class ClassDiagramVisitor extends VoidVisitorAdapter{
    public void visit(ClassOrInterfaceDeclaration coid, Object arg){
        System.out.println("\nClass");
        System.out.println("  " + coid.getName());

        List<ClassOrInterfaceType> implementedTypes = coid.getImplementedTypes();
        if(!implementedTypes.isEmpty()){
            System.out.println("Implements: ");
            for(ClassOrInterfaceType coi : implementedTypes){
                System.out.println("  " + coi.getName());
            }
        }

        List<ClassOrInterfaceType> extendedTypes = coid.getExtendedTypes();
        if(!extendedTypes.isEmpty()){
            System.out.println("Extends: ");
            for(ClassOrInterfaceType coi : extendedTypes){
                System.out.println("  " + coi.getName());
            }
        }

        // remove me after first run
        super.visit(coid, arg);
    }

    public void visit(FieldDeclaration fd, Object fdo){
        System.out.println("\nFields");
        for(VariableDeclarator v : fd.getVariables()){
            System.out.println(v.getName() + " : " + v.getType());
        }
    }

    public void visit(MethodDeclaration md, Object mdo){
        System.out.println("\nMethod");
        System.out.println(md.getName() + "(");
        for(Parameter p : md.getParameters()){
            System.out.println("  " + p.getName() + " : " + p.getType());
        }
        System.out.println(")");
    }
}
