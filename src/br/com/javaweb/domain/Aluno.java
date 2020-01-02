package br.com.javaweb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_alunos")
@NamedQueries({ @NamedQuery(name = "Aluno.listar", query = "SELECT aluno FROM Aluno aluno"),
		@NamedQuery(name = "Aluno.buscarPorCodigo", query = "SELECT aluno FROM Aluno aluno WHERE aluno.codigo = :codigo") })
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "alu_codigo")
	private Long codigo;
	@Column(name = "alu_nome", length = 70, nullable = false)
	private String nome;
	@Column(name = "alu_curso", length = 70, nullable = false)
	private String curso;
	@Column(name = "matricula", length = 15, nullable = false)

	private String matricula;
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn (name="tbl_orientadores_ori_codigo", referencedColumnName = "ori_codigo", nullable = false)
	private Orientador orientador;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Orientador getOrientador() {
		return orientador;
	}

	public void setOrientador(Orientador orientador) {
		this.orientador = orientador;
	}
}