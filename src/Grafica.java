import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Grafica extends JFrame {

    private String titulo;
    public boolean ventana;
    JPanel panel;
    private String title;
    JLabel Resultado;
    JTextField textobox;
    JComboBox <String>lista1, lista2;
   JButton boton, boton1;

    String[] monedas;


    public Grafica(String title, String[] medidas) {
        this.monedas = medidas;
        // Para las dimenciones de la ventana.
        this.setSize(420, 400);
        this.setTitle(title);
        // Para que se cierre el programa al cerrar la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // centrar la ventana.
        this.setLocationRelativeTo(null);
        // this.getContentPane().setBackground(Color.BLACK);
        
        IniciarPanel();
        IniciarEtiquetas();
        colocarBotones();
        Colocartext();
        ColocarListasDesplegable(monedas);
    }

    
    protected void ColocarListasDesplegable(String[] Ar) {

        lista1 = new JComboBox<String>(Ar);
        lista1.setBounds(220, 120, 120, 30);
        panel.add(lista1);

        lista2 = new JComboBox<String>(Ar);

        lista2.setBounds(220, 190, 120, 30);

        panel.add(lista2);

        JLabel De = new JLabel("De: ");
        De.setBounds(220, 95, 120, 30);
        panel.add(De);

        JLabel A = new JLabel("A: ");
        A.setBounds(220, 165, 120, 30);
        panel.add(A);

    }
    

    protected void IniciarPanel() {
        panel = new JPanel(); // Crear panel.
        // Agregar panel a la ventana.
        this.getContentPane().add(panel);
        panel.setLayout(null);
        // Agregar color de panel.
        // panel.setBackground(Color.GRAY);
    }

    protected void IniciarEtiquetas() {
        JLabel Etiqueta = new JLabel(title, SwingConstants.CENTER);
        panel.add(Etiqueta);
        // posicion y proporcion del label
        Etiqueta.setBounds(10, 10, 400, 40);
        Etiqueta.setFont(new Font("Arial", Font.PLAIN, 30));
    }

    protected void colocarBotones() {

        boton = new JButton();
        boton.setBounds(150, 300, 100, 25);
        boton.setText("Convertir");
        boton.setEnabled(true); // Permite cliquear el boton
        boton.setFont(new Font("Arial", Font.BOLD, 12));
        boton.addActionListener(OyeAccion);
        panel.add(boton);

        boton1 = new JButton();
        boton1.setBounds(280, 300, 70, 25);
        boton1.setFont(new Font("Arial", Font.BOLD, 12));
        boton1.setText("Atras");
        boton1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ea) {
                
                dispose();
                MenuApp.main(monedas);
            }
        });
        panel.add(boton1);

    }

    protected void Colocartext() {
        JLabel text = new JLabel("Cantidad:");
        text.setBounds(60, 95, 120, 30);
        panel.add(text);
        textobox = new JTextField();
        textobox.setBounds(60, 120, 120, 30);
        // Para obtener el texto en la caja solo llamamos a GetText
        panel.add(textobox);

        JLabel listo = new JLabel("Resultado ");
        listo.setBounds(60, 175, 120, 30);
        panel.add(listo);

        Resultado = new JLabel(" ");
        Resultado.setBounds(60, 190, 120, 40);
        panel.add(Resultado);

    }
    ActionListener OyeAccion = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ea){
            Resultado.setText(textobox.getText());
        }
    };
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
