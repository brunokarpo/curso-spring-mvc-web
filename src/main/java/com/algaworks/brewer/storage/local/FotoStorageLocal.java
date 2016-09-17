package com.algaworks.brewer.storage.local;

import static java.nio.file.FileSystems.getDefault;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.algaworks.brewer.storage.FotoStorage;

public class FotoStorageLocal implements FotoStorage {

	private static final Logger LOG = LoggerFactory.getLogger(FotoStorageLocal.class);

	private Path local;
	private Path localTemporario;

	public FotoStorageLocal() {
		this.local = getDefault().getPath(System.getenv("HOME"), ".brewerfotos");
		criarPastas();
	}

	private void criarPastas() {
		try {
			Files.createDirectories(this.local);
			this.localTemporario = getDefault().getPath(this.local.toString(), "temp");
			Files.createDirectories(this.localTemporario);

			LOG.debug("Pastas para salvar criadas com sucesso");
			LOG.debug("Pasta default: " + this.local.toAbsolutePath());
			LOG.debug("Pasta temporária: " + this.localTemporario.toAbsolutePath());

		} catch (IOException e) {
			throw new RuntimeException("Erro ao criar pastas para salvar fotos", e  );
		}
	}

	@Override
	public void salvarTemporariamente(MultipartFile[] files) {
		LOG.debug(" >>>> Salvando foto temporariamente...");
	}

}
