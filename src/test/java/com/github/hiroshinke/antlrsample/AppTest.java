

package com.github.hiroshinke.antlrsample;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.TestName;
import static org.hamcrest.Matchers.is;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Lexer;
    
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Rule
    public TestName name = new TestName();

    @Test public void test1()
    {
	ArithmeticParser p = (ArithmeticParser)createParser("x=1+2\n");
	ParseTree tree = p.file_();
	EvalVisitor visitor = new EvalVisitor();
	int i = visitor.visit(tree);
	assertThat(i,is(3));
    }

    @Test public void test2()
    {
	ArithmeticParser p = (ArithmeticParser)createParser("x");
	ParseTree tree = p.file_();
	assertThat(tree.toStringTree(p),
		   is("(file_ stat (stat x) <EOF>)"));
    }

    
    Parser createParser(String src){
    
        ANTLRInputStream input = new ANTLRInputStream(src); 
        ArithmeticLexer lexer = new ArithmeticLexer(input); 
        CommonTokenStream tokens = new CommonTokenStream(lexer); 
        ArithmeticParser parser = new ArithmeticParser(tokens);

	return parser;
    }
}
