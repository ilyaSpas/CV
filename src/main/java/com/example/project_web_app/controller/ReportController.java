package com.example.project_web_app.controller;

import com.example.project_web_app.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

@Controller
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/events/{id}/download")
    public synchronized void downloadFile(HttpServletResponse response,
                                          @PathVariable("id") Long id) {
        String report = reportService.getReportById(id);
        try(OutputStream outputStream = response.getOutputStream()) {
            response.setContentType("text/plain");
            response.setHeader("Content-Disposition", "attachment; filename=TEST.xlsx");
            outputStream.write(report.getBytes(Charset.forName("UTF-8")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
