package br.edu.infnet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

	private static List<Aluno> alunos;

	private static int qtde = 0;
	private static final int QTDE_MAX = 100;

	private static void imprimeAlunos(){
		System.out.println("---- Relatorio de Alunos ----");

		for (Aluno aluno : alunos) {
			aluno.imprimeAluno();
		}
		System.out.println("-----------------------------------");
	}

	public static void main(String[] args){

		alunos = new ArrayList<Aluno>();
		int opcao = 0;		

		Scanner in = new Scanner(System.in);

		do {
			System.out.println("[1] Registrar as notas de um novo aluno");
			System.out.println("[2] Consultar boletim de um aluno");
			System.out.println("[3] Consultar notas da tuma");
			System.out.println("[4] Sair");
			System.out.print("Informe a opcao desejada: ");
			
			try{
				opcao = Integer.valueOf(in.next());
			}catch(NumberFormatException e) {
				System.out.println("Opcao invalida!!!");
			}
			
			
			
			switch (opcao) {
			case 1:
				if(qtde < QTDE_MAX) {

					try {
						Aluno aluno = new Aluno();
						
						System.out.print("Informe o nome do aluno: ");
						aluno.setNome(in.next());
						
						System.out.print("Informe a sua Nota da AV1: ");
						aluno.setNotaAV1(Float.valueOf(in.next()));
						
						System.out.print("Informe a sua Nota da AV2: ");
						aluno.setNotaAV2(Float.valueOf(in.next()));
						
						aluno.setMatricula(qtde);
						aluno.setMedia(aluno.getNotaAV1(), aluno.getNotaAV2());
						aluno.setSituacao(aluno.getMedia());
						aluno.imprimeAluno();
						alunos.add(aluno);
						
						qtde++;
					}catch(NumberFormatException e) {
						System.out.println("Cadastro invalido!!!");
					}


				} else {
					System.out.println("Impossivel realizar o cadastramento!!!");
				}
				break;
			case 2:
				try {
					System.out.println("Informe a matricula do aluno: ");
					int matricula = Integer.valueOf(in.next());
					
					if(matricula >= 0 && matricula < alunos.size()) {
						alunos.get(matricula).imprimeAluno();
					} else {
						System.out.println("A matricula " + matricula + " eh invalida!!");
					}
				}catch(NumberFormatException e) {
					System.out.println("Matricula invalida!!!");
				}
				break;

			case 3:
				imprimeAlunos();			
				break;
			case 4:
				System.out.println("sair");
				break;
			default:
				System.out.println("Opcao invalida!!!");
				break;
			}			
		} while (opcao != 4);
		
		in.close();
		
		System.out.println("Processamento realizado!!!");
	}
}
