package com.hanon.system.service;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface StockService {
	public Map uploadStocksFile(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception;
}
