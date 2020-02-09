
public class TestaConversao {

	public static void main(String[] args) {
		double salario = 1270.50F;
		Double salario2 = 1270.50;
		
		int valor = (int) salario;
		int valor3 = (int) salario2.longValue();
		
		System.out.println(valor);
		System.out.println(valor3);
		
		long numeroGrande = 23434234234343L;
		short valorPequeno = 22244;
		
		byte b = 127;
		
		int x = 127;
		byte y = (byte) x;
		
		double valor1 = 0.2;
		double valor2 = 0.1;
		double total = valor1 + valor2;
		System.out.println(total);
		
		

	}

}
