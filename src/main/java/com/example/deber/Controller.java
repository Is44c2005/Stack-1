package com.example.deber;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.*;


public class Controller {
    public Button btnRegistrar;
    public Button btnEliminar;
    public Button btnPeek;
    @FXML
    private TextArea txtMensaje;
    @FXML
    private TextArea txtMostrar;
    @FXML
    private TextField txtCodigo;
    @FXML
    private TextField txtTitulo;

    Pila pila= new Pila();
    @FXML
    protected void Click() {
        if(txtCodigo.getText().isEmpty() || txtTitulo.getText().isEmpty() || txtMensaje.getText().isEmpty()){

            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos antes de registrar");
            return;
        }

        if (!txtCodigo.getText().matches("\\d+")){
            JOptionPane.showMessageDialog(null, "El codigo debe ser numeros enteros positvos");
            return;
        }



        String mensaje= txtMensaje.getText().trim();
        int codigo= Integer.parseInt(txtCodigo.getText().trim());
        String titulo=txtTitulo.getText().trim();
        Publicacion p= new Publicacion(codigo, titulo, mensaje);
        pila.push(p);
        txtMostrar.setText(pila.toString());
        txtMensaje.clear();
        txtCodigo.clear();
        txtTitulo.clear();

    }
    @FXML
    protected void onClick(){
        try {
            pila.pop();
            txtMostrar.setText(pila.toString());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "La pila está vacía, no se puede eliminar");
        }

    }

    @FXML
    protected void onPeek(){
        try {

            Publicacion ultima = pila.peek();
            txtMostrar.setText("Peek\n" + String.valueOf(ultima));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "La pila está vacía, no hay archivos por ver");;
        }
    }

}