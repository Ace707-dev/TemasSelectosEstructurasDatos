import java.util.Scanner;

public class ListaDoblementeEnlazadaJava{

        private Nodo inicio, fin;

        public void eliminarInicio() {
            if (!estaVacia()) {
                if (inicio == fin) {
                    inicio = fin = null;
                } else {
                    inicio = inicio.siguiente;
                    inicio.anterior = null;
                }
            }
        } //este método elimina el primer elemento de la lista. 
        //Si la lista no está vacía, se actualiza el nodo inicio. Si la lista tiene un solo nodo, se asigna null a inicio y fin. 
        //Si la lista tiene más de un nodo, se actualiza el nodo inicio y se elimina la referencia al nodo anterior.

        public void eliminarFinal() {
            if (!estaVacia()) {
                if (inicio == fin) {
                    inicio = fin = null;
                } else {
                    fin = fin.anterior;
                    fin.siguiente = null;
                }
            }
        } //este método elimina el último elemento de la lista.

     
        public ListaDoblementeEnlazadaJava() {
            inicio = fin = null;
        } //este es el constructor de la clase ListaDoblementeEnlazadaJava que inicializa las variables inicio y fin en null. Esto indica que la lista está vacía.
    
        public boolean estaVacia() {
            return inicio == null;
        } //este método devuelve true si la lista está vacía, es decir, si el nodo inicio es null.

        public void agregarAlFinal(int elemento) {
            if (!estaVacia()) {
                fin = new Nodo(elemento, null, fin);
                fin.anterior.siguiente = fin;
            } else {
                inicio = fin = new Nodo(elemento);
            }
        } //este método agrega un elemento al final de la lista. Si la lista no está vacía, se crea un nuevo nodo con el elemento y se enlaza con el nodo fin. Luego, se actualiza el nodo fin. Si la lista está vacía, se crea un nuevo nodo y se asigna a inicio y fin.
    
        public void agregarAlInicio(int elemento) {
            if (!estaVacia()) {
                inicio = new Nodo(elemento, inicio, null);
                inicio.siguiente.anterior = inicio;
            } else {
                inicio = fin = new Nodo(elemento);
            }
        } //este método agrega un elemento al inicio de la lista. Si la lista no está vacía, se crea un nuevo nodo con el elemento y se enlaza con el nodo inicio. Luego, se actualiza el nodo inicio. Si la lista está vacía, se crea un nuevo nodo y se asigna a inicio y fin.
    
        public void agregarOrdenado(int elemento) {
            if (!estaVacia()) {
                if (inicio == fin) {
                    if (elemento < inicio.dato) agregarAlInicio(elemento);
                    else agregarAlFinal(elemento);
                } else {
                    Nodo temporal, puntero;
                    temporal = new Nodo(elemento);
                    puntero = inicio;
                    while (puntero != null && elemento > puntero.dato) {
                        puntero = puntero.siguiente;
                    }
                    if (puntero != null) {
                        temporal.anterior = puntero.anterior;
                        if (puntero.anterior != null) puntero.anterior.siguiente = temporal;
                        puntero.anterior = temporal;
                        temporal.siguiente = puntero;
                        if (puntero == inicio) inicio = temporal;
                    } else {
                        agregarAlFinal(elemento);
                    }
                }
            } else {
                inicio = fin = new Nodo(elemento);
            }
        } //este método agrega un elemento a la lista de forma ordenada. Si la lista no está vacía, se crea un nuevo nodo con el elemento y se busca la posición correcta para insertarlo. 
        //Si el elemento es menor que el dato del nodo inicio, se agrega al inicio de la lista. Si el elemento es mayor que el dato del nodo fin, se agrega al final de la lista. 
        //En otro caso, se recorre la lista hasta encontrar la posición correcta para insertar el elemento.
    
        public void mostrarListaInicioFin() {
            if (!estaVacia()) {
                Nodo recorrer = inicio;
                while (recorrer != null) {
                    System.out.print("[" + recorrer.dato + "]-->");
                    recorrer = recorrer.siguiente;
                }
            }
        } //este método muestra los elementos de la lista desde el inicio hasta el final. Si la lista no está vacía, se recorre la lista desde el nodo inicio hasta el nodo fin y se muestra el dato de cada nodo.
    
        public void mostrarListaFinInicio() {
            if (!estaVacia()) {
                Nodo recorrer = fin;
                while (recorrer != null) {
                    System.out.print("[" + recorrer.dato + "]-->");
                    recorrer = recorrer.anterior;
                }
            }
        } //este método muestra los elementos de la lista desde el final hasta el inicio. Si la lista no está vacía, se recorre la lista desde el nodo fin hasta el nodo inicio y se muestra el dato de cada nodo.
    
        class Nodo {
            int dato;
            Nodo siguiente, anterior;
    
            public Nodo(int el) {
                this(el, null, null);
            }
    
            public Nodo(int el, Nodo s, Nodo a) {
                dato = el;
                siguiente = s;
                anterior = a;
            }


        } //la clase Nodo representa un nodo de la lista doblemente enlazada. Cada nodo tiene un dato, una referencia al nodo siguiente y una referencia al nodo anterior.

        public static void LimpiarConsola() {
            System.out.print("\033[2J");
            System.out.print("\033[H"); 
        }


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            ListaDoblementeEnlazadaJava lista = new ListaDoblementeEnlazadaJava();
            LimpiarConsola();
            System.out.println("Lista vacía: " + lista.estaVacia());
            lista.mostrarListaInicioFin();
            sc.nextLine();
            LimpiarConsola();
            System.out.println("Agregando elementos al princio y al final de la lista");
            System.out.println();
            System.out.println("Mostrando lista del inicio al final");
            lista.agregarAlFinal(10);
            lista.agregarAlInicio(20);
            lista.agregarAlInicio(30);
            lista.agregarAlFinal(40);
            lista.mostrarListaInicioFin();
            System.out.println();
            System.out.println("Mostrando lista del final al inicio");
            lista.mostrarListaFinInicio();
            sc.nextLine();
            LimpiarConsola();
            System.out.println("Eliminando el primer y último elemento de la lista");
            System.out.println();
            System.out.println("Mostrando lista del inicio al final");
            lista.mostrarListaInicioFin();
            System.out.println();
            System.out.println("Eliminando el primer elemento de la lista");
            lista.eliminarInicio();
            lista.mostrarListaInicioFin();
            System.out.println();
            System.out.println("Eliminando el último elemento de la lista");
            lista.eliminarFinal();
            lista.mostrarListaInicioFin();
            sc.nextLine();
            LimpiarConsola();

            System.out.println("Agregando elementos a la lista de forma ordenada");
            System.out.println();   
            System.out.println("Mostrando lista del inicio al final");
            lista.mostrarListaInicioFin();
            lista.agregarOrdenado(50);
            lista.agregarOrdenado(5);
            lista.agregarOrdenado(35);
            System.out.println("Mostrar lista del inicio al final con datos agregados de forma ordenada");
            lista.mostrarListaInicioFin();
           
    



            sc.close();
        } //este es el método main de la clase ListaDoblementeEnlazadaJava. En este método, se crea un objeto de la clase ListaDoblementeEnlazadaJava y se realizan las consultas solicitadas.

       

    }

