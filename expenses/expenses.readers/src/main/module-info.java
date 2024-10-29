module expenses.application {
    requires java.base;

    exports com.example.expenses.readers;
    exports com.example.expenses.file;
    exports com.example.expenses.http;
}