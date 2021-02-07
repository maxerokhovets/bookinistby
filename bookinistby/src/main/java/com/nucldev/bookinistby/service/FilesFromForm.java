package com.nucldev.bookinistby.service;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FilesFromForm {
	private List<MultipartFile> files;

	public FilesFromForm() {
	}

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	
}
