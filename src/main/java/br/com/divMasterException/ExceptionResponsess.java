package br.com.divMasterException;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@SuperBuilder
public class ExceptionResponsess implements Serializable {
	private static final long serialVersionUID = 1L;

	private LocalDateTime Hora_Do_Erro;
	private String Menssaem;
	private String detalhes;
	

}
