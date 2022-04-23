package com.editordetexto.principal;

import org.imgscalr.Scalr;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class TabTexto extends JPanel {

    private JComboBox<String> fuentes;
    private JComboBox<String> tamanios;
    private JButton color;
    private JButton negrita, cursiva, subrayado, tachado, supindice, subindice;
    private JButton izquierda, centrado, derecha, justificado;
    private JButton crearEnlace, quitarEnlace;
    private JButton aMayuscula, aMinuscula, capitalizar, invertir;
    public TabTexto() {
        setLayout(new GridBagLayout());

        inicializarIU();
    }

    private void inicializarIU() {
        //Inicio del código de las opciones de fuente de texto
        fuentes = new JComboBox<String>();
        fuentes.addItem("Times New Roman");
        fuentes.addItem("Open Sans");
        tamanios = new JComboBox<String>();
        tamanios.addItem("10");
        tamanios.addItem("12");
        color = new JButton();
        color.setBackground(Color.RED);
        //Hace que el botón sea cuadrado con un tamaño adecuado
        color.setPreferredSize(new Dimension(34, 34));
        //Fin del código de las opciones de fuente de texto

        //Inicio del código de los botones de decoración de texto
        String htmlNegrita = "<html><center><b>N</b>";
        negrita = new JButton(htmlNegrita);
        String htmlCursiva = "<html><center><i>C</i>";
        cursiva = new JButton(htmlCursiva);
        String htmlSubrayado = "<html><center><u>S</u>";
        subrayado = new JButton(htmlSubrayado);
        String htmlTachado = "<html><center><strike>T</strike>";
        tachado = new JButton(htmlTachado);
        String htmlSuperindice = "<html><center>A<sup>i</sup>";
        supindice = new JButton(htmlSuperindice);
        String htmlSubindice = "<html><center>A<sub>i</sub>";
        subindice = new JButton(htmlSubindice);
        //Fin del código de los botones de decoración de texto

        //Inicio del código de los botones de alineación de texto
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("res/left-align.png"));
            img = Scalr.resize(img, 16);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ImageIcon icon = new ImageIcon(img);
        izquierda = new JButton(icon);

        img = null;
        try {
            img = ImageIO.read(new File("res/center-align.png"));
            img = Scalr.resize(img, 16);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        icon = new ImageIcon(img);
        centrado = new JButton(icon);

        img = null;
        try {
            img = ImageIO.read(new File("res/right-align.png"));
            img = Scalr.resize(img, 16);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        icon = new ImageIcon(img);
        derecha = new JButton(icon);

        img = null;
        try {
            img = ImageIO.read(new File("res/justification.png"));
            img = Scalr.resize(img, 16);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        icon = new ImageIcon(img);
        justificado = new JButton(icon);
        //Fin del código de los botones de alineación de texto

        //Inicio del código de botones de enlaces
        crearEnlace = new JButton("Crear enlace");
        quitarEnlace = new JButton("Eliminar enlace");

        //Inicio del código de colocación de opciones de fuente de texto
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        add(new JLabel("Fuente: "), c);

        //Inicio del código de los botones para mayúsculas y minúsculas
        aMayuscula = new JButton("m -> M");
        aMinuscula = new JButton("M -> m");
        capitalizar = new JButton("Capitalizar");
        invertir = new JButton("Invertir");
        //Fin del código de los botones para mayúsculas y minúsculas

        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        add(fuentes, c);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        add(new JLabel("Tamaño: "), c);

        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LINE_START;
        add(tamanios, c);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        add(new JLabel("Color: "), c);

        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(5, 0, 5, 0);
        c.anchor = GridBagConstraints.LINE_START;
        add(color, c);
        //Fin del código de colocación de opciones de fuente de texto

        //Inicio del código colocación de botones de decoración de texto
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 0;
        c.insets = new Insets(0, 5, 0, 0);
        add(negrita, c);

        c = new GridBagConstraints();
        c.gridx = 3;
        c.gridy = 0;
        c.insets = new Insets(0, 5, 0, 0);
        add(cursiva, c);

        c = new GridBagConstraints();
        c.gridx = 4;
        c.gridy = 0;
        c.insets = new Insets(0, 5, 0, 0);
        add(subrayado, c);

        c = new GridBagConstraints();
        c.gridx = 5;
        c.gridy = 0;
        c.insets = new Insets(0, 5, 0, 0);
        add(tachado, c);

        c = new GridBagConstraints();
        c.gridx = 6;
        c.gridy = 0;
        c.insets = new Insets(0, 5, 0, 0);
        add(supindice, c);

        c = new GridBagConstraints();
        c.gridx = 7;
        c.gridy = 0;
        c.insets = new Insets(0, 5, 0, 0);
        add(subindice, c);
        //Fin del código de colocación de botones de decoración de texto

        //Inicio del código de colocación de botones de alineación de texto
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 1;
        c.insets = new Insets(0, 20, 0, 0);
        add(izquierda, c);

        c = new GridBagConstraints();
        c.gridx = 3;
        c.gridy = 1;
        c.insets = new Insets(0, 5, 0, 0);
        add(centrado, c);

        c = new GridBagConstraints();
        c.gridx = 4;
        c.gridy = 1;
        c.insets = new Insets(0, 5, 0, 0);
        add(derecha, c);

        c = new GridBagConstraints();
        c.gridx = 5;
        c.gridy = 1;
        c.insets = new Insets(0, 5, 0, 0);
        add(justificado, c);
        //Fin del código de colocación de botones de alineación de texto

        //Inicio del código de colocación de botones de enlace
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 2;
        c.gridwidth = 2;
        add(crearEnlace, c);

        c = new GridBagConstraints();
        c.gridx = 4;
        c.gridy = 2;
        c.gridwidth = 2;
        add(quitarEnlace, c);
        //Fin del código de colocación de botones de enlace

        //Inicio del código de colocación de los botones de mayúsculas y minúsculas
        c = new GridBagConstraints();
        c.gridx = 8;
        c.gridy = 0;
        c.gridwidth = 2;
        c.insets = new Insets(0, 5, 0, 0);
        add(aMayuscula, c);

        c = new GridBagConstraints();
        c.gridx = 8;
        c.gridy = 1;
        c.gridwidth = 2;
        c.insets = new Insets(0, 5, 0, 0);
        add(aMinuscula, c);

        c = new GridBagConstraints();
        c.gridx = 10;
        c.gridy = 0;
        c.gridwidth = 2;
        c.insets = new Insets(0, 5, 0, 0);
        add(capitalizar, c);

        c = new GridBagConstraints();
        c.gridx = 10;
        c.gridy = 1;
        c.gridwidth = 2;
        c.insets = new Insets(0, 5, 0, 0);
        c.fill = GridBagConstraints.HORIZONTAL;
        add(invertir, c);
        //Fin del código de colocación de los botones de mayúsculas y minúsculas
    }

}
