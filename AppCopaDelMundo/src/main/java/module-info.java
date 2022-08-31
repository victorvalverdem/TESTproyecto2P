module com.vmvm.appcopadelmundo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.vmvm.appcopadelmundo to javafx.fxml;
    exports com.vmvm.appcopadelmundo;
}
