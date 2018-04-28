package com.hanon.system.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hanon.system.service.StockService;

@RestController
@RequestMapping(value = "/hanon")
public class StockController {	
	
	@Autowired
	private StockService stockService;
	
	@RequestMapping(value = "/uploadStocksFile", method = RequestMethod.POST)
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

}
