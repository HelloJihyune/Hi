package org.zerock.task;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.zerock.domain.BoardAttachVO;
import org.zerock.mapper.BoardAttachMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Component
@Log4j
public class FileCheckTask {
	@Setter(onMethod_ = @Autowired)
	private BoardAttachMapper attachMapper;
	
	private String getFolderYesterDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		String str = sdf.format(cal.getTime());
		return str.replace("-",File.separator);
	}
	@Scheduled(cron="0 00 12 * * *")		// 매일 새벽 2시에 동작하도록 설정
	public void checkFiles() throws Exception {
		log.warn("File check task run.........");
		log.warn(new Date());
		// file list in datebase
		List<BoardAttachVO> fileList = attachMapper.getOldFiles();	// 데이터베이스 테이블
		
		// ready for check file in directory with database file list
		List<Path> fileListPaths = fileList.stream().map(vo -> Paths.get("C:\\jx\\upload",
			vo.getUploadPath(), vo.getUuid() + "_" + vo.getFileName())).collect(Collectors.toList());	// 파일에 대한 목록(존재하는) - 원본파일
		
		// image file has thumbnail file
		fileList.stream().filter(vo -> vo.isFileType() == true).map(vo -> 	Paths.get("C:\\jx\\upload",
			vo.getUploadPath(), "s_" + vo.getUuid() + "_" + vo.getFileName()))	// 섬네일
			.forEach(p -> fileListPaths.add(p));
		log.warn("=======================================");
fileListPaths.forEach(p -> log.warn(p));		// 데이터베이스에 저장된 파일의 정보를 로깅
		
		// file in yesterday directory
		File targetDir = Paths.get("C:\\jx\\upload", getFolderYesterDay()).toFile();
		File[] removeFiles = targetDir.listFiles(file -> fileListPaths.contains(file.toPath()) == false);
		
		if(removeFiles == null)	// null pointer exception 처리
			return;
		
		log.warn("---------------------------------------");
		for(File file : removeFiles) {
			log.warn(file.getAbsolutePath());
			file.delete();
		}
	}
}
