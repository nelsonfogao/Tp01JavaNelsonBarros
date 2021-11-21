package br.edu.infnet;

public class Aluno {
	private int matricula;
	private String nome;
	private Float notaAV1;
	private Float notaAV2;
	private Float media;
	private String situacao;
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getNotaAV1() {
		return notaAV1;
	}
	public void setNotaAV1(Float notaAV1) {
		this.notaAV1 = notaAV1;
	}

	public Float getNotaAV2() {
		return notaAV2;
	}
	public void setNotaAV2(Float notaAV2) {
		this.notaAV2 = notaAV2;
	}

	public Float getMedia() {
		return media;
	}
	public void setMedia(Float av1, Float av2) {
		media = (av1 + av2)/2;
	}

	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(Float media) {
		if (media >= 7) {
			situacao = "Aprovado";
		}else if(media < 4){
			situacao = "Reprovado";
		}else{
			situacao = "Prova Final";
		}
	}
	
	public void imprimeAluno(){		
		System.out.println( matricula + " - Nome do aluno: " + nome);
		System.out.println("Nota da AV1: " + notaAV1);
		System.out.println("Nota da AV2: " + notaAV2);
		System.out.println("Media final: " + media);
		System.out.println("Situacao: " + situacao);  
	}

}
