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
    private JTextField idField;
    private JTextField nombreField;
    private JLabel sueldoLabel;
    private JButton actualizarButton;
    private JLabel misionLabel;
    private JLabel nivelLabel;
    private JTextField sueldoMod;
    private JLabel idLabel;
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

    Lista avengers = new Lista();

    Avenger aBuscado = null;


    public VentanaAvenger() {
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (e.getSource() == agregarButton) {
                        int id = Integer.parseInt(idField.getText());
                        String nombre = nombreField.getText();
                        int nivel = Integer.parseInt(nivelCombo.getSelectedItem().toString());
                        String misionAsignada = misionCombo.getSelectedItem().toString();
                        double pagoMensual = Double.parseDouble(sueldoField.getText());

                        if(avengers.buscarId(id) == null) {
                            avengers.setAvengers(id, nombre, misionAsignada, nivel, pagoMensual);
                            agregarArea.setText(avengers.mostrarAvengers());
                            borrarDatos();
                        } else {
                            JOptionPane.showMessageDialog(null, "El avenger ya existe");
                        }
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
                        int id = Integer.parseInt(idBuscarField.getText());

                        aBuscado = avengers.buscarId(id);
                        idBuscarField.setText("");

                        buscarArea.setText(aBuscado.toString());
                        idModLabel.setText(String.valueOf(aBuscado.getId()));
                        nombreModLabel.setText(aBuscado.getNombre());
                        misionModCombo.setSelectedItem(aBuscado.getMisionAsignada());
                        nivelModCombo.setSelectedItem(String.valueOf(aBuscado.getNivelPeligro()));
                        sueldoModField.setText(String.valueOf(aBuscado.getPagoMensual()));
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
                        String mision = misionModCombo.getSelectedItem().toString();
                        int nivel = Integer.parseInt(nivelModCombo.getSelectedItem().toString());
                        double pagoMensual = Double.parseDouble(sueldoModField.getText());

                        Avenger resultado = avengers.modificarDatos(aBuscado, mision, nivel, pagoMensual);
                        modificarArea.setText(resultado.toString());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Ingrese correctamente los parametros.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });


        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == actualizarButton) {
                    agregarArea.setText(avengers.getAvengers().toString());
                }
            }
        });
    }

    public void borrarDatos() {
        nombreField.setText("");
        misionCombo.setSelectedIndex(0);
        nivelCombo.setSelectedIndex(0);
        sueldoField.setText("");
        idField.setText("");
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
