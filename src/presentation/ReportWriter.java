package presentation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReportWriter {
	private PrintWriter writer;
	private String FileName;
	
	public ReportWriter(String FileName){
		this.FileName = FileName;
		try {
			writer = new PrintWriter(new FileWriter(this.FileName, true)); 
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
	
	public String getFileName(){
		return this.FileName;
	}
}