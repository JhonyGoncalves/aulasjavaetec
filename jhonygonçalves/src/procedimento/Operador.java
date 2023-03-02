package procedimento;
import javax.swing.JOptionPane;
public class Operador {
   void soma() {
       int a = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro valor"));
       int b = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo valor"));
       int soma = a + b;
       JOptionPane.showMessageDialog(null, "O valor da soma é: " + soma);
   } 
   
   void subtracao() {
       int a = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro valor"));
       int b = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo valor"));
       int subt = a - b;
       JOptionPane.showMessageDialog(null, "O valor da subtração é: " + subt);
       
   }
   
   void divisao() {
       int a = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro valor"));
       int b = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo valor"));
       int divi = a / b;
       JOptionPane.showMessageDialog(null, "O valor da divisão é: " + divi);
       
   }
}
