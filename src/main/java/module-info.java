module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;

    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
    exports com.example.demo.CellPackage;
    opens com.example.demo.CellPackage to javafx.fxml;
    exports com.example.demo.GamePackage;
    opens com.example.demo.GamePackage to javafx.fxml;
    exports com.example.demo.leaderboardPackage;
    opens com.example.demo.leaderboardPackage to javafx.fxml;
    exports com.example.demo.PlayersPackage;
    opens com.example.demo.PlayersPackage to javafx.fxml;
}