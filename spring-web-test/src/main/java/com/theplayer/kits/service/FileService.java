package com.theplayer.kits.service;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FileService {

	String store(String file);
	String store(File file);
	String store(MultipartFile file);
	
	List<String> loadFileName();
	List<File> loadFiles();
	File load(String file);
}
