# ENTREGA-3-VScode <br>
ENTREGA 3 VScode<br>
#Main Page<br>
import javax.swing.*;<br>
import java.awt.*;<br>
import java.awt.event.ActionEvent;<br>
import java.awt.event.ActionListener;<br>

public class MainPage extends JFrame {<br>

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
                    JOptionPane.showMessageDialog(null, "Correo ingresado correctamente: " + email);
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

    public static void main(String[] args) {
        // Ejecutar la interfaz gráfica
        SwingUtilities.invokeLater(() -> {
            MainPage frame = new MainPage();
            frame.setVisible(true);
        });
    }
}<br>

#VISITANTES <br>
import javax.swing.*;<br>
import java.awt.*;<br>

public class WhereInEAFIT extends JFrame {<br>

    public WhereInEAFIT() {
        // Configuración de la ventana principal
        setTitle("Where in EAFIT");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal con una disposición vertical
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(255, 228, 225)); // Fondo rosa claro

        // Título y descripción en la parte superior
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(255, 228, 225));
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        JLabel titleLabel = new JLabel("Where in EAFIT");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 32));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel welcomeLabel = new JLabel("<html><center>¡Bienvenido a Where in EAFIT para VISITANTES!<br>" +
                "Where in EAFIT es tu guía completa para navegar y descubrir todo lo que la Universidad EAFIT tiene para ofrecer.</center></html>");
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        headerPanel.add(titleLabel);
        headerPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre elementos
        headerPanel.add(welcomeLabel);

        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Panel central con las secciones
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(3, 4, 10, 10)); // Disposición de 3x4 para los bloques de contenido
        contentPanel.setBackground(new Color(255, 228, 225));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Crear los paneles de cada categoría con botones
        String[] categories = {
            "Bloques", "Zonas de descanso",
             "Restaurantes", 
            "Pago de parqueaderos", "Máquinas expendedoras", "Zonas de estudio", 
            "Otros puntos de interés", "Entradas Vehiculares","Entradas peatonales"
        };

        for (String category : categories) {
            JPanel categoryPanel = new JPanel();
            categoryPanel.setLayout(new BorderLayout());
            categoryPanel.setBackground(Color.WHITE);
            categoryPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            JLabel categoryLabel = new JLabel(category, SwingConstants.CENTER);
            categoryLabel.setFont(new Font("Arial", Font.BOLD, 14));

            JButton readMoreButton = new JButton("Read More");

            categoryPanel.add(categoryLabel, BorderLayout.CENTER);
            categoryPanel.add(readMoreButton, BorderLayout.SOUTH);

            contentPanel.add(categoryPanel);
        }

        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Agregar el panel principal al JFrame
        add(mainPanel);
    }

    public static void main(String[] args) {
        // Ejecutar la interfaz gráfica
        SwingUtilities.invokeLater(() -> {
            WhereInEAFIT frame = new WhereInEAFIT();
            frame.setVisible(true);
        });
    }
}<br>

#ESTUDIANTES<br>
package WIE;<br>
import javax.swing.*;<br>
import java.awt.*;<br>

public class WhereInEAFIT extends JFrame {<br>

    public WhereInEAFIT() {
        // Configuración de la ventana principal
        setTitle("Where in EAFIT");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal con una disposición vertical
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(255, 228, 225)); // Fondo rosa claro

        // Título y descripción en la parte superior
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(255, 228, 225));
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        JLabel titleLabel = new JLabel("Where in EAFIT");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 32));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel welcomeLabel = new JLabel("<html><center>¡Bienvenido a Where in EAFIT para ESTUDIANTES!<br>" +
                "Where in EAFIT es tu guía completa para navegar y descubrir todo lo que la Universidad EAFIT tiene para ofrecer.</center></html>");
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        headerPanel.add(titleLabel);
        headerPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre elementos
        headerPanel.add(welcomeLabel);

        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Panel central con las secciones
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(3, 4, 10, 10)); // Disposición de 3x4 para los bloques de contenido
        contentPanel.setBackground(new Color(255, 228, 225));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Crear los paneles de cada categoría con botones
        String[] categories = {
            "Bloques", "Zonas de descanso", "Monitoras",
             "Restaurantes", "Profesores", "Materias",
            "Pago de parqueaderos", "Máquinas expendedoras", "Zonas de estudio", 
            "Otros puntos de interés", "Entradas Vehiculares","Entradas peatonales"
        };

        for (String category : categories) {
            JPanel categoryPanel = new JPanel();
            categoryPanel.setLayout(new BorderLayout());
            categoryPanel.setBackground(Color.WHITE);
            categoryPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            JLabel categoryLabel = new JLabel(category, SwingConstants.CENTER);
            categoryLabel.setFont(new Font("Arial", Font.BOLD, 14));

            JButton readMoreButton = new JButton("Read More");

            categoryPanel.add(categoryLabel, BorderLayout.CENTER);
            categoryPanel.add(readMoreButton, BorderLayout.SOUTH);

            contentPanel.add(categoryPanel);
        }

        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Agregar el panel principal al JFrame
        add(mainPanel);
    }

    public static void main(String[] args) {
        // Ejecutar la interfaz gráfica
        SwingUtilities.invokeLater(() -> {
            WhereInEAFIT frame = new WhereInEAFIT();
            frame.setVisible(true);
        });
    }
}


