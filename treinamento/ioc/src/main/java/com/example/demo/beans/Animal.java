package com.example.demo.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Animal {

	private String nome;
	private String regiao;
	private String caracteristica;
	
	
	public void definirNome(String nome) {
		this.nome = nome;
	}
}
