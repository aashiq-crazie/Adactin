package com.adactin.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData {
	public static String data, fName;
	

	public String testMeth(String given) throws IOException {

		List<String> key = new ArrayList<String>();
		List<String> value = new ArrayList<String>();

		HashMap<String, String> m = new HashMap<String, String>();

		File f = new File(FileReaderManager.getInstance().getCRInstance().getTestData());
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);

		Sheet excel = wb.getSheetAt(0);
		int rows = excel.getPhysicalNumberOfRows();
		for (int i = 0; i < rows; i++) {
			Row row = excel.getRow(i);
			Cell cell1 = row.getCell(1);
			Cell cell2 = row.getCell(2);
			if (cell1.getCellType().equals(cell1.getCellType().STRING)) {
				key.add(cell1.getStringCellValue());
			}
			if (cell2.getCellType().equals(cell2.getCellType().STRING)) {
				value.add(cell2.getStringCellValue().replace("`", ""));
			} else if (cell2.getCellType().equals(cell2.getCellType().NUMERIC)) {
				double numericCellValue = cell2.getNumericCellValue();
				long l = (long) numericCellValue;
				String valueOf = String.valueOf(l);
				value.add(valueOf);

			}
			for (int j = 0; j < key.size(); j++) {
				m.put(key.get(j), value.get(j));

			}
		}
		Set<Entry<String, String>> entrySet = m.entrySet();
		for (Entry<String, String> entry : entrySet) {
			if (entry.getKey().equals(given)) {
				data = entry.getValue();

			}

		}
		fName = m.get("First Name");
		return data;

	}

}
