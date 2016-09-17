package com.algaworks.brewer.storage;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import com.algaworks.brewer.dto.FotoDTO;

public class FotosStorageRunnable implements Runnable {

	private MultipartFile[] files;
	private DeferredResult<FotoDTO> resultado;
	private FotoStorage fotoStorage;


	public FotosStorageRunnable(MultipartFile[] files, DeferredResult<FotoDTO> resultado, FotoStorage fotoStorage) {
		this.files = files;
		this.resultado = resultado;
		this.fotoStorage = fotoStorage;
	}


	@Override
	public void run() {
		this.fotoStorage.salvarTemporariamente(files);
		String nomeFoto = files[0].getOriginalFilename();
		String contentType = files[0].getContentType();
		resultado.setResult(new FotoDTO(nomeFoto, contentType));
	}

}
