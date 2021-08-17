package fa.appcode.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.Part;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import fa.appcode.common.valueobjects.VaccineVo;
import fa.appcode.web.entities.Vaccine;

public interface VaccineService {
	List<VaccineVo> findAll();
	
	Vaccine findById(String id);
	
	void create(Vaccine vaccine) throws Exception;
	
	void save(Vaccine vaccine)throws Exception;
	
	boolean makeInactive(String id);
	
	void importFromFile(String fileName) throws FileNotFoundException, InvalidFormatException, IOException;
}
