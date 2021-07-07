package br.org.generation.blogpessoal.model;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UsuarioModelTeste {

	public Usuario usuario;

	/*
	 * Injeta um Objeto da Classe Validator, responsável pela Validação dos
	 * Atributos da Model
	 */

	@Autowired
	private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	@Autowired
	
	
	@BeforeEach
	public void start() {
		usuario = new Usuario("Marcos", "marcos", "123");

	}

	@Test
	public void testValidationAtributos() {

		usuario.setNome("Marcos");
		usuario.setUsuario("marcos");
		usuario.setSenha("123");

		// Armazena a lista de Mensagens de Erros de Validação da Model
		Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);

		// Exibe as Mensagens de Erro se existirem
		System.out.println(violations.toString());

		// O Teste só passará se a Lista de Erros estiver vazia!
		assertTrue(violations.isEmpty());

	}
}
