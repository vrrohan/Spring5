import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ron.model.Student;

public class JsonToJavaPojo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create jackson's object mapper
		ObjectMapper mapper = new ObjectMapper();

		// read json file & map(convert) to java pojo
		try {
			Student studentObject = mapper.readValue(new File("json-data/sample-lite.json"), Student.class);
			// print firstname and lastname & other student details
			System.out.println("Student Name : " + studentObject.getFirstName() + " " + studentObject.getLastName());
			System.out.println("Student Id : " + studentObject.getId());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
