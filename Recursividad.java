public class Recursividad {

    // Método para calcular el factorial de un número de manera recursiva
    public static int factorial(int n) {
        // Caso base: el factorial de 0 es 1
        if (n == 0) {
            return 1;
        }
        // Llamada recursiva: n factorial es n multiplicado por (n-1) factorial
        else {
            return n * factorial(n - 1);
        }
    }

    // Método para calcular el n-ésimo número de la secuencia de Fibonacci de manera recursiva
    public static int fibonacci(int n) {
        // Casos base: el primer y segundo número de la secuencia de Fibonacci son 0 y 1, respectivamente
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        // Llamada recursiva: el n-ésimo número de Fibonacci es la suma de los dos números anteriores
        else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    // Método principal para probar los métodos de factorial y Fibonacci
    public static void main(String[] args) {
        // Prueba del método factorial
        System.out.println("Factorial de 5: " + factorial(5)); // Debería imprimir 120

        // Prueba del método Fibonacci
        System.out.println("Fibonacci en la posición 7: " + fibonacci(7)); // Debería imprimir 13
    }
}