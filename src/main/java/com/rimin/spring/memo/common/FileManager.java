package com.rimin.spring.memo.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileManager {
	
	// 상수 정해진 경로이기 때문에 절대 변하면 안되는 값 ,수정을 막아주는 역할, 모두 대문자로
	public final static String FILE_UPLOAD_PATH = "D:\\rimin\\springProject\\upload\\memo";
	
	public static String saveFile(int userId, MultipartFile file) {
		
		// 첨부파일이 없을 경우 아래 코드가 실행되지 않도록 
		// null 을 return 하도록
		// 객체를 return 하는 객체에서 null을 return 하면 기능 수행이 제대로 되지 않았다는 것을 의미
		
		if(file == null) {
			return null;
		}
		
		// 같은 이름의 파일 처리
		// 폴더(디렉토리)만들어서 파일 저장
		// 로그인한 사용자의 userId를 폴더 이름으로
		// 현재시간 정보를 폴더 이름에 포함 
		// UNIX TIME : 1970년 1월 1일부터 흐린시간을 milli second(1/1000) 로 표현한 시간
		// ex) 2_564855854354
		
		
		
		String directoryName = "/" + userId + "_" + System.currentTimeMillis();
		
		// 폴더 생성 
		
		String directoryPath = FILE_UPLOAD_PATH + directoryName;
		File directory = new File(directoryPath);
		
		
		
		if(!directory.mkdir()) {
			//디렉터리 생성 실패
			return null;
		}
		
		// 파일 저장
		String filePath = directoryPath + "/" + file.getOriginalFilename();
		
		
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(filePath);
			Files.write(path, bytes);
		} catch (IOException e) {
			
			e.printStackTrace();
			// 파일 저장 실패
			return null;
		}
	
		
		// 클라이언트에서 접근 가능한 경로 - 데이터베이스에 저장
		// 클라이언트에서 접근 가능한 경로 리턴
		
		// 파일 경로 : D:\\rimin\\springProject\\memo\\upload/2_564855854354/test.png
		// url 경로 규칙 : /images/2_564855854354/test.png
		
		return "/images" + directoryName + "/" + file.getOriginalFilename();
		
		
	}
	
}
