package org.example.demovaadin.UI;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import org.example.demovaadin.backend.Book;
import com.vaadin.flow.data.binder.Binder;
import org.example.demovaadin.backend.BookService;

@Route("new")
@RolesAllowed("ADMIN")
public class NewView extends VerticalLayout {

    private TextField title = new TextField("Title");
    private DatePicker published = new DatePicker("Published");

    private IntegerField rating = new IntegerField("Rating");


    public NewView(BookService service){

        var binder = new Binder<>(Book.class);
        binder.bindInstanceFields(this);
        add(
                new H1("New Book"),
                new FormLayout(title, published, rating),
                new Button("Save", event -> {
                    var book = new Book();
                    binder.writeBeanIfValid(book);
                    service.add(book);
                    Notification.show("Book saved");
                    binder.readBean(new Book());
                })
        );
    }
}
