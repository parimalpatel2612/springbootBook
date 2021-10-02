package com.api.book.helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
//	private final String UPLOAD_DIR = "\\Users\\parimal\\eclipse-workspace\\springapibook\\src\\main\\resources\\static\\images";
	private final String UPLOAD_DIR = new ClassPathResource("static/images/").getFile().getAbsolutePath();
	
	public FileUploadHelper() throws IOException{
	}
	public boolean uploadFile(MultipartFile f) {
		boolean isFileUploaded = false;
		try {
//		InputStream is = f.getInputStream();
//		byte[] data = new byte[is.available()];
//		is.read(data);
//	FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+ "\\" + f.getOriginalFilename());
//		fos.write(data);
//		fos.flush();
//		fos.close();
//		is.close();
		
		Files.copy(f.getInputStream(), Paths.get(UPLOAD_DIR+ "\\" + f.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
		isFileUploaded = true;
		}catch (Exception e) {
			e.printStackTrace();
			isFileUploaded = false;
		}
		return isFileUploaded;
	}
	
	
}
