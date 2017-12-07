package sample;

import javafx.scene.control.Label;

public class ArbolBinario {//Clase ArbolBinario

    public String preOrder(NodoArbol raiz, Label label) {//Función preOrden para árbol binario
        StringBuilder sb = new StringBuilder(); //Definimos un StringBuilder para poder acceder a los valores de los nodos del árbol binario
        if (raiz != null){ //Si la raíz del árbol binario no está vacío prosigue con el proceso
            sb.append(raiz.getDato() + " "); //El árbol sigue el método de ordenamiento esto significa que el primer valor es el de la raíz
            sb.append(preOrder(raiz.getIzquierdo(), label ));//el segundo valor es el valor que se encuentra en la rama izquierda del árbol
            sb.append(preOrder(raiz.getDerecho(),label));//el tercer valor es el valor que se encuentra en la rama derecha del árbol
            //Este proceso acaba cuando ya no hay valores en el árbol, el proceso es el mencionado anteriormente raíz, nodoIzquierdo y NodoDerecho
            //esto se aplica en cada raíz del árbol hasta que se acaba.
            label.setText(sb.toString());//El método tiene dos parámetros el nodo raíz y el label, el label contiene todos los valores del árbol
            //ordenados anteriormente
        }
        return sb.toString();
    }

    public String inOrden(NodoArbol raiz, Label label) { //Función inOrden para árbol binario
        StringBuilder sb = new StringBuilder(); //Definimos un StringBuilder para poder acceder a los valores de los nodos del árbol binario
        if(raiz != null){ //Si la raíz del árbol binario no está vacío prosigue con el proceso
            sb.append(inOrden(raiz.getIzquierdo(), label)); //El árbol sigue el método de ordenamiento esto significa que el primer valor es el
            // de la raíz Izquierda esto significa que baja hasta el último valor de la raíz izquierda del árbol y después sube
            sb.append(raiz.getDato() + " ");//el segundo valor después de subir a la raíz
            sb.append(inOrden(raiz.getDerecho(), label));//después baja al nodo derecho del árbol y así sucesivamente, hasta pasar por todos
            //los nodos del árbol siguiendo el método de ordenamiento
            label.setText(sb.toString());//El método tiene dos parámetros el nodo raíz y el label, el label contiene todos los valores del árbol
            //ordenados anteriormente
        }
        return sb.toString();
    }

    public String postOrden(NodoArbol raiz, Label label) { //Función postOrden para árbol binario
        StringBuilder sb = new StringBuilder();//Definimos un StringBuilder para poder acceder a los valores de los nodos del árbol binario
        if(raiz != null ){//Si la raíz del árbol binario no está vacío prosigue con el proceso
            sb.append(postOrden(raiz.getIzquierdo(), label));//El primer valor es el izquierdo del nodo raíz
            sb.append(postOrden(raiz.getDerecho(), label));//el segundo es el de lado derecho
            sb.append(raiz.getDato() + " ");// el tercero es el del nodo raíz y los primeros valores fueron de este mismo nodo raíz
            //este proceso se repite yendo de izquierda a derecha y vuelve al nodo, luego vuelve a repetirse hasta que no queden más nodos
            label.setText(sb.toString());//El método tiene dos parámetros el nodo raíz y el label, el label contiene todos los valores del árbol
            //ordenados anteriormente
        }
        return sb.toString();
    }

    public int minimoValor(NodoArbol raiz) {//Método que nos permite encontrar el valor mínimo del árbol
        int result;//variable en la que almacenaremos el valor mínimo
        if(raiz == null){//Si el árbol está vacío
            result = Integer.MAX_VALUE;//le asigna el valor máximo a la variable "result" que es 0
        } else {//En caso de que el árbol no este vacío
            result = raiz.dato;//la variable "result" toma el valor del nodo raíz
            final int izquierdaResultado = minimoValor(raiz.Izquierdo);//creamos una variable llamada "izquierdaResultado" que compara los valores
            //del lado izquierdo del árbol
            if(izquierdaResultado < result){//if que compara los valores hasta encontrar el valor mínimo
                result = izquierdaResultado;//una vez encontrado el valor mínimo se le asigna a la variable "result"
            }
            final int derechoResultado = minimoValor(raiz.Derecho);//creamos una variable llamada "derechoResultado" que compara los valores
            //del lado derecho del árbol
            if(derechoResultado < result){//if que compara los valores hasta encontrar el valor mínimo
                result = derechoResultado;//una vez encontrado el valor mínimo se le asigna a la variable "result"
            }
        }//Este método usa recursividad que repite el proceso de los dos lados e igualmente compara los resultados de ambos lados y nos devuelve
        //el valor mínimo
        return result;//retorna el valor mínimo del árbol
    }

    public int mayorValor(NodoArbol raiz) { //Método que busca el nodo mayor del árbol
        if (null == raiz)//Si el árbol esta vacío
            return Integer.MIN_VALUE;
        int NodoValor = raiz.dato; //La variable NodoValor toma el valor del nodo
        int hIzquierdo = mayorValor(raiz.Izquierdo); //La variable hIzquierdo toma el valor del nodo izquierdo
        int hDerecho = mayorValor(raiz.Derecho);//La variable hDerecho toma el valor del nodo derecho
        //usamos recursividad para poder encontrar el nodo mayor de todo el árbol y no solo compare los nodos hijos del nodo raíz
        return Math.max(Math.max(hIzquierdo, hDerecho), NodoValor);//Compara el valor de todas las variables y nos muestra el valor máximo
    }

    public boolean buscarNodo(NodoArbol raiz, int x) {//Método que nos permite encontrar un valor en específico del árbol
        if (raiz != null) {//Si el árbol no está vacío
            if (raiz.getDato() == x) {//El if se encarga de comparar el valor ingresado con el del árbol
                return true;//si lo encuentra devuelve true
            } else {//si no lo encuentra en el nodo raíz
                //usamos recursividad y repite el proceso con los valores del lado izquierdo y el lado derecho hasta encontrarlo
                return buscarNodo(raiz.getIzquierdo(), x) || buscarNodo(raiz.getDerecho(), x);//retorna el proceso de buscar
            }
        }
        return false;//Si el valor no es encontrado con todo el procedimiento anterior retorna false, indicándonos que el valor no se
        //encuentra en el árbol
    }

    public int contarNodos(NodoArbol raiz) {//Método que nos permite contar los nodos del árbol
        if(raiz==null)//Si el árbol esta vacío retorna 0
            return 0;
        else {//Si el árbol no está vacío
            return 1 + contarNodos(raiz.getIzquierdo()) + contarNodos(raiz.getDerecho());//cuenta los nodos del lado izquierdo y derecho, y el
            //1 es el nodo raíz.
        }
    }
}

