package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class tree {
    public static Node build(Scanner sc)
    {
        int data;
        //Scanner sc = new Scanner(System.in);
        data = sc.nextInt();

        // base case
        if(data==-1)
            return null;

        Node root = new Node(data);
        root.left = build(sc);
        root.right = build(sc);
        return root;
    }

    public static void preorder(Node root)
    {
        if(root==null)
            return;
        System.out.print(root.data+ " ");
        preorder(root.left);
        preorder(root.right);
        return;
    }
    public static void inorder(Node root)
    {
        if(root==null)
            return;
        preorder(root.left);
        System.out.print(root.data+ " ");
        preorder(root.right);
        return;
    }
    public static void postorder(Node root)
    {
        if(root==null)
            return;
        preorder(root.left);
        preorder(root.right);
        System.out.print(root.data+ " ");
        return;
    }
    public static void bfs(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty())
        {
            Node t = q.peek();
            if(t==null)
            {
                System.out.println();
                q.remove();
                if(q.isEmpty())
                {

                }
                else
                {
                    q.add(null);
                }
            }
            else
            {
                System.out.print(t.data+" ");
                q.remove();
                if(t.left!=null)
                {
                    q.add(t.left);
                }
                if(t.right!=null)
                {
                    q.add(t.right);
                }
            }
        }
        return;
    }

    public static int height(Node root)
    {
        if(root==null)
            return 0;
        return Math.max(height(root.left),height(root.right)) + 1;
    }
    public static void main(String[] args)
    {
        Node root;
        Scanner sc = new Scanner(System.in);
        root = build(sc);
        bfs(root);
    }
}
// 5 9 -1 -1 8 1 -1 -1 -1 10 -1 11 -1 12 -1 -1