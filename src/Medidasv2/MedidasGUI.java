/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Medidasv2;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author WIN 10
 */
public class MedidasGUI {
    private JFrame frame;
    private JComboBox<String> comboTipo, comboOrigen, comboDestino;
    private JTextField textValor, textResultado;
    private JButton botonConvertir;

    public MedidasGUI() {
        frame = new JFrame("Conversor de Medidas");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel labelTipo = new JLabel("Tipo de medida:");
        labelTipo.setBounds(10, 10, 120, 25);
        frame.add(labelTipo);

        comboTipo = new JComboBox<>(new String[]{"Distancia", "Volumen", "Peso"});
        comboTipo.setBounds(140, 10, 120, 25);
        frame.add(comboTipo);
        comboTipo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarCombos();
            }
        });

        JLabel labelOrigen = new JLabel("Unidad de origen:");
        labelOrigen.setBounds(10, 50, 120, 25);
        frame.add(labelOrigen);

        comboOrigen = new JComboBox<>();
        comboOrigen.setBounds(140, 50, 120, 25);
        frame.add(comboOrigen);

        JLabel labelDestino = new JLabel("Unidad de destino:");
        labelDestino.setBounds(10, 90, 120, 25);
        frame.add(labelDestino);

        comboDestino = new JComboBox<>();
        comboDestino.setBounds(140, 90, 120, 25);
        frame.add(comboDestino);

        JLabel labelValor = new JLabel("Valor a convertir:");
        labelValor.setBounds(10, 130, 120, 25);
        frame.add(labelValor);

        textValor = new JTextField();
        textValor.setBounds(140, 130, 120, 25);
        frame.add(textValor);

        botonConvertir = new JButton("Convertir");
        botonConvertir.setBounds(140, 170, 120, 25);
        frame.add(botonConvertir);
        botonConvertir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertirMedida();
            }
        });

        JLabel labelResultado = new JLabel("Resultado:");
        labelResultado.setBounds(10, 210, 120, 25);
        frame.add(labelResultado);

        textResultado = new JTextField();
        textResultado.setBounds(140, 210, 120, 25);
        textResultado.setEditable(false);
        frame.add(textResultado);

        actualizarCombos();
        frame.setVisible(true);
    }

    private void actualizarCombos() {
        String tipo = (String) comboTipo.getSelectedItem();
        comboOrigen.removeAllItems();
        comboDestino.removeAllItems();

        if ("Distancia".equals(tipo)) {
            comboOrigen.addItem("Metros");
            comboOrigen.addItem("Kilómetros");
            comboOrigen.addItem("Millas");
            comboOrigen.addItem("Pies");

            comboDestino.addItem("Metros");
            comboDestino.addItem("Kilómetros");
            comboDestino.addItem("Millas");
            comboDestino.addItem("Pies");
        } else if ("Volumen".equals(tipo)) {
            comboOrigen.addItem("Litros");
            comboOrigen.addItem("Mililitros");
            comboOrigen.addItem("Galones");

            comboDestino.addItem("Litros");
            comboDestino.addItem("Mililitros");
            comboDestino.addItem("Galones");
        } else if ("Peso".equals(tipo)) {
            comboOrigen.addItem("Kilogramos");
            comboOrigen.addItem("Gramos");
            comboOrigen.addItem("Libras");

            comboDestino.addItem("Kilogramos");
            comboDestino.addItem("Gramos");
            comboDestino.addItem("Libras");
        }
    }

    private void convertirMedida() {
        String tipo = (String) comboTipo.getSelectedItem();
        String unidadOrigen = (String) comboOrigen.getSelectedItem();
        String unidadDestino = (String) comboDestino.getSelectedItem();
        double valor = Double.parseDouble(textValor.getText());
        double resultado = 0;

        if ("Distancia".equals(tipo)) {
            resultado = Conversor.convertirDistancia(valor, unidadOrigen, unidadDestino);
        } else if ("Volumen".equals(tipo)) {
            resultado = Conversor.convertirVolumen(valor, unidadOrigen, unidadDestino);
        } else if ("Peso".equals(tipo)) {
            resultado = Conversor.convertirPeso(valor, unidadOrigen, unidadDestino);
        }

        textResultado.setText(String.valueOf(resultado));
    }

    public static void main(String[] args) {
        new MedidasGUI();
    }
}

    

