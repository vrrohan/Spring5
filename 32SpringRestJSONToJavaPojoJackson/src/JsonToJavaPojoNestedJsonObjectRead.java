import java.io.File;
import java.io.IOException;
import java.util.StringJoiner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ron.model.Address;
import com.ron.model.Student;

public class JsonToJavaPojoNestedJsonObjectRead {

	// we read nested json objects, if nested object, create another class

	// if a new property is added to json & we don't care about that property, it
	// will throw an exception -
	// com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException:
	// Unrecognized field "company" (class com.ron.model.Student), not marked as
	// ignorable (6 known properties: "lastName", "address", "active", "id",
	// "firstName", "languages"])

	// we can modify our code to ignore unknown properties

	// add annotation - @JsonIgnoreProperties(ignoreUnknown=true) to avoid getting
	// exception
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create jackson's object mapper
		ObjectMapper mapper = new ObjectMapper();

		// read json file & map(convert) to java pojo
		try {
			Student studentObject = mapper.readValue(new File("json-data/sample-full.json"), Student.class);
			// print firstname and lastname & other student details
			System.out.println("Student Name : " + studentObject.getFirstName() + " " + studentObject.getLastName());
			System.out.println("Student Id : " + studentObject.getId());

			// get student address
			Address studentAddress = studentObject.getAddress();
			System.out.println("Student address : " + studentAddress.getCity() + ", " + studentAddress.getState() + ", "
					+ studentAddress.getCountry());

			// get student programming languages
			System.out.print("Student lanaguages : ");
			StringJoiner languageBuilder = new StringJoiner(", ");
			for (String lang : studentObject.getLanguages()) {
				languageBuilder.add(lang);
			}
			System.out.println(languageBuilder.toString());
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
