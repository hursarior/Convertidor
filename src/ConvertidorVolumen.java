import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ConvertidorVolumen extends Grafica {
    JButton boton, boton1;

    static String[] nombresVolumen = {"Litro", "Metro cúbico", "Mililitro", "Kilómetro cúbico", "Pulgada cúbica", "Pie cúbico"};
double[] valoresVolumen = {1.0, 1000.0, 0.001, 1000000.0, 16.387, 28.3168};

    public ConvertidorVolumen(String title) {
        super(title, nombresVolumen);
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

                double valor1 = valoresVolumen[lista1.getSelectedIndex()];
                double valor2 = valoresVolumen[lista2.getSelectedIndex()];
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