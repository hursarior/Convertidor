import javax.swing.*;

public class MenuApp {
    public static void main(String[] args) {

        // Opciones para el menú desplegable

        String[] opciones = { 
            "Convertidor Moneda", 
            "Convertidor de Longitud",
            "Convertidor de Volumen",
            "Convertidor de Peso",
            "Convertidor de Tiempo",
            "Convertidor de Area"
        };

       // Mostrar el cuadro de diálogo de entrada con el menú desplegable
       
        String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción", "Conversores",
                JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        if (seleccion.equals("Convertidor Moneda")) {
            System.out.println("Seleccionaste: " + seleccion);
            
            ConvertidorMoneda In = new ConvertidorMoneda(seleccion);
                In.setVisible(true);
            
        } else if (seleccion.equals("Convertidor de Longitud")) {
            System.out.println("Seleccionaste: " + seleccion);
            ConvertidorLongitud In = new ConvertidorLongitud(seleccion);
                In.setVisible(true);

        } else if(seleccion.equals("Convertidor de Volumen")){
            System.out.println("Seleccionaste: " + seleccion);
            ConvertidorVolumen In = new ConvertidorVolumen(seleccion);
            In.setVisible(true);
            // ...
        }else if(seleccion.equals("Convertidor de Peso")){
            System.out.println("Seleccionaste: " + seleccion);
            ConvertidorPeso In = new ConvertidorPeso(seleccion);
            In.setVisible(true);

        } else if(seleccion.equals("Convertidor de Tiempo")){
            System.out.println("Seleccionaste: " + seleccion);
            ConvertidorTiempo In = new ConvertidorTiempo(seleccion);
            In.setVisible(true);

        }else if(seleccion.equals("Convertidor de Area")){
            System.out.println("Seleccionaste: " + seleccion);
            ConvertidorArea In = new ConvertidorArea(seleccion);
            In.setVisible(true);

        }
         
    }
}