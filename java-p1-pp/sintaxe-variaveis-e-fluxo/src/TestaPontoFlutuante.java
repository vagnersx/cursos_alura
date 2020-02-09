
public class TestaPontoFlutuante {
    public static void main(String args[]) {
        double salario;
        salario = 1250.70;
        System.out.println(salario);
        
        double idade = 0;
        double divisao = 3.14 /2;
        System.out.println(divisao);
       
        System.out.println("" + idade);
        System.out.println(TestaPontoFlutuante.idade);

        
        int outraDivisao = 5 / 2;
        System.out.println(outraDivisao);
        
        double novaTentativa = (double) (5 / 2);
        System.out.println(novaTentativa);
        
        novaTentativa = (double) 5 / 2;
        System.out.println(novaTentativa);
        
        novaTentativa = 5 / 2.0;
        System.out.println(novaTentativa);
        
     }
    
    static int idade;
}
