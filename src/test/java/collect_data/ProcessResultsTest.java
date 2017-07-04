package collect_data;

import org.junit.Test;

import java.sql.*;

public class ProcessResultsTest {
    private Queries query = new Queries();
    ProcessResults results = new ProcessResults();

    @Test
    public void testConnection() {

        String test1 = "cust_highest_single_invoice.sql";
        String test2 = "cust_highest_total_invoices.sql";
        String test3 = "cust_most_invoices.sql";

        try (Connection connection = connectToDatabase();
             Statement statement = connectToDatabase().createStatement();
             ResultSet resultSet = statement.executeQuery(query.getQuery(test3))) {
            executeDatabaseQuery(test3, resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Connection connectToDatabase() throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost/chinook_db";
        Connection connection = DriverManager.getConnection(url, "Jeannette", "password");
        return connection;
    }

    private void executeDatabaseQuery(String property, ResultSet resultSet) throws Exception {
        if (property.equals("cust_highest_single_invoice.sql")) {
            results.resultHighestSingleInvoice(resultSet);
        } else if (property.equals("cust_highest_total_invoices.sql")) {
            results.resultHighestTotalInvoices(resultSet);
        } else {
            results.resultCustomerMostInvoices(resultSet);
        }
    }
}
