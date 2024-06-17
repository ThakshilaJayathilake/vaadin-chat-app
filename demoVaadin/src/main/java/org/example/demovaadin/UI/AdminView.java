package org.example.demovaadin.UI;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import jakarta.annotation.security.RolesAllowed;
import org.example.demovaadin.backend.Book;
import org.example.demovaadin.backend.BookService;
import org.vaadin.crudui.crud.impl.GridCrud;

@Route("admin")
@RolesAllowed("ADMIN")
public class AdminView extends VerticalLayout {
    public AdminView(BookService service){
//        Creates a GridCrud component for managing Book entities.
//        This provides a UI for CRUD operations on books.
//        Vaadin uses reflection to inspect the class and determine the types of its properties
        var crud = new GridCrud<>(Book.class, service);
        crud.getGrid().setColumns("title", "published", "rating");
        crud.getCrudFormFactory().setVisibleProperties("title", "published", "rating");
        crud.setAddOperationVisible(false);
        crud.getCrudLayout().addToolbarComponent(new RouterLink("New book", NewView.class));

        add(
                new H1("Admin view"),
                crud
        );
    }
}
