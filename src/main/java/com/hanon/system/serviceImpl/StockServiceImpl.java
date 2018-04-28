package com.hanon.system.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
			fileDetails = new FileDetails();
			fileDetails.setName(mpf.getOriginalFilename());
			fileDetails.setSize(mpf.getSize());
			fileDetails.setNewFilename(fileNameNew);
			fileDetails.setType(contentType);
			fileDetails.setRec_status("A");

			readStockFileWriteAsExcel(newFileNameWithPath, newFilenameBase);
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

	private void readStockFileWriteAsExcel(String filePath, String newFileName) throws Exception {

		FileInputStream file = new FileInputStream(new File(filePath));
		XSSFWorkbook wb = new XSSFWorkbook(file);

		Workbook newWB = new XSSFWorkbook();
		Sheet newSheet = newWB.createSheet("new sheet");
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			System.out.println("sheet no : " + (i + 1));
			CreationHelper createHelper = wb.getCreationHelper();
			XSSFSheet sheet = wb.getSheetAt(i);

			// HSSFSheet sheet = wb.getSheetAt(i);
			int rowCount = 0;
			for (Row myrow : sheet) {
				if (myrow.getRowNum() > 9) {
					// System.out.println("Mycell 17: " +
					// myrow.getCell(17).getNumericCellValue() + " row num :" +
					// myrow.getRowNum());
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
					// System.out.println("Mycell 17: " + row17);
					// System.out.println("Mycell 18: " + row18);
					// System.out.println("Mycell 19: " + row19);
					if ((row17 < 0) || (row18 < 0) || (row19 < 0)) {

						// int rows = sheet.getPhysicalNumberOfRows();
						// HSSFRow row;
						// Cell cell;
						int cols = 0; // No of columns
						int tmp = 0;

						// This trick ensures that we get the data properly even
						// if it doesn't start from first few rows
						// for (int rowIndex = 0; rowIndex < 10 || rowIndex <
						// rows; i++) {
						// Row newRow = null;
						Row newRow = newSheet.createRow(++rowCount);
						// for (int rowIndex = 0; rowIndex < rows; i++) {
						//
						// // row = (HSSFRow) myrow;
						// System.out.println("myrow rowIndex :: " + rowIndex);
						// // System.out.println("row : " + row);
						if (myrow != null) {
							tmp = myrow.getPhysicalNumberOfCells();
							// sheet.getRow(rowIndex).getPhysicalNumberOfCells();
							if (tmp > cols)
								cols = tmp;
						}

						// for (int r = 0; r < rows; r++) {
						// row = (HSSFRow) myrow;

						for (int c = 0; c < cols; c++) {
							Cell cell = myrow.getCell(c);
							if (cell != null) {
								Cell newCell = newRow.createCell(c);
								// Your code here
								switch (cell.getCellType()) { // Identify
																// CELL

								// type
								// you need to add more code here
								// based
								// on
								// your requirement /
								// transformations
								case Cell.CELL_TYPE_STRING:
									// Push the data from Excel to
									// PDF
									// Cell
									newRow.createCell(c)
											.setCellValue(createHelper.createRichTextString(cell.getStringCellValue()));
									// table_cell = new PdfPCell(new
									// Phrase(cell.getStringCellValue()));
									break;
								case Cell.CELL_TYPE_NUMERIC:
									// Push the data from Excel to
									// PDF
									// Cell
									newRow.createCell(c).setCellValue(cell.getNumericCellValue());
									// table_cell = new PdfPCell(new
									// Phrase(cell.getNumericCellValue()
									// + ""));
									// feel free to move the code
									// below
									// to suit to
									// your
									// needs
									// my_table.addCell(table_cell);
									// break;
								case Cell.CELL_TYPE_BLANK:
									// Push the data from Excel to
									// PDF
									// Cell
									newCell.setCellType(Cell.CELL_TYPE_STRING);
									cell.setCellType(Cell.CELL_TYPE_STRING);

									newCell.setCellValue(createHelper.createRichTextString(cell.getStringCellValue()));
									// table_cell = new PdfPCell(new
									// Phrase(cell.getStringCellValue()));
									// feel free to move the code
									// below
									// to suit to
									// your
									// needs
									// my_table.addCell(table_cell);
									// break;
								case Cell.CELL_TYPE_FORMULA:
									// Push the data from Excel to
									// PDF
									// Cell

									newCell.setCellType(Cell.CELL_TYPE_STRING);
									cell.setCellType(Cell.CELL_TYPE_STRING);
									newCell.setCellValue(createHelper.createRichTextString(cell.getStringCellValue()));
									// table_cell = new PdfPCell(new
									// Phrase(cell.getStringCellValue()));
									// feel free to move the code
									// below
									// to suit to
									// your
									// needs
									// my_table.addCell(table_cell);
									// break;

									// }

								}
							}

							// }
						}

						//
						// Workbook workbook = new HSSFWorkbook();
						// Sheet sheet2k3 = workbook.createSheet();

						// for (Book aBook : listBook) {
						// Row row = sheet2k3.createRow(++rowCount);
						// writeBook(aBook, row);
						// }

						// try (FileOutputStream outputStream = new
						// FileOutputStream(excelFilePath)) {
						// workbook.write(outputStream);
						// }

					}

					// Finally add the table to PDF document
					// iText_xls_2_pdf.add(my_table);

				}
				// iText_xls_2_pdf.close();
				// we created our pdf file..

				// return iText_xls_2_pdf;
			}

		}

		FileOutputStream fileOut = new FileOutputStream("C:/upload_files/workbook.xls");
		newWB.write(fileOut);

		fileOut.close();

		file.close();
		System.out.println("dkdkd");
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