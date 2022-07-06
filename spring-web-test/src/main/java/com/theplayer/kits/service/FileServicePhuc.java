package com.theplayer.kits.service;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.theplayer.kits.ServletContextParam;

//@Service
public class FileServicePhuc implements FileService {
	@Autowired
	private ServletContextParam scparam;

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
//		Path uploadPath = Paths.get( scparam.getParams("uploadPath") );
//		System.out.println(scparam.getParams("uploadPath"));
		Path uploadPath = Paths.get(scparam.getUploadPath());
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		if (!file.isEmpty()) {
			if (!filename.contains("..")) {
				try (InputStream inputStream = file.getInputStream()){
					Files.copy(inputStream, uploadPath.resolve(filename),
							StandardCopyOption.REPLACE_EXISTING);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
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

	@Override
	public List<String> loadFileName() {
		// TODO Auto-generated method stub
		return null;
	}
}
