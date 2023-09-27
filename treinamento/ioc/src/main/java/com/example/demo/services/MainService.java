package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.beans.Animal;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MainService {

	private final Animal animal;
	
	public void teste() {
		this.animal.definirNome("Evandro");
	}
	
}
