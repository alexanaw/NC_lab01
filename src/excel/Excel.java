package excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import analyzer.Analyzer;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.charts.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.charts.XSSFChartLegend;

/*
 * @author Bojchenko
 * @version 9
 *
 * Import statistics to xls-file.
 */
public class Excel {
    public void CreateStatistic () throws IOException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Workbook wb = new XSSFWorkbook();
        Sheet sheet;
        Map<String, Map<String, List<Integer>>> fullStatistic = Analyzer.fullStatistic();
        ArrayList<Integer> timeOfSort = Analyzer.getTimeOfSort();
        ArrayList<Integer> res = Analyzer.getRes();
        int numb = 1;
        for (String sheetName : fullStatistic.keySet()) {//названия страниц
            sheet = wb.createSheet(sheetName);
            Map<String, List<Integer>> sortName = fullStatistic.get(sheetName);

            Row row = sheet.createRow(0);
            row.createCell(0).setCellValue("Count of elements");
            for (int cellCounter = 1; cellCounter <= res.size(); cellCounter++) {
                row.createCell(cellCounter).setCellValue(res.get(cellCounter - 1));
            }
            sheet.autoSizeColumn(0);

            int rowCounter = 1;
            for (String rowName : sortName.keySet()) {
                Row rt = sheet.createRow(rowCounter);
                rt.createCell(0).setCellValue(rowName);
                for (int cellIndex = 1; cellIndex <= res.size(); cellIndex++) {
                    rt.createCell(cellIndex).setCellValue(timeOfSort.get(numb - 1));
                    numb++;
                }
                rowCounter++;
            }

            XSSFDrawing xssfDrawing = (XSSFDrawing) sheet.createDrawingPatriarch();
            XSSFClientAnchor anchor = xssfDrawing.createAnchor(0, 0, 0, 0,
                    0, 8, 10, 18);
            XSSFChart xssfChart = xssfDrawing.createChart(anchor);
            XSSFChartLegend legend = xssfChart.getOrCreateLegend();
            legend.setPosition(LegendPosition.TOP_RIGHT);
            LineChartData data = xssfChart.getChartDataFactory().createLineChartData();
            ChartAxis bottomAxis = xssfChart.getChartAxisFactory().createCategoryAxis(AxisPosition.BOTTOM);
            ValueAxis leftAxis = xssfChart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
            leftAxis.setMinimum(1000);
            ChartDataSource<Number> xs = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(0, 0, 1, res.size()));
            int rowIndex = 1;
            for (String sorter : sortName.keySet()) {
                ChartDataSource<Number> ys = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(rowIndex, rowIndex, 0, res.size()));
                LineChartSeries chartSeries = data.addSeries(xs, ys);
                chartSeries.setTitle(sorter);
                rowIndex++;
            }
            xssfChart.plot(data, bottomAxis, leftAxis);
        }
        FileOutputStream file = new FileOutputStream("C:/Users/Home/IdeaProjects/lab1/lab_01.xls");
        wb.write(file);
        file.close();
    }
}
