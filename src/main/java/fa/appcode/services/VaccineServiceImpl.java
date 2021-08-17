package fa.appcode.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import fa.appcode.common.logging.Logging;
import fa.appcode.common.valueobjects.VaccineVo;
import fa.appcode.dao.dao.VaccineDAO;
import fa.appcode.dao.dao.VaccineDAOImpl;
import fa.appcode.web.entities.Vaccine;
import fa.appcode.web.entities.VaccineType;

public class VaccineServiceImpl implements VaccineService {

	private VaccineDAO vaccineDAO;

	@Override
	public List<VaccineVo> findAll() {
		vaccineDAO = new VaccineDAOImpl();
		List<VaccineVo> vaccineVos = new ArrayList<VaccineVo>();
		List<Object[]> results = vaccineDAO.findAllVaccine();
		for (Object[] objects : results) {
			VaccineVo vo = new VaccineVo();
			vo.setVaccineId((String) objects[0]);
			vo.setVaccineName((String) objects[1]);
			vo.setNumberOfInjection((int) objects[2]);
			vo.setOrigin((String) objects[3]);
			vo.setVaccineTypeName((String) objects[4]);
			vo.setStatus((boolean) objects[5]);

			boolean check = vaccineVos.add(vo);
			if (check)
				Logging.getLog().info("Get successfully");
			else
				Logging.getLog().info("Get failed");
		}
		return vaccineVos;
	}

	@Override
	public Vaccine findById(String id) {
		vaccineDAO = new VaccineDAOImpl();
		return vaccineDAO.findById(id);
	}

	@Override
	public void create(Vaccine vaccine) throws Exception {
		if (vaccine == null) {
			Logging.getLog().error("Vaccine Invalid!!!");
			throw new IllegalArgumentException();
		}
		vaccineDAO = new VaccineDAOImpl();
		if (vaccineDAO.findById(vaccine.getId()) != null) {
			throw new Exception("Id existed");
		} else {
			vaccineDAO.saveVaccine(vaccine);
		}
	}

	@Override
	public void save(Vaccine vaccine) {
		vaccineDAO = new VaccineDAOImpl();
		vaccineDAO.saveVaccine(vaccine);

	}

	@Override
	public boolean makeInactive(String id) {
		vaccineDAO = new VaccineDAOImpl();
		return vaccineDAO.makeInactive(id);
	}

	@Override
	public void importFromFile(String fileName) throws InvalidFormatException, IOException {

		vaccineDAO = new VaccineDAOImpl();
		List<Object[]> sheetData = new ArrayList<>();
		
		File fileData = new File("D:\\DATA\\"+fileName);
		FileInputStream inputStream = new FileInputStream(fileData);

		XSSFWorkbook workbook = new XSSFWorkbook(fileData);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowNum = sheet.getPhysicalNumberOfRows();
		for (int i = 1; i<rowNum-1; i++) {
			Row row = sheet.getRow(i);
			int minColIdx = row.getFirstCellNum();
			int maxColIdx = row.getLastCellNum();

			Object[] rowData = new Object[maxColIdx - minColIdx];

			for (int colIdx = minColIdx; colIdx < maxColIdx; colIdx++) {
				Cell cell = row.getCell(colIdx);
				switch (cell.getCellType()) {
				case STRING:
					rowData[colIdx - minColIdx] = cell.getStringCellValue();
					break;
				case BOOLEAN:
					rowData[colIdx - minColIdx] = cell.getBooleanCellValue();
					break;
				case NUMERIC:
					rowData[colIdx - minColIdx] = cell.getNumericCellValue();
					break;
				case BLANK:
					rowData[colIdx - minColIdx] = null;
					break;
				default:
					break;
				}
			}

			sheetData.add(rowData);
		}
		//sheetData.trimToSize();
		Vaccine vaccine = null;
		for (Object[] rowData : sheetData) {
			vaccine = new Vaccine();
			vaccine.setId((String) rowData[0]);
			vaccine.setName((String) rowData[1]);
			VaccineType type = new VaccineType();
			type.setId((String) rowData[2]);
			vaccine.setType(type);
			vaccine.setNumberOfInject((int) ((double)rowData[3]));
			vaccine.setUseage((String) rowData[4]);
			vaccine.setIndication((String) rowData[5]);
			vaccine.setContraindication((String) rowData[6]);
			if (rowData[7] != null) {
				vaccine.setTimeBegin(LocalDate.parse(rowData[7].toString(),DateTimeFormatter.ofPattern("MM/dd/yyyy")));
			}
			if (rowData[8] != null) {
				vaccine.setTimeEnd(LocalDate.parse(rowData[8].toString(),DateTimeFormatter.ofPattern("MM/dd/yyyy")));
			}
			vaccine.setOrigin((String) rowData[9]);
			String status = (String) rowData[10];
			vaccine.setStatus(status.equalsIgnoreCase("Active"));
			vaccineDAO.saveVaccine(vaccine);
			
		}
		workbook.close();
		inputStream.close();	
	}
}
