package com.hanon.system.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hanon.system.model.FileDetails;
import com.hanon.system.service.StockService;
import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service("StockService")
public class StockServiceImpl implements StockService {

	private String fileUploadDirectory = "C:/upload_files";

	@Override
	public Map uploadStocksFile(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf;

		Map<String, Object> files = null;
		List list = new LinkedList<>();
		while (itr.hasNext()) {
			mpf = request.getFile(itr.next());

			String newFilenameBase = UUID.randomUUID().toString();
			String originalFileExtension = mpf.getOriginalFilename()
					.substring(mpf.getOriginalFilename().lastIndexOf("."));
			String fileNameNew = newFilenameBase + originalFileExtension;
			String storageDirectory = fileUploadDirectory;
			// Path path = (Path) Paths.get(storageDirectory);

			// if (!Files.exists(path)) {
			// Files.createDirectories(path);
			// }

			String contentType = mpf.getContentType();

			File newFile = new File(storageDirectory + "/" + fileNameNew);
			String newFileNameWithPath = storageDirectory + "/" + fileNameNew;
			FileDetails fileDetails = null;		
			
			mpf.transferTo(newFile);
			String newExcelFileName = readStockFileWriteAsExcel(newFileNameWithPath, newFilenameBase);
			
			fileDetails = new FileDetails();
			fileDetails.setName(mpf.getOriginalFilename());
			fileDetails.setSize(mpf.getSize());
			fileDetails.setNewFilename(newExcelFileName);
			fileDetails.setType(contentType);
			fileDetails.setRec_status("A");

			
			// masterMapper.insertFileRepo(fileRepo);
			// long fileId = fileRepo.getFile_id();
			// log.info("Uploaded File Id " +fileId);
			// fileRepo.setUrl(ctxPath + "folder/" +fileId);

			// fileRepo.setCreate_dttm();
			// fileRepo.setDeleteUrl(ctxPath + "delete/" + fileId);
			// fileRepo.setDeleteType("DELETE");
			list.add(fileDetails);
			// list.add(doc);

		}

		files = new HashMap<>();
		files.put("files", list);

		return files;
	}

	private String readStockFileWriteAsExcel(String filePath, String newFileName) throws Exception {


		

		String[] headers = new String[] {"Company", "Part Number", "DESCRIPTION", "PROG","VARIANT", "COMMODITY","LINE Stock","STORE stock","STOCK","CUS PLAN","FIRM","TENTATIVE","Shortage Qty"};

//		Workbook workbook = new HSSFWorkbook();
//		Sheet sheet = workbook.createSheet("EDR Raw Data");

		
		
		
		
		
		FileInputStream file = new FileInputStream(new File(filePath));
		XSSFWorkbook wb = new XSSFWorkbook(file);
		String newExcelFileName = null;
		
		Workbook newWB = new XSSFWorkbook();
		Sheet newSheet = newWB.createSheet("Hanon");
		
		
		
		int rowCount = 1;
		
		 Row nwRow = newSheet.createRow(rowCount);
			for (int rn=0; rn<headers.length; rn++) {
				  
				nwRow.createCell(rn).setCellValue(headers[rn]);
				}
			
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			System.out.println("sheet no : " + (i + 1) + wb.getSheetAt(i).getSheetName());
			CreationHelper createHelper = wb.getCreationHelper();
			XSSFSheet sheet = wb.getSheetAt(i);

			// HSSFSheet sheet = wb.getSheetAt(i);
			
			int rwCounttest = 0;
			for (Row myrow : sheet) {
				rwCounttest = rwCounttest + 1;
				if (myrow.getRowNum() > 9) {
					// System.out.println("Mycell 17: " +
					// myrow.getCell(17).getNumericCellValue() + " row num :" +
					// myrow.getRowNum());
					/*
					 * if (null != myrow.getCell(17).getStringCellValue() &&
					 * !myrow.getCell(17).getStringCellValue().equals("")) {
					 */
					if (null != myrow.getCell(16)) {
						
						double col16 = myrow.getCell(16).getNumericCellValue();

			//			
						/*
						 * double col17 =
						 * myrow.getCell(17).getNumericCellValue();
						 * System.out.println("Mycell 17: " + col17); double
						 * col18 = myrow.getCell(18).getNumericCellValue();
						 * System.out.println("Mycell 18: " + col18);
						 */

						// if ((col17 < 0) || (col18 < 0) || (col16 < 0)) {
						if ((col16 < 0)) {
							
						//	Cell cell = myrow.getCell(c);
						//	Cell newCell = newRow.createCell(c);
				//		System.out.println("rowcount:: " + rwCounttest + "    Mycell 16: " + col16);
							Row newRow = newSheet.createRow(++rowCount);
							
							newRow.createCell(0).setCellValue(
									createHelper.createRichTextString(wb.getSheetAt(i).getSheetName()));							
							newRow.createCell(1).setCellValue(
									createHelper.createRichTextString(myrow.getCell(2).getStringCellValue()));	
							newRow.createCell(2).setCellValue(
									createHelper.createRichTextString(myrow.getCell(3).getStringCellValue()));	
							newRow.createCell(3).setCellValue(
									createHelper.createRichTextString(myrow.getCell(4).getStringCellValue()));	
						/*	newRow.createCell(4).setCellValue(
									createHelper.createRichTextString(myrow.getCell(5).getStringCellValue()));	
							newRow.createCell(5).setCellValue(
									createHelper.createRichTextString(myrow.getCell(6).getStringCellValue()));	*/						
							newRow.createCell(6).setCellValue(myrow.getCell(9).getNumericCellValue());
							newRow.createCell(7).setCellValue(myrow.getCell(10).getNumericCellValue());
							newRow.createCell(8).setCellValue(myrow.getCell(11).getNumericCellValue());
							newRow.createCell(9).setCellValue(myrow.getCell(12).getNumericCellValue());
							newRow.createCell(10).setCellValue(myrow.getCell(13).getNumericCellValue());
							newRow.createCell(11).setCellValue(myrow.getCell(14).getNumericCellValue());
							newRow.createCell(12).setCellValue(myrow.getCell(15).getNumericCellValue());
							newRow.createCell(13).setCellValue(myrow.getCell(16).getNumericCellValue());
							newRow.createCell(14).setCellValue(myrow.getCell(17).getNumericCellValue());
						
							/*
							int cols = 0; // No of columns
							int tmp = 0;

							
							
							if (myrow != null) {
								tmp = myrow.getPhysicalNumberOfCells();							
								if (tmp > cols)
									cols = tmp;
							}

							for (int c = 0; c < cols; c++) {
								Cell cell = myrow.getCell(c);
								if (cell != null) {
									Cell newCell = newRow.createCell(c);
									// Your code here
									switch (cell.getCellType()) { // Identify
																	// CELL

									case Cell.CELL_TYPE_STRING:
										
										newRow.createCell(c).setCellValue(
												createHelper.createRichTextString(cell.getStringCellValue()));										
										break;
									case Cell.CELL_TYPE_NUMERIC:
									
										newRow.createCell(c).setCellValue(cell.getNumericCellValue());
										break;
									case Cell.CELL_TYPE_BLANK:
										
										newCell.setCellType(Cell.CELL_TYPE_STRING);
										cell.setCellType(Cell.CELL_TYPE_STRING);

										newCell.setCellValue(
												createHelper.createRichTextString(cell.getStringCellValue()));
										break;
									case Cell.CELL_TYPE_FORMULA:
										newCell.setCellType(Cell.CELL_TYPE_STRING);
										cell.setCellType(Cell.CELL_TYPE_STRING);
										newCell.setCellValue(
												createHelper.createRichTextString(cell.getStringCellValue()));
										break;
									}
								}

							}
*/
						}

						// Finally add the table to PDF document
						// iText_xls_2_pdf.add(my_table);
					}
				}
				// iText_xls_2_pdf.close();
				// we created our pdf file..

				// return iText_xls_2_pdf;
			}
		//	System.out.println("sheet no : " + (i + 1) + " || row count : " + rwCounttest);

		}
		
		Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyHHmmss");  
	    String strDate= formatter.format(date);  
	   
	    newExcelFileName = "workbook-"+strDate+".xls";
		FileOutputStream fileOut = new FileOutputStream("C:/upload_files/"+newExcelFileName);
		newWB.write(fileOut);

		fileOut.close();

		file.close();
//		System.out.println("Deleting.. "+ filePath);
		
		File tempFile = new File(filePath);    	
		tempFile.delete();
		return newExcelFileName;
	}

	private void readStockFile(String filePath, String newFileName) throws Exception {
		System.out.println("filePath : " + filePath);
		// FileInputStream file = new FileInputStream(new
		// File("E://Imp/Details.xlsx"));
		FileInputStream file = new FileInputStream(new File(filePath));

		// We will create output PDF document objects at this point
		Document iText_xls_2_pdf = new Document();
		String tempName = "Excel2PDF_Output";
		// PdfWriter.getInstance(iText_xls_2_pdf, new
		// FileOutputStream("C:/upload_files/"+newFileName+".pdf"));
		PdfWriter.getInstance(iText_xls_2_pdf, new FileOutputStream("C:/upload_files/" + tempName + ".pdf"));
		iText_xls_2_pdf.open();
		// we have two columns in the Excel sheet, so we create a PDF table with
		// two columns
		// Note: There are ways to make this dynamic in nature, if you want to.
		PdfPTable my_table = new PdfPTable(2);
		// We will use the object below to dynamically add new data to the table
		PdfPCell table_cell;

		// POIFSFileSystem fs = new POIFSFileSystem(file);
		// HSSFWorkbook wb = new HSSFWorkbook(fs);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {

			XSSFSheet sheet = wb.getSheetAt(i);

			// HSSFSheet sheet = wb.getSheetAt(i);

			for (Row myrow : sheet) {
				if (myrow.getRowNum() > 9) {
					System.out.println(
							"Mycell 17: " + myrow.getCell(17).getNumericCellValue() + " row num :" + myrow.getRowNum());
					/*
					 * if (null != myrow.getCell(17).getStringCellValue() &&
					 * !myrow.getCell(17).getStringCellValue().equals("")) {
					 */
					double row17 = myrow.getCell(17).getNumericCellValue(); // int
																			// row17
																			// =
																			// Integer.parseInt(myrow.getCell(17).getNumericCellValue());
					double row18 = myrow.getCell(18).getNumericCellValue();
					double row19 = myrow.getCell(19).getNumericCellValue();
					System.out.println("Mycell 17: " + row17);
					System.out.println("Mycell 18: " + row18);
					System.out.println("Mycell 19: " + row19);
					if ((row17 < 0) || (row18 < 0) || (row19 < 0)) {
						for (Cell cell : myrow) {
							// Fetch CELL

							/*
							 * public static final int CELL_TYPE_NUMERIC = 0;
							 * 
							 * // Field descriptor #4 I public static final int
							 * CELL_TYPE_STRING = 1;
							 * 
							 * // Field descriptor #4 I public static final int
							 * CELL_TYPE_FORMULA = 2;
							 * 
							 * // Field descriptor #4 I public static final int
							 * CELL_TYPE_BLANK = 3;
							 * 
							 * // Field descriptor #4 I public static final int
							 * CELL_TYPE_BOOLEAN = 4;
							 * 
							 * // Field descriptor #4 I public static final int
							 * CELL_TYPE_ERROR = 5;
							 */

							System.out
									.println("Mycell : " + cell.getColumnIndex() + " cell type :" + cell.getCellType());
							switch (cell.getCellType()) { // Identify CELL

							// type
							// you need to add more code here based on
							// your requirement / transformations
							case Cell.CELL_TYPE_STRING:
								// Push the data from Excel to PDF Cell

								table_cell = new PdfPCell(new Phrase(cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								// Push the data from Excel to PDF Cell
								table_cell = new PdfPCell(new Phrase(cell.getNumericCellValue() + ""));
								// feel free to move the code below to suit to
								// your
								// needs
								my_table.addCell(table_cell);
								break;
							case Cell.CELL_TYPE_BLANK:
								// Push the data from Excel to PDF Cell
								table_cell = new PdfPCell(new Phrase(cell.getStringCellValue()));
								// feel free to move the code below to suit to
								// your
								// needs
								my_table.addCell(table_cell);
								break;
							/*
							 * case default // Push the data from Excel to PDF
							 * Cell table_cell = new PdfPCell(new
							 * Phrase(cell.getStringCellValue())); break;
							 */
							}
						}
						// }
						// Do your stuff
					}
				}
			}

			// Finally add the table to PDF document
			iText_xls_2_pdf.add(my_table);

		}
		iText_xls_2_pdf.close();
		// we created our pdf file..

		file.close();
		// return iText_xls_2_pdf;
	}
}