
package com.github.hiroshinke.antlrsample;

/**
 * Hello world!
 *
 */

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

class App {

    public static void main(String[] args) throws Exception {
        // create a CharStream that reads from standard input

        String filePath = args[0];
        File fileInput = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(fileInput);


        ANTLRInputStream input = new ANTLRInputStream(fileInputStream); 
        ArithmeticLexer lexer = new ArithmeticLexer(input); 
        CommonTokenStream tokens = new CommonTokenStream(lexer); 
        ArithmeticParser parser = new ArithmeticParser(tokens);
        ParseTree tree = parser.file_(); // begin parsing at init rule
        System.out.println(tree.toStringTree(parser)); // print LISP-style tree        
    }
}

