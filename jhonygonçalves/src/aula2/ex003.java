package aula2;

import javax.swing.JOptionPane;

public class ex003 {

    public static void main(String[] args) {
        String nome = JOptionPane.showInputDialog("Digite seu nome");;
        JOptionPane.showMessageDialog(null, "Bem vindo " + nome);
    }
}
