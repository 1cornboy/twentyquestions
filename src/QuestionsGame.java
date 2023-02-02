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
    QuestionNode root;



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
        //File file = new File("") fix pls :)
        QuestionsGame a = new QuestionsGame(object);
    }

    public QuestionsGame(Scanner input){
    }
    public void saveQuestions(PrintStream output){
        Stack<QuestionNode> s = new Stack<>();
        //s.push(root);

        while(!s.isEmpty()){
            QuestionNode current = s.pop();
            output.println(current.q);

            if (current.no != null){
                s.push(current.no);
            }
            if (current.yes != null){
                s.push(current.yes);
            }
        }
    }

    public void play(){
        QuestionNode current = root;
        while(current.yes != null || current.no != null){
            System.out.println("Question: "+current.q);
            Scanner keyboard = new Scanner(System.in);
            if(keyboard.nextLine().trim().toLowerCase().startsWith("y") && current.yes != null){
                current = current.yes;
            }
            else{
                if(current.no != null) {
                    current = current.no;
                }
            }
        }
        if(current.yes == null && current.no == null){
            String ans = current.q;
            System.out.println(ans);
            System.out.println("Is this the object you were thinking of? Y/N\n");
            Scanner keyboard = new Scanner(System.in);
            if(keyboard.nextLine().trim().toLowerCase().startsWith("y")){
                System.out.println("Hooray! I guessed your object!! :P");
            }
            else{
                System.out.println("You've beat me!\n");
                System.out.println("What object were you thinking of?");
                String obj = keyboard.next();
                //TODO: save obj

                System.out.println("Input a question to distinguish this object from "+ans);
                String obj = keyboard.next();
                //TODO: save this too
                System.out.println("Was your object the yes or no answer to the question you just inputted? Y/N");
                if(keyboard.nextLine().trim().toLowerCase().startsWith("y")){
                    //yes
                }
                else{
                    //no
                }
                //TODO: add all of that to the tree & file

            }
        }
    }


}
