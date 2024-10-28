//package WIE;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame {

    public MainPage() {
        // Configuración de la ventana principal
        setTitle("Where in EAFIT");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal con disposición vertical
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(255, 228, 225)); // Fondo rosa claro

        // Título de la aplicación
        JLabel titleLabel = new JLabel("WHERE IN EAFIT");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Espacio arriba del título
        mainPanel.add(titleLabel);

        // Campo de texto para ingresar el correo
        JLabel emailLabel = new JLabel("Ingrese su correo:");
        emailLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField emailField = new JTextField(20);
        emailField.setMaximumSize(new Dimension(300, 30)); // Tamaño máximo del campo de texto

        // Agregar los componentes al panel principal
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Espacio entre elementos
        mainPanel.add(emailLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre etiqueta y campo de texto
        mainPanel.add(emailField);

        // Botón para enviar el correo
        JButton submitButton = new JButton("Enviar");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Espacio entre campo de texto y botón
        mainPanel.add(submitButton);

        // Acción al presionar el botón
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                if (isValidEmail(email)) {
                    if (email.contains("eafit")) {
                        redirectToWIEEstudiantes();
                    } else {
                        redirectToWIEVisitantes();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un correo válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Agregar el panel principal al JFrame
        add(mainPanel);
    }

    // Método para validar el formato de un correo electrónico simple
    private boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    // Método para redirigir a WIE_estudiantes
    private void redirectToWIEEstudiantes() {
        WIE_Estudiantes estudiantesFrame = new WIE_Estudiantes();
        estudiantesFrame.setVisible(true);
        this.dispose(); // Cerrar la ventana actual
    }

    // Método para redirigir a WIE_visitantes
    private void redirectToWIEVisitantes() {
        WIE_Visitantes visitantesFrame = new WIE_Visitantes();
        visitantesFrame.setVisible(true);
        this.dispose(); // Cerrar la ventana actual
    }

    public static void main(String[] args) {
        // Ejecutar la interfaz gráfica
        SwingUtilities.invokeLater(() -> {
            MainPage frame = new MainPage();
            frame.setVisible(true);
        });
    }
}
