package presentation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReportWriter {
	private PrintWriter writer;
	
	public ReportWriter(String FileName){
		try {
			writer = new PrintWriter(new FileWriter(FileName, true)); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void WriteReport(String Content) throws IOException{
		writer.printf(Content);
		writer.flush();
	}
	
	public void CloseReport() throws IOException{
		writer.close();
	}
}