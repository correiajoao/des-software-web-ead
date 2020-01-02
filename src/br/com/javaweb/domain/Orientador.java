package br.com.javaweb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_orientadores")
@NamedQueries({ @NamedQuery(name = "Orientador.listar", query = "SELECT orientador FROM Orientador orientador"),
		@NamedQuery(name = "Orientador.buscarPorCodigo", query = "SELECT orientador FROM Orientador orientador WHERE orientador.codigo = :codigo") })
public class Orientador {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ori_codigo")
	private Long codigo;
	
	@Column(name = "ori_nome", length = 70, nullable = false)
	private String nome;

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
}
