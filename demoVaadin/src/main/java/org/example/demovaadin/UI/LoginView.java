package org.example.demovaadin.UI;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.router.Route;

//extends Composite<LoginOverlay>, meaning it is a composite component based on,
// LoginOverlay: Vaadin component that provides a pre-designed login form overlay
@Route("login")
public class LoginView extends Composite<LoginOverlay> {
//    Constructor to sets up the LoginOverlay component:
    public LoginView(){
//        This opens the login overlay when the view is loaded
        getContent().setOpened(true);
//         sets the action URL for the login form.
//         When the user submits the login form, the form data will be posted to the /login URL.
//         This action URL should correspond to the URL that Spring Security is configured
//         to handle login requests
        getContent().setAction("login");
    }
}
