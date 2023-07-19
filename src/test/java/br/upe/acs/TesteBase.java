package br.upe.acs;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

public class TesteBase {

	private AutoCloseable closeable;
	
	@BeforeEach
	public void abrirMocks() {
		closeable = MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	public void liberarMocks() throws Exception {
		closeable.close();
	}
}
