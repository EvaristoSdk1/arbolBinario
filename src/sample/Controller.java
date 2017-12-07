package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{//Clase Controller

    //Definimos los nombres de los label del sample.fxml
    @FXML Label r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, lblResultado;
    @FXML ComboBox cmbMetodos;//Definimos el nombre del comboBox del sample.fxml
    @FXML Pane paneArbolBinario;//Definimos el nombre del pane del sample.fxml
    @FXML TextField txtBuscarIngresar;//Definimos el nombre del TexField del sample.fxml
    @FXML Button btnContarNodo, btnNodoMinimo, btnNodoMaximo, btnBuscarNodo;//Definimos el nombre de los botones del sample.fxml

    //Definimos una variable llamada árbol para poder acceder a los métodos de la clase "ArbolBinario"
    ArbolBinario arbol = new ArbolBinario();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Para poder crear un nodo llamos al meotodo crearNodo de la clase NodoArbol y dentro de sus parentesis
        // agregamos el valor deseado.
        //Agregamos los valores del nivel 0 del árbol, que es la raíz
        NodoArbol A = NodoArbol.crearNodo(8);
        // Agregamos los valores del nivel 1 del árbol, que son hijos del nodo raíz
        NodoArbol B = NodoArbol.crearNodo(7);
        NodoArbol C = NodoArbol.crearNodo(9);
        // Agregamos los valores del nivel 2 del árbol, que son hijos de los nodos de arriba
        NodoArbol D = NodoArbol.crearNodo(3);
        NodoArbol E = NodoArbol.crearNodo(5);
        NodoArbol F = NodoArbol.crearNodo(4);
        NodoArbol G = NodoArbol.crearNodo(2);

        // Agregamos los valores del nivel 3 del árbol, que son hijos de los nodos de arriba
        NodoArbol H = NodoArbol.crearNodo(6);
        NodoArbol I = NodoArbol.crearNodo(1);
        NodoArbol J = NodoArbol.crearNodo(12);
        NodoArbol K = NodoArbol.crearNodo(22);
        NodoArbol L = NodoArbol.crearNodo(10);
        NodoArbol M = NodoArbol.crearNodo(11);

        // Los conectamos con el nodo raíz
        A.Izquierdo  = B;
        A.Derecho = C;

        // Conectamos el nivel 1 y 2
        B.Izquierdo  = D;
        B.Derecho = E;
        C.Izquierdo  = F;
        C.Derecho = G;

        // Conectamos con el nivel 3 y 4
        E.Izquierdo  = H;
        E.Derecho = I;
        G.Izquierdo  = J;
        G.Derecho = K;
        I.Izquierdo  = L;
        I.Derecho = M;

        //Le asignamos el valor de cada nodo a los label del sample
        r1.setText(String.valueOf(A.getDato()));
        r2.setText(String.valueOf(B.getDato()));
        r3.setText(String.valueOf(C.getDato()));
        r4.setText(String.valueOf(D.getDato()));
        r5.setText(String.valueOf(E.getDato()));
        r6.setText(String.valueOf(F.getDato()));
        r7.setText(String.valueOf(G.getDato()));
        r8.setText(String.valueOf(H.getDato()));
        r9.setText(String.valueOf(I.getDato()));
        r10.setText(String.valueOf(J.getDato()));
        r11.setText(String.valueOf(K.getDato()));
        r12.setText(String.valueOf(L.getDato()));
        r13.setText(String.valueOf(M.getDato()));

        //Le agregamos los datos al comboBox llamado cmbMetodos
        //que posteriormente utilizaremos para el menú
        this.cmbMetodos.getItems().addAll("PreOrden", "InOrden", "PostOrden");
        cmbMetodos.setOnAction((Event event) -> {
            //Le asignamos el valor del comboBox a la variable value
            String value = (String) cmbMetodos.getValue();

            switch (value) {//Creamos un switch y le agregamos la variable llamada value para comparar la opción que elija el usuario
                case "PreOrden"://Si elije la opción de preOrden

                    arbol.preOrder(A,lblResultado);//Llamamos al método preOrden de la clase ArbolBinario, y le pasamos el valor del nodo raíz
                    //y el label que será donde mostrara el resultado del método preOrden
                    break;//Detiene el proceso

                case "InOrden"://Si elije la opción de InOrden

                    arbol.inOrden(A, lblResultado);//Llamamos al método inOrden de la clase ArbolBinario, y le pasamos el valor del nodo raíz
                    //y el label que será donde mostrara el resultado del método inOrden
                    break;//Detiene el proceso

                case "PostOrden"://Si elije la opción de PostOrden

                    arbol.postOrden(A, lblResultado);//Llamamos al método postOrden de la clase ArbolBinario, y le pasamos el valor del nodo raíz
                    //y el label que será donde mostrara el resultado del método postOrden
                    break;//Detiene el proceso

                default://opcion default que quedara vacía
                    break;//Detiene el proceso
            }
        });

        //Acción del botón Mínimo al ser presionado por el usuario
        this.btnNodoMinimo.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                //Muestra un mensaje en pantalla
                //Llamamos al método minimoValor de la clase ArbolBinario, le pasamos en nodo raíz  y mostramos el resultado con
                // un mensaje en pantalla
                JOptionPane.showMessageDialog(null, arbol.minimoValor(A));
            }
        });

        //Acción del botón Máximo al ser presionado por el usuario
        this.btnNodoMaximo.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                //Muestra un mensaje en pantalla
                //Llamamos al método mayorValor de la clase ArbolBinario, le pasamos en nodo raíz y mostramos el resultado con
                // un mensaje en pantalla
                JOptionPane.showMessageDialog(null, arbol.mayorValor(A));
            }
        });

        //Acción del botón buscar nodo al ser presionado por el usuario
        this.btnBuscarNodo.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                //Creamos una variable llamada valor y le pasamos el valor que el usuario ingrese por medio del TextField
                int valor = Integer.parseInt(txtBuscarIngresar.getText());
                //Llamamos al método buscarNodo de la clase ArbolBinario
                if (arbol.buscarNodo(A,valor) == true){//Si el resultado es verdadero y el valor es encontrado
                    //muestra un mensaje en pantalla con el mensaje de que el valor "Fue Encontrado"
                    JOptionPane.showMessageDialog(null,  valor + " - Fue encontrado");
                }else {
                    //Si el valor no es encontrado en los nodos muestra un mensaje en pantalla
                    //indicándonos que el valor no ha sido encontrado.
                    JOptionPane.showMessageDialog(null,  valor + " - No encontrado");
                }

            }
        });

        //Acción del botón contar nodos al ser presionado por el usuario
        this.btnContarNodo.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                //Llamamos al método contarNodos de la clase ArbolBinario
                //y mostramos el resultado con un mensaje en pantalla
                JOptionPane.showMessageDialog(null, arbol.contarNodos(A));
            }
        });
    }
}

