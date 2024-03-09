package application;


import java.util.Arrays;

import application.model.ColumnDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class SampleController {
	
	@FXML
	private Button btnGenerate;
	
	@FXML
	private TextArea input;
	
	@FXML
	private Button btnClear;
	
	public void clear(ActionEvent e) {
		input.setText("");
	}
	
	public void generate(ActionEvent e) {
		String textArea = input.getText();
		String[] content = textArea.split(System.lineSeparator());
		StringBuilder sb = new StringBuilder();
		for (String row : content) {
			row = row.trim();
			if (isSkip(row)) continue;
			ColumnDto columnDto = getColumn(row);
			String convertStr = convertToLaravel(columnDto);
			sb.append(convertStr);
		}
		input.setText(sb.toString());
	}
	
	private String convertToLaravel(ColumnDto columnDto) {
		// $table->string('ten_kh')->nullable();
		String res = "";
		res += "$table";
		res += "->";
		res += columnDto.getDataType();
		res += "('" + columnDto.getColumnName() + "')";
		if (columnDto.getConstraint().isEmpty()) {
			if (columnDto.getDataType().equals("timestamp")) {
				res += "->";
				res += "useCurrent()";
			}
		} else {
			res += "->";
			res += "nullable()";
		}
		
		res += ";";
		res += System.lineSeparator();
		return res;
	}
	
	private boolean isComment(String line) {
		return line.startsWith("--") || line.isEmpty();
	}
	
	private boolean isSkip(String line) {
		return isComment(line) || line.startsWith("CREATE TABLE") 
				|| line.startsWith("CONSTRAINT") || line.matches("[\\W]*");
	}
	
	private ColumnDto getColumn(String line) {
		String[] arr = line.split("\\s+");
		ColumnDto columnDto = new ColumnDto();
		columnDto.setColumnName(arr[0]);
		columnDto.setDataType(getDataType(arr[1]));
		columnDto.setConstraint(getConstraint(arr[arr.length - 2] ,arr[arr.length - 1]));
		
		return columnDto;
	}
	
	private String getConstraint(String beforeConstraint, String constraint) {
		if (beforeConstraint.trim().equals("NOT")) return "";
		// Remove other character
		String res = constraint.trim().replaceAll("([^A-Z\\s]*)", "");
		
		return res;
	}
	
	private String getDataType(String dataType) {
		dataType = dataType.trim().replaceAll("([^a-z]*)", "");
		String res = "";
		switch(dataType) {
		case "int":
			res = "integer";
			break;
		case "datetime":
			res = "timestamp";
			break;
		case "nvarchar":
		case "nchar":
			res = "string";
			break;
		default:
			res = "string";
		}
		return res;
	}
}
