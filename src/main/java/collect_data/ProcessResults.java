package collect_data;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProcessResults {

    public void resultHighestSingleInvoice(ResultSet rs) throws Exception {

        while (rs.next())
        {
            System.out.println("Highest Single Invoice");
            System.out.println("----------------------");
            System.out.print("Total: ");
            System.out.println(rs.getDouble("Total"));
            System.out.print("FirstName: ");
            System.out.println(rs.getString("FirstName"));
            System.out.print("LastName: ");
            System.out.println(rs.getString("LastName"));
            System.out.println();
        }
    }

    public void resultHighestTotalInvoices(ResultSet rs) throws Exception {

        while (rs.next())
        {
            System.out.println("Highest Total Invoices");
            System.out.println("----------------------------");
            System.out.print("Total of Users ProcessResults: ");
            System.out.println(rs.getDouble("sum_totals"));
            System.out.print("FirstName: ");
            System.out.println(rs.getString("FirstName"));
            System.out.print("LastName: ");
            System.out.println(rs.getString("LastName"));
            System.out.print("CustomerId: ");
            System.out.println(rs.getString("CustomerId"));
            System.out.println();
        }
    }

    public void resultCustomerMostInvoices(ResultSet rs) throws Exception {
        List<String> customers = new ArrayList<>();

        while (rs.next())
        {
            customers.add("Name: " + rs.getString("FirstName") + " "
                    + rs.getString("LastName") + "    CustomerId: " + rs.getString("CustomerId")
                    + "    Number of ProcessResults: " + rs.getString("counting"));
        }

        System.out.println("Customer With Most ProcessResults");
        System.out.println("---------------------------------");
        for (String customer : customers) {
            System.out.println(customer);
        }
        System.out.println();
    }
}
