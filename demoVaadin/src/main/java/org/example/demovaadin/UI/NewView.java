package org.example.demovaadin.UI;

import com.vaadin.collaborationengine.CollaborationBinder;
import com.vaadin.collaborationengine.UserInfo;
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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@Route("new")
@RolesAllowed("ADMIN")
public class NewView extends VerticalLayout {

    private TextField title = new TextField("Title");
    private DatePicker published = new DatePicker("Published");

    private IntegerField rating = new IntegerField("Rating");


    public NewView(BookService service){

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        var userInfo = new UserInfo(username, username);
        var binder = new CollaborationBinder<>(Book.class, userInfo);
        binder.bindInstanceFields(this);
        binder.setTopic("new-book", () -> new Book());

        add(
                new H1("New Book"),
                new FormLayout(title, published, rating),
                new Button("Save", event -> {
                    var book = new Book();
                    binder.writeBeanIfValid(book);
                    service.add(book);
                    Notification.show("Book saved");
                    binder.reset(new Book());
                })
        );
    }
}
