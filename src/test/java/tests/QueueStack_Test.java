package tests;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class QueueStack_Test {

    @Test
    void stackTest() {

        //declarando el objeto pila que se importa del java util
        Stack<String> stack = new Stack<>();

        //adding elements to the stack

        stack.push("first");
        stack.push("second");
        stack.push("third");
        stack.push("fourth");// ultijmo elemento que entro, primer elmento que sale LIFO

        System.out.println("Current Stack " + stack);

        //pedir que nos de el primer elmento si removerlo

        String top = stack.peek();

        System.out.println("Peek(top) "+top);

        //usando metodo top, quita el primer elemento de la pila y lo elimina

        String firstElement = stack.pop();

        System.out.println("Current Stack " + stack);
        System.out.println("Elemento removido por Pop "+firstElement);
        System.out.println("Current Stack " + stack);

        //ver tamaño de la pila con size

        int tamanioPila= stack.size();
        System.out.println("tamaño de la pila es: "+tamanioPila);
    }

    @Test
    void queueTest() {

        Queue<String> taskQueue = new LinkedList<>();
        //Queue<String> taskQueue2 = new PriorityQueue<>();

        taskQueue.add("First");
        taskQueue.add("Second");
        taskQueue.add("Third");
        taskQueue.add("fourth");

        System.out.println("Current Queue "+taskQueue);

        System.out.println("Peek(): "+taskQueue.peek());

        System.out.println("Poll(): "+taskQueue.poll());

        System.out.println("Current Queue "+taskQueue);

        System.out.println("Current size "+taskQueue.size());

        System.out.println("Is Empty "+taskQueue.isEmpty());

    }
}
