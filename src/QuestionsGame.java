// This is a starter file for QuestionsGame.
//
// You should delete this comment and replace it with your class
// header comment.

import java.io.PrintStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Stack;

public class QuestionsGame {
    // Your code here



    private static class QuestionNode {
        public final String q;
        public final QuestionNode yes;
        public final QuestionNode no;

        public QuestionNode(String question){
            q = question;
            this.yes = null;
            this.no = null;
        }
        public QuestionNode(String question, QuestionNode yes, QuestionNode no){
            q = question;
            this.yes = yes;
            this.no = no;
        }
    }
    public QuestionsGame(String object){
        QuestionsGame a = new QuestionsGame(object);
    }

    public QuestionsGame(Scanner input){
    }
    public void saveQuestions(PrintStream output){
        Stack<QuestionNode> s = new Stack<>();
        //s.push(root);

        while(!s.isEmpty()){
            QuestionNode current = s.pop();
            output.print(current.q);

            if (current.no != null){
                s.push(current.no);
            }
            if (current.yes != null){
                s.push(current.yes);
            }
        }
    }

    public void play(){

    }


}
