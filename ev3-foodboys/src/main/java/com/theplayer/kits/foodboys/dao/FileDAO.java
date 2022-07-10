package com.theplayer.kits.foodboys.dao;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.web.multipart.MultipartFile;
//author: Long
public class FileDAO {
	private static final String UPLOADPATH = File.separator + "upload";
	
	public String store(MultipartFile file) {
		File pto;
		System.out.println(1);
		try {
			pto = new File(FileDAO.class.getProtectionDomain().getCodeSource().getLocation().toURI());
			String pathAbc = pto.getAbsolutePath().substring(0,pto.getAbsolutePath().lastIndexOf("\\")-8).toString();
			String path = pathAbc;
			System.err.println(pto.getAbsolutePath().toString());
			System.err.println(path);
			System.err.println(path+"\\images\\");
			String ext = file.getOriginalFilename()
					.substring(
							file.getOriginalFilename().lastIndexOf("."),
							file.getOriginalFilename().length() );
			System.out.println(ext);
			String fname = ( file.getOriginalFilename() );
			File moved = new File(path+File.separator+"images"+File.separator+fname);
			if ( !moved.exists() ) {
				if (moved.getParentFile().mkdirs()) {
					moved.createNewFile();
				}
			}
			file.transferTo(moved);
			System.out.println(moved.getAbsolutePath());
			System.out.println(moved.getCanonicalPath());
			return fname;
		} catch (URISyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(2);
		return null;
	}

}
