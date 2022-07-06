package com.theplayer.kits.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceSon implements FileService{
	
	private static Path rootLocation;
	private static final String UPLOAD_PATH;
	static {
		UPLOAD_PATH = "/images/upload";
		rootLocation = Paths.get("/images/upload");
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
		System.out.println("store: "+file);
		System.out.println("name: "+ file.getName());
		String ofname = file.getOriginalFilename();
		System.out.println("original: " +ofname);
		String ext = ofname.substring(ofname.lastIndexOf("."), ofname.length());
		System.out.println("file existsing:" +ext);
		
		FileOutputStream fos;
		try {
			File dir = new File(UPLOAD_PATH);
			System.out.println(UPLOAD_PATH);
			if (!dir.exists()) {
				if (dir.mkdirs()) {
					System.out.println("success");
					System.out.println(new File(ofname).getAbsolutePath());
				}else {
					System.out.println("false");
					System.out.println(new File(ofname).getAbsolutePath());
				}
			}
//			Thao tác tạo không thành công vì bạn vừa tạo một thư mục 
//			có cùng tên với tệp bạn muốn tạo.
			
			byte[] data = file.getBytes();
			File filemkdir = new File(UPLOAD_PATH+"/"+ofname);
			
			File folder = filemkdir.getParentFile();
			if(!folder.mkdirs() && !folder.exists()) {
                System.out.println("Cannot create: " + folder);
                System.exit(0);
            }
//			filemkdir.createNewFile();
			System.out.println(new File(ofname).getAbsolutePath());
			fos = new FileOutputStream(filemkdir);
			fos.write(data);
			fos.flush();
			fos.close();
			System.out.println("create directory!!!");
			System.out.println(new File(UPLOAD_PATH).getAbsolutePath());
			//file isntance without path
//			File efile = (new File(ofname));
//			efile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ofname);
		return ofname;
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
