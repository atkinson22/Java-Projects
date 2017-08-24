import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class comparaPlanilhas {

	
	public static void main(String[] args)

			throws BiffException, IOException {

		Map<String,Cell> planilha1 = new HashMap<String, Cell>();
		Map<String,Cell> planilha2 = new HashMap<String, Cell>();
		comparaPlanilhas teste = new comparaPlanilhas();
		planilha1 = teste.lePlanilha("C:/Users/agoncalves.T53/Documents/export AD.xls", planilha1);
		planilha2 = teste.lePlanilha("C:/Users/agoncalves.T53/Documents/export AD2.xls", planilha2);
		
		for (String chave  : planilha1.keySet()) {
		    Cell c1 = planilha1.get (chave );
		    Cell c2 = planilha2.get (chave );
		    teste.comparaDados(c1.getContents(), c2.getContents(), chave);
		}   
			
	}
	

	public Map<String,Cell> lePlanilha(String caminho, Map<String, Cell> planilha) throws BiffException, IOException {

		Workbook workbook = Workbook.getWorkbook(new File(caminho));
		Sheet sheet = workbook.getSheet(0);

		int linhas = sheet.getRows();

		for (int i = 0; i < linhas; i++) {

			Cell celula1 = sheet.getCell(0, i);
			//Cell celula2 = sheet.getCell(1, i);

			System.out.println("samAccountName: " + celula1.getContents());
			
			planilha.put("celula"+i, celula1);
			//this.celula2ExternoPlanilha1 = celula2;
		}
		//this.linhasExterno = linhas;
		//this.sheetExterno = sheet;
		//this.workbookExterno = workbook;
		return planilha;
		
	}


	public void comparaDados(String campo1, String campo2, String chave) {
		
	if (!campo1.equals(campo2)){
		System.out.println("Campos diferentes: "+chave+"\n valor1: "+campo1+"\n valor2: "+campo2);
	}
	}

}
