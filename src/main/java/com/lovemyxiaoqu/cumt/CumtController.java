package com.lovemyxiaoqu.cumt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lovemyxiaoqu.cumt.pojo.ErrorPojo;
import com.lovemyxiaoqu.cumt.pojo.LrjExcelDataPojo;


@Controller
@EnableAutoConfiguration
@RequestMapping(value="/cumt")
@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 20, maxRequestSize = 1024 * 1024 * 200)
public class CumtController {
	
	@RequestMapping(value="/lrjexceldata", method = { RequestMethod.POST })
	public ResponseEntity<Object> index(@RequestParam String params,
			@RequestParam("file") MultipartFile file,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
	
		ErrorPojo error = null;
		boolean isError = false;
		try {
			ObjectMapper mapper = new ObjectMapper();  
			LrjExcelDataPojo param = mapper.readValue(params.toString(), LrjExcelDataPojo.class);  
			String[] date = param.getModifyDate().split("-");
			String oldFileName = file.getOriginalFilename();
			oldFileName = new String(oldFileName.getBytes(), "UTF-8");
			String[] oldFileNameArr = oldFileName.split("\\.");
			String oldDate = oldFileNameArr[0].substring(oldFileNameArr[0].length()-10, oldFileNameArr[0].length());
			
			String newFileName = oldFileNameArr[0].replaceAll(oldDate, param.getModifyDate()) + "." +oldFileNameArr[1];
			newFileName = new String(newFileName.getBytes(), "UTF-8");
			error = new ErrorPojo(); 
			
			HSSFWorkbook wb = new HSSFWorkbook(file.getInputStream());
			HSSFSheet sheet = wb.getSheetAt(0);
			
			//获取总行数
			int rowNum = sheet.getLastRowNum();//索引从0开始
			int columnNum;
			if(rowNum < 3){//少于4行
				isError = true;
				error.setCode(1);
				error.setErrorMessage("文件“"+file.getName()+"”中出现格式错误（Excel少于4行），请检查后重新上传！");
			}else{
				//获取总列数
				columnNum = sheet.getRow(1).getPhysicalNumberOfCells();
				if(columnNum < 8){
					isError = true;
					error.setCode(1);
					error.setErrorMessage("文件“"+file.getName()+"”中出现格式错误（Excel少于9列），请检查后重新上传！");
				}else{
					//仪器型号:  Trimble DiNi 03    监测日期:  2015  年  07  月  11  日      天气:    晴
					String oldDateStr = sheet.getRow(1).getCell(0).getStringCellValue();
					String[] oldDateStrArr = oldDateStr.split(":");
					String newDateStr = oldDateStrArr[0] + ":" + oldDateStrArr[1] + ":    "
										+ date[0] + "  年  " + date[1] + "  月  " + date[2] + "  日    " + "    天气:" + oldDateStrArr[3];
					sheet.getRow(1).getCell(0).setCellValue(newDateStr);
					
					//变形速率(mm/天)
					Float random = param.getRandomMax()-param.getRandomMin();
					String BXSLFormula = param.getRandomMin().toString()+"+RAND()*("+random.toString()+")";
					for(int j = 3; j < rowNum-1; j++){
						sheet.getRow(j).getCell(5).setCellFormula(BXSLFormula);
					}
					
					//本次沉降量(mm)
					for(int j = 3; j < rowNum-1; j++){
						String BCCDLtTargetColumn = "F";
						int targetRow = j+1;
						String BCCDLFormula = BCCDLtTargetColumn + targetRow;
						sheet.getRow(j).getCell(2).setCellFormula(BCCDLFormula);
					}
					//前次累计  沉降量(mm)
					for(int j = 3; j < rowNum-1; j++){
						String QCLJCDLTargetColumnE = "E";
						String QCLJCDLTargetColumnC = "C";
						int targetRow = j+1;
						QCLJCDLTargetColumnE = QCLJCDLTargetColumnE + targetRow;
						QCLJCDLTargetColumnC = QCLJCDLTargetColumnC + targetRow;
						sheet.getRow(j).getCell(3).setCellFormula(QCLJCDLTargetColumnE+"-"+QCLJCDLTargetColumnC);
					}
					
					response.setContentType("application/vnd.ms-excel");     
					response.setHeader("Content-disposition", "attachment;filename=" + newFileName);
					
					//
					//String serverPath = System.getProperty("user.dir");
					String serverPath = request.getSession().getServletContext().getRealPath("");
					if (!serverPath.endsWith(File.separator)) {
						serverPath = serverPath + File.separator;
				    }
					SimpleDateFormat df = new SimpleDateFormat("yyyyMMddmmss");//设置日期格式
					String dateUuid = df.format(new Date());
					File newFile = new File(serverPath+"\\"+dateUuid);  
					if(!newFile.exists()){  
						newFile.mkdir();  
					}
					FileOutputStream out = new FileOutputStream(serverPath+"\\"+dateUuid+"\\"+newFileName);  
					
					
					wb.write(out);  
					out.flush();          
					out.close();
					
					String newFilePath = serverPath+"\\"+dateUuid+"\\"+newFileName;
					error.setCode(0);
					error.setErrorMessage(newFilePath);
				}
			}
		} catch (Exception e) {
			isError = true;
			error.setCode(1);
			error.setErrorMessage("文件格式错误！");
			e.printStackTrace();
		}
		
        if(isError){
        	return  new ResponseEntity<Object>(new Resource<ErrorPojo>(error), HttpStatus.BAD_REQUEST);
        }else{
        	return  new ResponseEntity<Object>(new Resource<ErrorPojo>(error), HttpStatus.OK);
        }
		
		
	}
	
	
}
