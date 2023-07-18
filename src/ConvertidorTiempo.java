import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ConvertidorTiempo extends Grafica {
    JButton boton, boton1;

    double[] valoresTiempo = {
        60.0, 
        3600.0, 
        86400.0
    };
    static String[] nombresTiempo = {
    "Minuto",
     "Hora", 
     "Día"
    };


    public ConvertidorTiempo(String title) {
        super(title, nombresTiempo);
        colocarBotones();
    }

    protected void colocarBotones() {

        boton = new JButton();
        boton.setBounds(100, 300, 100, 25);
        boton.setText("Convertir");
        boton.setEnabled(true); // Permite cliquear el boton
        boton.setFont(new Font("Arial", Font.BOLD, 12));

        boton1 = new JButton();
        boton1.setBounds(280, 300, 70, 25);
        boton1.setFont(new Font("Arial", Font.BOLD, 12));
        boton1.setText("Atras");



        //Boton Convertir Funcionalidad
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ea) {

                double valor1 = valoresTiempo[lista1.getSelectedIndex()];
                double valor2 = valoresTiempo[lista2.getSelectedIndex()];
                /*
                 * Operacion de convercion y atrapar posible Exception
                 * por tratar de convertir letras.
                 */
                try {
                    double cantidad = Double.parseDouble(textobox.getText());
                    double resultado = (cantidad * valor1) / valor2;
                    Resultado.setText(String.valueOf(resultado));
                    

                    int respuesta = JOptionPane.showConfirmDialog(null,
                            "Este es el resultado de su conversión: " + resultado + " ¿Desea continuar?",
                            "Confirmación", JOptionPane.YES_NO_OPTION);

                    if (respuesta == JOptionPane.NO_OPTION) {
                        /* Aqui es donde programare el reinicion del programa */
                        System.exit(respuesta);

                    } else {

                        dispose();
                        MenuApp.main(monedas);

                    }

                } catch (Exception e) {
                    textobox.setText(" ");
                    JOptionPane.showMessageDialog(null, " Debe utilizar un valor valido ", "Alerta",
                            JOptionPane.OK_OPTION);
                }

            }
        });
        //Boton Atras funcionalidad.
        boton1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ea) {
                
                dispose();
                MenuApp.main(monedas);
                
            }
        });
        panel.add(boton);
        panel.add(boton1);
    }
}