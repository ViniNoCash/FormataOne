import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class FormatadorCash extends JFrame {

    public FormatadorCash() {
        setTitle("FormataOne by Vininocash");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        JPanel painel = new JPanel(new GridLayout(7, 1, 3, 7));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        JLabel label = new JLabel("Digite o CPF/CNPJ:");
        JButton botao = new JButton("Formatar");
        JTextField campo = new JTextField(20);
        JTextField resultado = new JTextField(20);
        resultado.setEditable(false);
        JButton botao2 = new JButton("Limpar");
        JLabel label2 = new JLabel("");
        label2.setForeground(Color.BLUE);

        botao.addActionListener(e -> {
            String texto = campo.getText();
            String apenasNumeros = texto.replaceAll("[^0-9]", "");
            resultado.setText(apenasNumeros);
            StringSelection selection = new StringSelection(apenasNumeros);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
            label2.setText("✔ Copiado!");
        });


        botao2.addActionListener(e -> {
            campo.setText("");
            resultado.setText("");
            label2.setText("");
            campo.requestFocus();
        });

        painel.add(label);
        painel.add(campo);
        painel.add(botao);
        painel.add(new JLabel("Resultado: "));
        painel.add(resultado);
        painel.add(botao2);
        painel.add(label2);

        add(painel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FormatadorCash janela = new FormatadorCash();
            janela.setVisible(true);
        });
    }
}