module com.example.demologindashboard {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demologindashboard to javafx.fxml;
    exports com.example.demologindashboard;
}