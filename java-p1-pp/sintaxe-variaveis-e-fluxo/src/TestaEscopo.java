
public class TestaEscopo {
	public static void main(String[] args) {
		System.out.println("Testando condicionais");

		int idade = 20;
		int quantidadePessoas = 3;
		// boolean acompanhado = quantidadePessoas >= 2;

		boolean acompanhado;
		if (quantidadePessoas >= 2) {
			acompanhado = true;
		} else {
			acompanhado = false;
		}

		System.out.println("Valor de acompanhado = " + acompanhado);
		if (idade >= 18 && acompanhado) {
			System.out.println("Seja bem vindo");
		} else {
			System.out.println("Infelizmente você não pode entrar");
		}

		String texto = "vagner";
		final String valor1 = "vagner";
		switch (texto) {
		case "vagner0":
			System.out.println("switch0");
		case valor1:
			System.out.println("switch1");
		case "vagner2":
			System.out.println("switch2");

		default:
			System.out.println("switch-default");
		}

		Meses month = Meses.MARCH;
		var result = extracted(month);
		System.out.println(result);

	}

	private static Object extracted(Meses month) {
		var result = switch (month) {
		case JANUARY, JUNE, JULY -> "Vagner";
		case FEBRUARY, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER -> 1;
		case MARCH, MAY, APRIL, AUGUST -> {
			int monthLength = month.toString().length();
			yield monthLength * 4;
		}
		default -> 0;
		};
		
		int result2 = switch (month) {
		case JANUARY, JUNE, JULY : yield 0;
		case FEBRUARY, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER: yield 1;
		case MARCH, MAY, APRIL, AUGUST: {
			int monthLength = month.toString().length();
			yield monthLength * 4;
		}
		default: yield 0;
		};
		
	
		return result2;
	}

	enum Meses {
		JANUARY, JUNE, JULY, FEBRUARY, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER, MARCH, MAY, APRIL, AUGUST
	}
}
