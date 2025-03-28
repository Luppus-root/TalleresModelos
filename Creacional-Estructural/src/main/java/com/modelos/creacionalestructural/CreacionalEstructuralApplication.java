package com.modelos.creacionalestructural;

import com.modelos.creacionalestructural.Factory.EntradaSalidaFabricaAbstracta;
import com.modelos.creacionalestructural.Factory.FabricaEntradaSalidaConsola;
import com.modelos.creacionalestructural.Factory.FabricaEntradaSalidaFrame;
import com.modelos.creacionalestructural.Factory.FabricaEntradaSalidaWeb;
import com.modelos.creacionalestructural.cliente.Cliente;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class CreacionalEstructuralApplication {

	public static void main(String[] args) {
		String[] inputMethods = {"Consola", "Frame (JOptionPane)", "Web"};
		int inputMethodChoice = JOptionPane.showOptionDialog(
				null,
				"Seleccione el método de entrada",
				"Método de Entrada",
				JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				inputMethods,
				inputMethods[0]
		);


		EntradaSalidaFabricaAbstracta factory;
		switch (inputMethodChoice) {
			case 0: // Consola
				factory = new FabricaEntradaSalidaConsola();
				break;
			case 1: // Frame
				factory = new FabricaEntradaSalidaFrame();
				break;
			case 2: // Web
				factory = new FabricaEntradaSalidaWeb();
				break;
			default:
				JOptionPane.showMessageDialog(null, "Método de entrada inválido");
				return;
		}

		Cliente cliente = new Cliente(factory);

		String mensaje = cliente.capturarDatos();
		cliente.mostrarDatos(mensaje);


		// NO SIRVE
		SpringApplication.run(CreacionalEstructuralApplication.class, args);
	}
}