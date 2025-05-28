package Clase1;

import org.junit.jupiter.api.Test;

import javax.crypto.spec.PSource;
import java.util.Arrays;
import java.util.List;



public class LambdaExpressionTest {

    /*
    Lambda Expressions en Java
    - Son funciones anónimas que se pueden usar para implementar interfaces funcionales.
    - Sintaxis: (parámetros) -> { cuerpo }

    Ejemplos:
    () -> System.out.println("Hola");
    (x, y) -> x + y;
    s -> s.toUpperCase();

    Se usan comúnmente con Streams para transformar, filtrar o procesar colecciones de forma concisa.
*/

    @Test
    void lambaTest() {

        List<String> list = Arrays.asList("Java", "Python", "C#");

        //filtrar los elementos de la lista que comienzan con "J"

        list.stream().
                filter(name ->name.startsWith("J")).forEach(System.out::println);

        //Dado una lista de enteros, use Stream y Lambdas para imprimir
        //solo los numeros pares

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);

        numbers.stream().filter(n-> n%2 ==0).forEach(System.out::println);


        //dado una lista de numeros enteros usar Lamda para
        //contar cuantos elementos son mayores a 10

        List<Integer> numbersList= Arrays.asList(5,15,20,7,10);

        long quantity =numbersList.stream().filter(n->n>10).
                count();
        System.out.println("Greater than 10: "+ quantity);

    }

    @Test
    void testIntegers() {

        Integer [] values ={2,9,0,5,3,1,7,4,8,6};

        //Display

        System.out.println("Original values: "+Arrays.asList(values));

        //ordernar lista sort

        System.out.println("Sorted LIst "+Arrays.stream(values).sorted().toList());

        //values greater than 4

        List<Integer> greatherThanFour = Arrays.stream(values).
                filter(n->n>4).toList();
        System.out.println("Values greater than 4: "+greatherThanFour);
    }

    @Test
    void testStrings() {

        String [] stringList ={"Red","Orange","Yellow","Green","Blue"};

        //Displaying original String list

        System.out.println("Origial Values: "+ Arrays.asList(stringList));

        //To Uppercase (Mayusculas)

        System.out.println("To UpperCase: "+
                Arrays.stream(stringList)         //Convierte arreglo Stream
                        .map(String::toUpperCase) //Realiza transformacion de cada elemento a Uppercase
                        .toList()                 //String::toUpperCase s -> s.toUpperCase()
                                                  // toList(), me convierte todo a lista


        );

        //Sorted asc

        System.out.println("Sorted ascending :"+
                Arrays.stream(stringList).sorted().toList()

        );
    }
}
