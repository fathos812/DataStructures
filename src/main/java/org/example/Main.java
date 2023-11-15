package org.example;

import org.example.general.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        List<Integer> listToRemove = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            int value = random.nextInt(100);
            tree.insert(value);
            if (i < 5){
                listToRemove.add(value);
            }
        }


        System.out.println("Antes de Remover: ");

        System.out.print("in_level:  ");
        print(tree.traverse(TreeTraversal.IN_LEVEL_ORDER));

        System.out.print("pre_order: ");
        print(tree.traverse(TreeTraversal.PRE_ORDER));

        System.out.print("post_order: ");
        print(tree.traverse(TreeTraversal.POST_ORDER));

        System.out.print("in_order:  ");
        print(tree.traverse(TreeTraversal.IN_ORDER));

       // Deletando elementos da arvores:
        for (Integer i : listToRemove) {
            tree.delete(i);
        }


        System.out.println("depois da remoção:");

        System.out.print("in_level:  ");
       print(tree.traverse(TreeTraversal.IN_LEVEL_ORDER));

        System.out.print("pre_order: ");
       print(tree.traverse(TreeTraversal.PRE_ORDER));

        System.out.print("por_order: ");
       print(tree.traverse(TreeTraversal.POST_ORDER));

        System.out.print("in_oder:  ");
       print(tree.traverse(TreeTraversal.IN_ORDER));
    }

    public static void print(List<Integer> list) {
        list.forEach((element) -> System.out.print(element+","));
        System.out.println();

    }
}