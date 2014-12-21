package app

import com.vaadin.grails.ui.VaadinUI
import com.vaadin.server.VaadinRequest
import com.vaadin.ui.Label
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout
import org.springframework.beans.factory.annotation.Autowired

@VaadinUI(path = '/')
class MyUI extends UI {

    @Autowired
    ItemService itemService

    @Override
    protected void init(VaadinRequest r) {

        VerticalLayout layout = new VerticalLayout()
        layout.setMargin(true)

        String homeLabel = itemService.serviceMethod()

        Label label = new Label(homeLabel)
        layout.addComponent(label)

        setContent(layout)
    }
}
