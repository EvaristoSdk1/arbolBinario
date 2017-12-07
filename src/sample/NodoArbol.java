package sample;

public class NodoArbol {//Clase NodoArbol

    public int dato; //Variable que recibe el nodo raíz
    public NodoArbol Izquierdo;//Variable que nos permite agregar hijos a la parte izquierda del nodo raíz
    public NodoArbol Derecho;//Variable que nos permite agregar hijos a la parte derecha del nodo raíz

    public NodoArbol(int num) { //Método que nos permite agregar valor a los nodos
        this.dato = num;// que a la vez puede ser llamada desde otra clase
        this.Izquierdo = null;//Solamente asigna valor a la variable num e Izquierdo y Derecho permanecen nulos.
        this.Derecho = null;
    }

    public NodoArbol() {//Método que agreda el valor nulo a las variables Izquierdo y Derecho.
        this.Izquierdo = null;
        this.Derecho = null;
    }

    public static NodoArbol crearNodo(int number) {//Método que nos permite crear un nodo
        return new NodoArbol(number);//y retornar como un nuevo nodo raíz
    }

    public int getDato() {//Nos permite leer el valor del nodo
        return dato;//retorna el valor del nodo
    }

    public void setDato(int dato) {//Nos permite enviar el valor al nodo
        this.dato = dato;//asigna el valor agregado a una variable llamada "dato".
    }

    public NodoArbol getIzquierdo() {//Nos permite leer el valor agregado a la parte izquierda del nodo raíz
        return Izquierdo;//retorna el valor del nodo
    }

    public void setIzquierdo(NodoArbol izquierdo) {//Nos permite enviar el valor a la parte izquierda del nodo raíz, convirtiendo en su nodo hijo
        Izquierdo = izquierdo;//asigna el valor agregado a una variable llamada "izquierdo".
    }

    public NodoArbol getDerecho() {//Nos permite leer el valor agregado a la parte derecha del nodo raíz
        return Derecho;//retorna el valor del nodo
    }

    public void setDerecho(NodoArbol derecho) {//Nos permite enviar el valor a la parte derecha del nodo raíz, convirtiéndolo en su nodo hijo
        Derecho = derecho;//asigna el valor agregado a una variable llamada "derecho".
    }
}
