import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AVLTree AVL = new AVLTree();
        String input = "";

        while(!input.equals("exit")){
            input = sc.nextLine();
            String[] parts = input.split(" ");
            if(parts[0].equals("insert")){
                int i = Integer.parseInt(parts[1]);
                AVL.root = AVL.insert(AVL.root, i);
            }else if(parts[0].equals("print")){
                if(parts[1].equals("preorder")){
                    AVL.printPreOrder(AVL.root);
                    System.out.println();
                }else if(parts[1].equals("inorder")){
                    AVL.printInorder(AVL.root);
                    System.out.println();
                }else if(parts[1].equals("postorder")){
                    AVL.printPostorder(AVL.root);
                    System.out.println();
                }else if(parts[1].equals("levels")){
                    AVL.printLevelOrder();
                    System.out.println();
                }
            }
        }
        sc.close();
    }
}
