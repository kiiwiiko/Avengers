import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAvenger {
    private JTabbedPane ventanaDividida;
    private JPanel panel1;
    private JPanel agregarPanel;
    private JPanel buscarPanel;
    private JButton agregarButton;
    private JTextArea agregarArea;
    private JComboBox nivelCombo;
    private JComboBox misionCombo;
    private JTextField nombreField;
    private JLabel sueldoLabel;
    private JLabel misionLabel;
    private JLabel nivelLabel;
    private JTextField sueldoMod;
    private JLabel nombreLabel;
    private JTextField idBuscarField;
    private JButton buscarButton;
    private JTextArea buscarArea;
    private JLabel idBuscarLabel;
    private JButton modificarButton;
    private JComboBox misionModCombo;
    private JComboBox nivelModCombo;
    private JTextArea modificarArea;
    private JTextField sueldoField;
    private JTextField sueldoModField;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel idModLabel;
    private JLabel nombreModLabel;
    private JPanel modificarPanel;
    private JTextArea informeArea;

    Lista avengers = new Lista();

    Avenger aBuscado = null;


    public VentanaAvenger() {
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (e.getSource() == agregarButton) {

                        //Tomamos los datos de los textField
                        String nombre = nombreField.getText();
                        int nivel = Integer.parseInt(nivelCombo.getSelectedItem().toString());
                        String misionAsignada = misionCombo.getSelectedItem().toString();
                        double pagoMensual = Double.parseDouble(sueldoField.getText());

                        //Agregamos el Avenger con los parametros ingresados
                        avengers.agregarAvengers(nombre, misionAsignada, nivel, pagoMensual);
                        //Mostramos cada avnger ingresado de manera ordenada
                        agregarArea.setText(avengers.mostrarAvengers());
                        borrarDatos();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese correctamente los parametros.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (e.getSource() == buscarButton) {
                            //Tomamos el id
                            int id = Integer.parseInt(idBuscarField.getText());

                            //Usamos la funcion para buscar el Avenger
                            aBuscado = avengers.buscarId(id);

                            //Se borra el campo al encotrar el Avenger
                            idBuscarField.setText("");

                            for(Avenger a : avengers.getAvengers()) {
                                if (a.getId() == id) {
                                    //Para ubicar los datos en el panel de modificar asi se ve mejor al momento de cabiar panel
                                    //Es mas intuitivo y rapido para el usuario
                                    idModLabel.setText(String.valueOf(aBuscado.getId()));
                                    nombreModLabel.setText(aBuscado.getNombre());
                                    misionModCombo.setSelectedItem(aBuscado.getMisionAsignada());
                                    nivelModCombo.setSelectedItem(String.valueOf(aBuscado.getNivelPeligro()));
                                    sueldoModField.setText(String.valueOf(aBuscado.getPagoMensual()));

                                    //Imprimer los datos del Avenger que fue encontrado
                                    buscarArea.setText(aBuscado.toString());
                                    informeArea.setText(aBuscado.mostrarInforme());
                                } else {
                                    JOptionPane.showMessageDialog(null, "El avenger " + id + " no existe.", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese correctamente los parametros.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == modificarButton) {
                    try {
                        //Obtengo cada parametro de el Avenger que voy a modificar
                        String mision = misionModCombo.getSelectedItem().toString();
                        int nivel = Integer.parseInt(nivelModCombo.getSelectedItem().toString());
                        double pagoMensual = Double.parseDouble(sueldoModField.getText());

                        //Dato resultado tipo Avenger para guardar la funcion modificar datos
                        Avenger resultado = avengers.modificarDatos(aBuscado, mision, nivel, pagoMensual);

                        //Actualiza los textArea de cada panel
                        modificarArea.setText("  Avenger Modificado\n\n" + resultado.toString() + aBuscado.mostrarInforme());
                        agregarArea.setText(avengers.mostrarAvengers());
                        informeArea.setText(aBuscado.mostrarInforme());

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Ingrese correctamente los parametros.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });


    }

    //Solo la ocupo una vez pero es para borrar los campos de ingresar
    public void borrarDatos() {
        nombreField.setText("");
        misionCombo.setSelectedIndex(0);
        nivelCombo.setSelectedIndex(0);
        sueldoField.setText("");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaAvenger");
        frame.setContentPane(new VentanaAvenger().panel1);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
