package com.editordetexto.principal;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders;

public class Ventana extends JFrame {

    //Atributos para la barra de menú
    private JMenuBar barraMenu;
    private JMenu menuArchivo, menuEditar, menuSobre;
    private JMenuItem itemArchivoAbrir, itemArchivoGuardar, itemArchivoGuardarComo,
                        itemArchivoCerrarDocumento, itemArchivoCerrarPrograma;

    private JMenu itemArchivoRecientes;
    private JMenuItem itemEditarBuscar, itemEditarBuscarYReemplazar;
    private JMenuItem itemSobrePrograma, itemSobreAutor;

    //Atributos para la barra de herramientas
    private JTabbedPane contenedorHerramientas;
    private TabTexto tabTexto;

    //Atributos para el área de trabajo
    private JScrollPane scrollContenedorPagina;
    private JPanel contenedorPagina;
    private JTextArea pagina;

    //Atributos de la barra inferior
    private JPanel barraInferior;
    private JPanel barraInferiorContenedorPalabras;
    private JLabel barraInferiorPalabras, barraInferiorPalabrasTotal, barraInferiorRenglon;

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
    }
    public Ventana() {
        setTitle("Editor de texto");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inicializarIU();
        pack();
        setVisible(true);
    }

    private void inicializarIU() {
        setLayout(new BorderLayout());

        //Inicio del código de la barra de menú
        barraMenu = new JMenuBar();
        menuArchivo = new JMenu("Archivo");
        menuEditar = new JMenu("Editar");
        menuSobre = new JMenu("Sobre");
        barraMenu.add(menuArchivo);
        barraMenu.add(menuEditar);
        barraMenu.add(menuSobre);

        itemArchivoAbrir = new JMenuItem("Abrir");
        itemArchivoGuardar = new JMenuItem("Guardar");
        itemArchivoGuardarComo = new JMenuItem("Guardar como...");
        itemArchivoCerrarDocumento = new JMenuItem("Cerrar documento actual");
        itemArchivoRecientes = new JMenu("Documentos recientes");
        itemArchivoCerrarPrograma = new JMenuItem("Cerrar el programa");
        menuArchivo.add(itemArchivoAbrir);
        menuArchivo.add(itemArchivoGuardar);
        menuArchivo.add(itemArchivoGuardarComo);
        menuArchivo.add(itemArchivoCerrarDocumento);
        menuArchivo.add(itemArchivoRecientes);
        menuArchivo.add(itemArchivoCerrarPrograma);

        itemEditarBuscar = new JMenuItem("Buscar");
        itemEditarBuscarYReemplazar = new JMenuItem("Buscar y reemplazar");
        menuEditar.add(itemEditarBuscar);
        menuEditar.add(itemEditarBuscarYReemplazar);

        itemSobrePrograma = new JMenuItem("Programa");
        itemSobreAutor = new JMenuItem("Autor");
        menuSobre.add(itemSobrePrograma);
        menuSobre.add(itemSobreAutor);

        setJMenuBar(barraMenu);
        //Fin del código de la barra de menú

        //Inicio del código de la barra de herramientas
        contenedorHerramientas = new JTabbedPane();
        tabTexto = new TabTexto();
        contenedorHerramientas.add("Texto", tabTexto);

        add(contenedorHerramientas, BorderLayout.NORTH);
        //Fin del código de la barra de herramientas

        //Inicio del código para el área de trabajo
        scrollContenedorPagina = new JScrollPane();
        contenedorPagina = new JPanel();
        contenedorPagina.setLayout(new BorderLayout());
        contenedorPagina.setBorder(new EmptyBorder(20, 40, 20, 40));
        pagina = new JTextArea();
        pagina.setLineWrap(true);
        contenedorPagina.add(pagina, BorderLayout.CENTER);
        scrollContenedorPagina.setViewportView(contenedorPagina);
        add(scrollContenedorPagina, BorderLayout.CENTER);
        //Fin del código para el área de trabajo

        //Inicio del código para la barra inferior
        barraInferior = new JPanel();
        barraInferior.setLayout(new BorderLayout());
        barraInferiorContenedorPalabras = new JPanel();
        barraInferiorPalabras = new JLabel("Palabras: ");
        barraInferiorPalabrasTotal = new JLabel("Palabras en total: ");
        barraInferiorRenglon = new JLabel(("Renglón actual: "));
        barraInferiorContenedorPalabras.add(barraInferiorPalabras);
        barraInferiorContenedorPalabras.add(barraInferiorPalabrasTotal);
        barraInferior.add(barraInferiorContenedorPalabras, BorderLayout.WEST);
        barraInferior.add(barraInferiorRenglon, BorderLayout.EAST);
        add(barraInferior, BorderLayout.SOUTH);
        //Fin del código para la barra inferior
    }

}
