// LoteriaGUI.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class LoteriaGUI extends JFrame {
    private Random random = new Random();

    public LoteriaGUI() {
        setTitle("LOTOFÁCIL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel label = new JLabel("Escolha o tipo de aposta:");
        add(label);

        String[] options = {"De 0 a 100", "De A à Z", "Par ou Ímpar"};
        JComboBox<String> choiceBox = new JComboBox<>(options);
        add(choiceBox);

        JButton button = new JButton("Apostar");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String option = (String) choiceBox.getSelectedItem();
                switch (option) {
                    case "De 0 a 100":
                        apostarDe0a100();
                        break;
                    case "De A à Z":
                        apostarDeAaZ();
                        break;
                    case "Par ou Ímpar":
                        apostarParOuImpar();
                        break;
                }
            }
        });
        add(button);

        pack();
        setLocationRelativeTo(null);
    }

    private void apostarDe0a100() {
        String input = JOptionPane.showInputDialog("Digite um número de 0 a 100:");
        if (input == null) return; // Cancel button pressed

        int numeroApostado;
        try {
            numeroApostado = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Aposta inválida. Digite um número válido.");
            return;
        }

        int numeroSorteado = random.nextInt(101);

        if (numeroApostado == numeroSorteado) {
            JOptionPane.showMessageDialog(this, "Você ganhou R$ 1.000,00 reais.");
        } else {
            JOptionPane.showMessageDialog(this, "Que pena! O número sorteado foi: " + numeroSorteado + ".");
        }
    }

    private void apostarDeAaZ() {
        String input = JOptionPane.showInputDialog("Digite uma letra de A à Z:");
        if (input == null || input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            JOptionPane.showMessageDialog(this, "Aposta inválida. Digite uma única letra de A à Z.");
            return;
        }

        char letraApostada = Character.toUpperCase(input.charAt(0));
        char letraPremiada = 'G'; // Letra premiada definida como 'G' 

        if (letraApostada == letraPremiada) {
            JOptionPane.showMessageDialog(this, "Você ganhou R$ 500,00 reais.");
        } else {
            JOptionPane.showMessageDialog(this, "Que pena! A letra premiada era: " + letraPremiada + ".");
        }
    }

    private void apostarParOuImpar() {
        String input = JOptionPane.showInputDialog("Digite um número inteiro:");
        if (input == null) return; // Cancel button pressed

        int numeroApostado;
        try {
            numeroApostado = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Aposta inválida. Digite um número inteiro válido.");
            return;
        }

        int numeroSorteado = random.nextInt(101);

        if ((numeroApostado % 2 == 0 && numeroSorteado % 2 == 0) || (numeroApostado % 2 != 0 && numeroSorteado % 2 != 0)) {
            JOptionPane.showMessageDialog(this, "Você ganhou R$ 200,00 reais.");
        } else {
            JOptionPane.showMessageDialog(this, "Que pena! O número sorteado foi: " + numeroSorteado + ".");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoteriaGUI().setVisible(true);
            }
        });
    }
}


