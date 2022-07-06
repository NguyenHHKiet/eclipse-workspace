package com.theplayer.kits.service;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

//@Service
public class FileServiceTest implements FileService{

	private static Path rootLocation;
	private static final String UPLOAD_PATH;
	static {
		UPLOAD_PATH = "D:\\upload";
		rootLocation = Paths.get("D:\\upload");
	}
	
	
	@Override
	public String store(String file) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String store(File file) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String store(MultipartFile file) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> loadFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<File> loadFiles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File load(String file) {
		// TODO Auto-generated method stub
		return null;
	}

}
