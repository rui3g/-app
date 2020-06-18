package cn.edu.tjrac.booksale.controller;

import cn.edu.tjrac.booksale.vo.ListNode;
import io.swagger.models.auth.In;

import javax.swing.tree.TreeNode;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Stack;

/**
 * @author Rui3g
 * @date 2020/1/19 10:23
 *
 */
public class Demo {


    /*public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }*/

    /*输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
    假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。*/

    public static  void main(String []args){
        /*while(true){
            System.out.println("基于Java的输出");
            break;
        }
        System.out.println("基于Java输出再输出");
        System.out.println("一袋米哟抗击楼，一袋米有抗二楼，一袋米有西了那么多泥，世界有一袋米有，森罗天征");
        System.out.println("输出点在天气上");*/
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = date.format(new Date());
        System.out.println(time);
        int x = 0;
        Random random = new Random();
        if (time != null) {
            x = random.nextInt(10);
            System.out.println("随机数:" + x);
        }
        switch (x){
            case 1:
                System.out.println("杀掉");
                break;
            case 2:
                System.out.println("图");
                break;
            case 3:
                System.out.println(x);
                break;
            default:
                System.out.println("皮革r");
        }
        System.out.println("就这样了");
        Stack<Integer> stack=new Stack<Integer>();
        Stack<Integer> stack1=new Stack<Integer>();
        stack.push(10);
        if (!stack.isEmpty()){
            stack1.push(stack.pop());
        }
        int fir=stack1.pop();
        while(!stack1.isEmpty()){
            stack.push(stack1.pop());
        }
        System.out.println(fir);
    }
}
