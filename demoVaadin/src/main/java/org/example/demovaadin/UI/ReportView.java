package org.example.demovaadin.UI;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;
import jakarta.annotation.security.RolesAllowed;
import org.example.demovaadin.backend.Book;
import org.example.demovaadin.backend.BookService;
import org.vaadin.reports.PrintPreviewReport;

@Route("report")
@RolesAllowed("ADMIN")
public class ReportView extends VerticalLayout {
    public ReportView(BookService bookService){
        var report = new PrintPreviewReport<>(Book.class, "title", "published", "rating");
        report.setItems(bookService.findAll());
        report.getReportBuilder().setTitle("Books");

        StreamResource pdf = report.getStreamResource("books.pdf", bookService::findAll, PrintPreviewReport.Format.PDF);
        StreamResource csv = report.getStreamResource("books.csv", bookService::findAll, PrintPreviewReport.Format.CSV);

        add(
                new HorizontalLayout(
                        new Anchor(pdf, "PDF"),
                        new Anchor(csv, "CSV")
                ),
                report
        );
     }
}
