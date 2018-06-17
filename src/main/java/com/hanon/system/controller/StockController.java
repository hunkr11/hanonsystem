package com.hanon.system.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hanon.system.service.StockService;

@Controller
public class StockController {	
	
	@Autowired
	private StockService stockService;
	
	@RequestMapping(value = "/hanon/uploadStocksFile", method = RequestMethod.POST)
	public @ResponseBody
	Map uploadStocksFile(MultipartHttpServletRequest request, HttpServletResponse response) {
	//	log.info("uploadPost called");
		System.out.println("uploadStocksFile");
		Map<String, Object> files = null;
		try {
			files = stockService.uploadStocksFile(request, response);			
		
		} catch (Exception e) {	
			e.printStackTrace();
//			log.error("EXCEPTION", e);
		}

		return files;
	}
	
	@RequestMapping(value = "/hanon/folder/{path}", method = RequestMethod.GET)
	public void folder(HttpServletResponse response, @PathVariable String path) {
System.out.println("path : "+path);
	//	FileRepo fileRep = masterService.getFileRepoById(id);
	//	log.info("Downloading File :: " + fileUploadDirectory + "/" + fileRep.getNewFilename());
		try {
		//	Path file = Paths.get(fileUploadDirectory, fileRep.getNewFilename());
			Path file = Paths.get("C:/upload_files/"+path);
			if (Files.exists(file)) {
//				response.setContentType(fileRep.getType());
//				response.addHeader("Content-Disposition", "attachment; filename=" + fileRep.getName());

				Files.copy(file, response.getOutputStream());
				response.getOutputStream().flush();

			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		//	log.error("Exception", e);
		}
	}
	
	@RequestMapping(value = "/*",method = RequestMethod.GET)
	public String home() {
		//	log.info("uploadPost called");
		System.out.println("home");
		
		
		return "welcome";
	}

}
