package org.example.demovaadin.UI;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.auth.AnonymousAllowed;

//maps this view to the root URL path
@Route("")
// annotation allows unauthenticated (anonymous) users to access this view.
// Without this annotation, access might be restricted based on security configurations
@AnonymousAllowed
// VerticalLayout is a Vaadin component that lays out its children vertically
public class HomeView extends VerticalLayout {
    public HomeView(){
//        adds an H1 (header) component to the layout
        add(
                new H1("Home view")
        );
    }
}
