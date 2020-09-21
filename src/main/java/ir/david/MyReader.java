package ir.david;

import ir.david.model.Person;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */
public class MyReader implements ItemReader<List<Person>> {
    private int index = 0;
    private DataSource dataSource;
    private String sql;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    @Override
    public List<Person> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        index++;

        if (index > 10) {
            return null;
        }

        Connection connection = dataSource.getConnection();

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(this.sql);

        while (rs.next()) {
            System.out.print("Column 1 returned ");
            System.out.println(rs.getString(1));
        }

        rs.close();
        st.close();

        return null;
    }
}
