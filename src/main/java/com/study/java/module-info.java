module com.study.java {
    // Exporta APIs públicas

    // Requisições de módulos externos
    requires java.base; // sempre incluso por padrão (opcional declarar)
    requires java.desktop; // para Swing/AWT
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires jakarta.persistence;
    requires spring.boot.autoconfigure;
    requires spring.boot;

}
