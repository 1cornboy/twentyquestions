import java.io.IOException;
import java.io.PrintStream;
import java.io.File;
import java.util.Scanner;

public class questionTreeTester
{
    public static void main(String[] args) throws IOException{
        BinaryTreePrinter printer = new BinaryTreePrinter();

        Scanner file = new Scanner(new File("spec-questions.txt"));
        QuestionsGame theTree = new QuestionsGame(file);
        printer.printPreOrder(System.out, theTree.root);
    }
}

class BinaryTreePrinter {

    public BinaryTreePrinter() {}
    
    //Assumes your nodes have data, left and right
	private String traversePreOrder(QuestionsGame.QuestionNode root) {

        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.q);
        
        String pointerRight ="[R]--";
        String pointerLeft = (root.no != null) ? "[L]--" : "[L]--";

        traverseNodes(sb, "", pointerLeft, root.no, root.yes != null);
        
        traverseNodes(sb, "", pointerRight, root.no, false);

        return sb.toString();
    }
    private void traverseNodes(StringBuilder sb, String padding, String pointer, QuestionsGame.QuestionNode node, boolean hasRightSibling) {

        if (node != null) {

            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.q);

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("|    ");
            } else {
                paddingBuilder.append("     ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "[R]--";
            String pointerLeft = (node.no != null) ? "[L]--" : "[L]--";

            traverseNodes(sb, paddingForBoth, pointerLeft, node.yes, node.right != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.no, false);

        }

    }

    public void printPreOrder(PrintStream os, QuestionsGame.QuestionNode overallRoot) {
        os.print(traversePreOrder(overallRoot));
    }


}