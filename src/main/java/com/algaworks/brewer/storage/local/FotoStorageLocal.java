package com.algaworks.brewer.storage.local;

import static java.nio.file.FileSystems.getDefault;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

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

	@Override
	public String salvarTemporariamente(MultipartFile[] files) {
		String novoNome = null;
		if(files != null && files.length > 0) {
			MultipartFile arquivo = files[0];
			novoNome = renomearArquivo(arquivo.getOriginalFilename());
			try {
				arquivo.transferTo(new File(this.localTemporario.toAbsolutePath().toString() + getDefault().getSeparator() + novoNome));
			} catch (IOException e) {
				throw new RuntimeException("Erro ao salvar foto em pasta temporária", e);
			}
		}

		return novoNome;

	}

	@Override
	public byte[] recuperarFotoTemporaria(String nome) {
		byte[] foto;
		try {
			foto = Files.readAllBytes(this.localTemporario.toAbsolutePath().resolve(nome));
		} catch (IOException e) {
			throw new RuntimeException("Erro ao recuperar foto temporária", e);
		}
		return foto;
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

	private String renomearArquivo(String nomeOriginal) {
		String novoNome = UUID.randomUUID().toString() + "_" + nomeOriginal;
		LOG.debug(String.format("Arquivo original: %s, novo nome: %s", nomeOriginal, novoNome));
		return novoNome;
	}

}
