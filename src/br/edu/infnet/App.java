package br.edu.infnet;
import java.util.Scanner;

public class App {

	private static String[] nomes;
	private static float[] notasAV1;
	private static float[] notasAV2;
	private static float[] mediasFinais;
	private static String[] situacoes;

	private static int qtde = 0;
	private static final int QTDE_MAX = 100;

	private static void impressao(){
		System.out.println("---- Relatório de Alunos ----");

		for (int j = 0; j < qtde; j++) {
			impressao(j);
		}
		System.out.println("-----------------------------------");
	}

	private static float calcularMediasFinais(int index){
		return ((notasAV1[index] + notasAV2[index])/ 2);
	}

	private static String obterSituacao(float media){
		if (media >= 7) {
			return ("Aprovado");
		}else if(media < 7 || media >= 4){
			return ("Prova final");
		}else{
			return("Reprovado");
		}
	}

	private static void impressao(int index){		

		System.out.println( index + " - Nome do aluno: " + nomes[index]);
		System.out.println("Nota da AV1: " + notasAV1[index]);
		System.out.println("Nota da AV2: " + notasAV2[index]);
		System.out.println("Média final: " + mediasFinais[index]);
		System.out.println("Situação: " + situacoes[index]);  
	}

	public static void main(String[] args){

		nomes = new String[QTDE_MAX];
		notasAV1 = new float[QTDE_MAX];
		notasAV2 = new float[QTDE_MAX];
		mediasFinais = new float[QTDE_MAX];
		situacoes = new String[QTDE_MAX];

		int opcao = 0;		

		Scanner in = new Scanner(System.in);

		do {
			System.out.println("[1] Registrar as notas de um novo aluno");
			System.out.println("[2] Consultar boletim de um aluno");
			System.out.println("[3] Consultar notas da tuma");
			System.out.println("[4] Sair");
			System.out.print("Informe a opção desejada: ");
			opcao = in.nextInt();
			switch (opcao) {
			case 1:
				if(qtde < QTDE_MAX) {
					System.out.print("Informe o nome do aluno: ");
					nomes[qtde] = in.next();
					
					System.out.print("Informe a sua Nota da AV1: ");
					notasAV1[qtde] = in.nextFloat();
					
					System.out.print("Informe o sua Nota da AV2: ");
					notasAV2[qtde] = in.nextFloat();

					mediasFinais[qtde] = calcularMediasFinais(qtde);

					situacoes[qtde] = obterSituacao(mediasFinais[qtde]);

					impressao(qtde);

					qtde++;
				} else {
					System.out.println("Impossível realizar o cadastramento!!!");
				}
				break;
			case 2:
				System.out.println("Informe a matrícula do aluno: ");
				int matricula = in.nextInt();

				if(matricula >= 0 && matricula < qtde) {
					impressao(matricula);
				} else {
					System.out.println("A matrícula " + matricula + " é inválida!!");
				}				
				break;

			case 3:
				impressao();			
				break;
			case 4:
				System.out.println("sair");
				break;
			default:
				System.out.println("Opção inválida!!!");
				break;
			}			
		} while (opcao != 4);
		
		in.close();
		
		System.out.println("Processamento realizado!!!");
	}
}
