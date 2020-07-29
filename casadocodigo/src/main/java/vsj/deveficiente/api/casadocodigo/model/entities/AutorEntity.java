package vsj.deveficiente.api.casadocodigo.model.entities;

import static javax.persistence.GenerationType.SEQUENCE;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "autor")
public class AutorEntity {

	@Id
	@SequenceGenerator(name = "AUTO_AUTORID_GENERATOR", sequenceName = "AUTO_AUTORID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = SEQUENCE, generator = "AUTO_AUTORID_GENERATOR")
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false, precision = 400)
	private String descricao;

	@Column(nullable = false)
	private LocalDateTime instanteAlteracao;

	public AutorEntity() {
		// Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getInstanteAlteracao() {
		return instanteAlteracao;
	}

	public void setInstanteAlteracao(LocalDateTime instanteAlteracao) {
		this.instanteAlteracao = instanteAlteracao;
	}

	@Override
	public String toString() {
		return String.format("AutorEntity [id=%s, nome=%s, email=%s, descricao=%s, instanteAlteracao=%s]", id, nome,
				email, descricao, instanteAlteracao);
	}

}
