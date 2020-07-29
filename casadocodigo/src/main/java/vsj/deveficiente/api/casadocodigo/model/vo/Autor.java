package vsj.deveficiente.api.casadocodigo.model.vo;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Autor {

	private Long id;

	@NotBlank
	@NotNull
	private String nome;

	@NotBlank
	@NotNull
	@Email
	private String email;

	@NotBlank
	@NotNull
	@Size(max = 400)
	private String descricao;

	@NotNull
	private LocalDateTime instanteAlteracao;
	
	

}
