package com.xyq.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.xyq.service.DutyService;
import com.xyq.service.impl.DutyServiceImpl;
import com.xyq.util.TransUtil;
import com.xyq.vo.DutyVo;


public class DutyServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 查询员工的签到状态
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void findDutyList(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		//调用Service层的方法
		DutyService dutyService = new DutyServiceImpl();
		List<DutyVo> dutyVoList = dutyService.getDudyList();
		//转发到dutyList.jsp界面
		req.setAttribute("dutyVoList", dutyVoList);
		req.getRequestDispatcher("/duty/dutyList.jsp").forward(req, resp);
	}
	
	public void exportExcel(HttpServletRequest req, HttpServletResponse resp){
		//调用service层的方法
		DutyService dutyService = new DutyServiceImpl();
		List<DutyVo> dutyVoList = dutyService.getDudyList();
		
		//使用POI
        // 创建一个Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建一个工作表
        HSSFSheet sheet = workbook.createSheet("签到表一");
        
        /**
         *  可以合并行和列
         */
        CellRangeAddress region = new CellRangeAddress(0, // first row
                0, // last row
                0, // first column
                5 // last column
        );
        sheet.addMergedRegion(region);
        
        // 设置单元格格式居中
        HSSFCellStyle cellStyle = workbook.createCellStyle();
    	cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        
//      添加表格头 
        /**
         * 
         * 创建 表的行  第一行 
         */
        HSSFRow hssfRow = sheet.createRow(0);
        /**
         * 创建单元格  第一个单元格
         */
        HSSFCell headCell = hssfRow.createCell(0);
        /**
         * 添加内容
         */
        headCell.setCellValue("员工签到列表");
        headCell.setCellStyle(cellStyle);
        
        // 添加表头行
        hssfRow = sheet.createRow(1);
        // 添加表头内容
        headCell = hssfRow.createCell(0);
        headCell.setCellValue("用户名");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(1);
        headCell.setCellValue("真实姓名");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(2);
        headCell.setCellValue("所属部门");
        headCell.setCellStyle(cellStyle);
        
        headCell = hssfRow.createCell(3);
        headCell.setCellValue("出勤日期");
        headCell.setCellStyle(cellStyle);
        
        headCell = hssfRow.createCell(4);
        headCell.setCellValue("签到时间");
        headCell.setCellStyle(cellStyle);
        
        headCell = hssfRow.createCell(5);
        headCell.setCellValue("签退时间");
        headCell.setCellStyle(cellStyle);

        // 添加数据内容
        for (int i = 0; i < dutyVoList.size(); i++) {
            hssfRow = sheet.createRow((int) i + 2);
            DutyVo dutyVo = dutyVoList.get(i);

            // 创建单元格，并设置值
            HSSFCell cell = hssfRow.createCell(0);
            cell.setCellValue(dutyVo.getEmpid());
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(1);
            cell.setCellValue(dutyVo.getRealname());
            cell.setCellStyle(cellStyle);
            
            cell = hssfRow.createCell(2);
            cell.setCellValue(dutyVo.getDeptname());
            cell.setCellStyle(cellStyle);
            
            cell = hssfRow.createCell(3);
            if(dutyVo.getDtdate() != null ){
            	cell.setCellValue(TransUtil.date2str(dutyVo.getDtdate()));
            }
            cell.setCellStyle(cellStyle);
            
            
            cell = hssfRow.createCell(4);
            cell.setCellValue(dutyVo.getSignintime());
            cell.setCellStyle(cellStyle);
            
            cell = hssfRow.createCell(5);
            cell.setCellValue(dutyVo.getSignouttime());
            cell.setCellStyle(cellStyle);
        }

        // 保存Excel文件
        try {
        	//设置响应类型
        	resp.setContentType("application/vnd.ms-excel");
        	//设置响应头信息
        	resp.setHeader("Content-Disposition", "attachment;filename=dutyList.xls");
            ServletOutputStream outputStream = resp.getOutputStream();
            workbook.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
