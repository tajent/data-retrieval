package collect_data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

public class Queries {

    private final String propertyFileName = "queries.properties";
    private Properties properties;

    public Properties getQueries() throws SQLException {
        String filePath = "/Users/Jeannette/Projects/chinook_db_project/src/main/java/sql_queries/";

        if(properties == null){
            properties = new Properties();

            try {
                InputStream is = new FileInputStream(filePath + propertyFileName);
                properties.load(is);
            } catch (IOException e) {
                throw new SQLException("Cannot load properties file: " + propertyFileName + "\n" + e.getMessage());
            }
        }
        return properties;
    }

    public String getQuery(String queryKey) throws SQLException {
        return getQueries().getProperty(queryKey);
    }
}
