package com.ejemplo.security.controller;

import org.springframework.web.bind.annotation.*;

import com.ejemplo.security.services.AesEncryptionService;
import com.ejemplo.security.services.RsaEncryptionService;

@RestController
@RequestMapping("/api/crypto")
public class CryptoController {
	private final AesEncryptionService aesService;
	private final RsaEncryptionService rsaService;

	public CryptoController() throws Exception {
		this.aesService = new AesEncryptionService();
		this.rsaService = new RsaEncryptionService();
	}

	@PostMapping("/aes/encrypt")
	public String encryptAes(@RequestBody String input) throws Exception {
		return aesService.encrypt(input);
	}

	@PostMapping("/aes/decrypt")
	public String decryptAes(@RequestBody String input) throws Exception {
	    input = input.replaceAll("^\"|\"$", "");
	    return aesService.decrypt(input);
	}


	@PostMapping("/rsa/encrypt")
	public String encryptRsa(@RequestBody String input) throws Exception {
		return rsaService.encrypt(input);
	}

	@PostMapping("/rsa/decrypt")
	public String decryptRsa(@RequestBody String input) throws Exception {
	    input = input.replace("\"", "");
	    return rsaService.decrypt(input);
	}
}