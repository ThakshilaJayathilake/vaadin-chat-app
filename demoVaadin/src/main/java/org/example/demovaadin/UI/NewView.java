package org.example.demovaadin.UI;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;

import java.awt.*;

@Route("new")
@RolesAllowed("ADMIN")
public class NewView extends VerticalLayout {

    private TextField title = new TextField("Title");
    private DatePicker published = new DatePicker("Published");

    private IntegerField rating = new IntegerField("Rating");


    public NewView(){
        add(
                new H1("New Book"),
                new FormLayout(title, published, rating),
                new Button("Save")
        );
    }
}
