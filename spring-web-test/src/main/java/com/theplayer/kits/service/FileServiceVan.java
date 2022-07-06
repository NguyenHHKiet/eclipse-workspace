package com.theplayer.kits.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

//@Service
public class FileServiceVan implements FileService {

	private static final String UPLOADPATH = "/upload";
	
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
		System.out.println(file.getSize());
		String ext = file.getOriginalFilename().substring(
				file.getOriginalFilename().lastIndexOf("."),
				file.getOriginalFilename().length());
		System.out.println(ext);
		String fname = file.getOriginalFilename();
		File moved = new File(UPLOADPATH + File.separator + fname);
		try {
			if (!moved.exists()) {
				File parent = new File(moved.getParent());
				parent.mkdirs();
			}
			file.transferTo(moved);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
