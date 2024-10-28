//package WIE;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WIE_Visitantes extends JFrame {

    public WIE_Visitantes() {
        // Configuración de la ventana principal
        setTitle("WhereInEAFIT");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal con una disposición vertical
        JPanel mainPanel = new JPanel(new BorderLayout());
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
            readMoreButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (category.equals("Entradas Vehiculares")) {
                        VehicleEntryInfoWindow infoWindow = new VehicleEntryInfoWindow();
                        infoWindow.setVisible(true);
                    } else if (category.equals("Pago de parqueaderos")) {
                        ParkingPaymentInfoWindow infoWindow = new ParkingPaymentInfoWindow();
                        infoWindow.setVisible(true);
                    }
                }
            });

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
            WIE_Visitantes frame = new WIE_Visitantes();
            frame.setVisible(true);
        });
    }
}

class VehicleEntryInfoWindow extends JFrame {
    public VehicleEntryInfoWindow() {
        setTitle("Porteria de ingreso vehicular instituto del plastico y caucho");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea infoTextArea = new JTextArea("Porteria de ingreso vehicular instituto del plastico y caucho \n" +
                "Horario de atención:\n" +
                "Lunes a viernes: 5:00 a.m. a 10:30 p.m.\n" +
                "Sábados: 6:00 a.m. a 6:00 p.m.\n" +
                "Domingos y festivos: Cerrado\n" +
                " \n" +
                "Porteria vehicular edificio de ingenierias \n" +
                "Horario de atención:\n" +
                "Lunes a viernes: 5:00 a.m. a 10:30 p.m.\n" +
                "Sábados: 6:00 a.m. a 6:00 p.m.\n" +
                "Domingos y festivos: Cerrado\n"
        );
        infoTextArea.setEditable(false);
        infoTextArea.setLineWrap(true);
        infoTextArea.setWrapStyleWord(true);

        add(new JScrollPane(infoTextArea));
    }
}

class ParkingPaymentInfoWindow extends JFrame {
    public ParkingPaymentInfoWindow() {
        setTitle("Información de Pago de Parqueaderos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea infoTextArea = new JTextArea("Información sobre el pago de parqueaderos:\n" +
                "1. Puedes pagar en las máquinas expendedoras ubicadas en los edificios principales.\n" +
                "Bloque 20 \n"+
                "Bloque 18 \n"+
                "Bloque 38 \n"+
                "Bloque 33\n"
                );
        infoTextArea.setEditable(false);
        infoTextArea.setLineWrap(true);
        infoTextArea.setWrapStyleWord(true);

        add(new JScrollPane(infoTextArea));
    }
}
