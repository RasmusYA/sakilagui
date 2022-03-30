//module com.grupp2.sakilagui {
//    requires javafx.controls;
//    requires javafx.fxml;
//
//
//    opens com.grupp2.sakilagui to javafx.fxml;
//    exports com.grupp2.sakilagui;
//}

open module com.grupp2.sakilagui {
        requires javafx.controls;
        requires javafx.fxml;
        requires java.persistence;
        requires java.sql;
        requires org.hibernate.orm.core;
        requires java.sql.rowset;

        //opens edu.petersson.wigellsconcert to javafx.fxml;
        exports com.grupp2.sakilagui;
}