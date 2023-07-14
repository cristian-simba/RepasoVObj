import com.sun.source.tree.IfTree;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class registro {
    private JPanel registro;
    private JTextField marca;
    private JLabel vehiLabel;
    private JLabel marLabel;
    private JLabel veloLabel;
    private JTextField velocidad;
    private JLabel anioLabel;
    private JTextField anio;
    private JButton regBt;
    private JButton atrBt;
    private JButton sigBt;

    private ArrayList<Datos> listaDatos;
    private int ind;

    public registro() {
        listaDatos = new ArrayList<>();
        regBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String marcaIngreso = marca.getText();
                double velocidadIngreso = Double.parseDouble(velocidad.getText());
                int anioIngreso = Integer.parseInt(anio.getText());

                Datos ingreso = new Datos(marcaIngreso,velocidadIngreso,anioIngreso);
                listaDatos.add(ingreso);

                for(int i = 0; i < listaDatos.size(); i++){
                    String filePath = i + "datos.dat";
                    try(
                        FileOutputStream fileOut = new FileOutputStream(filePath);
                        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
                    ){
                        objOut.writeObject(ingreso);
                        System.out.println("Archivo guardado correctamente");
                    }
                    catch (IOException ex){
                        throw new RuntimeException(ex);
                    }

                }

                marca.setText("");
                velocidad.setText("");
                anio.setText("");

            }
        });
        sigBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ind < listaDatos.size()-1){
                    ind++;
                    Datos datos = listaDatos.get(ind);
                    marca.setText(datos.getMarca());
                    velocidad.setText(String.valueOf(datos.getVelocidad()));
                    anio.setText(String.valueOf(datos.getAnio()));
                }
            }
        });
        atrBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ind--;
                if(ind > 0){
                    Datos datos = listaDatos.get(ind);
                    marca.setText(datos.getMarca());
                    velocidad.setText(String.valueOf(datos.getVelocidad()));
                    anio.setText(String.valueOf(datos.getAnio()));
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Registro Vehículos");
        frame.setContentPane(new registro().registro);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
