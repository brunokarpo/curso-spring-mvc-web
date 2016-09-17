package com.algaworks.brewer.storage;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

public class FotosStorageRunnable implements Runnable {

	private MultipartFile[] files;
	private DeferredResult<String> resultado;


	public FotosStorageRunnable(MultipartFile[] files, DeferredResult<String> resultado) {
		this.files = files;
		this.resultado = resultado;
	}


	@Override
	public void run() {
		System.out.println(" >>>> files[] " + files[0].getSize());
		// TODO: processamento pesado fica aqui;
		resultado.setResult("Ok! Foto recebida com sucesso");
	}

}
