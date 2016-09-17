package com.algaworks.brewer.storage;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import com.algaworks.brewer.dto.FotoDTO;

public class FotosStorageRunnable implements Runnable {

	private MultipartFile[] files;
	private DeferredResult<FotoDTO> resultado;


	public FotosStorageRunnable(MultipartFile[] files, DeferredResult<FotoDTO> resultado) {
		this.files = files;
		this.resultado = resultado;
	}


	@Override
	public void run() {
		System.out.println(" >>>> files[] " + files[0].getSize());
		// TODO: processamento pesado fica aqui;
		String nomeFoto = files[0].getOriginalFilename();
		String contentType = files[0].getContentType();

		resultado.setResult(new FotoDTO(nomeFoto, contentType));
	}

}
