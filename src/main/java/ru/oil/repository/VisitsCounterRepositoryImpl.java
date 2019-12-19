package ru.oil.repository;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static ru.oil.utils.ConnectionUtils.getConnection;

/**
 * @author Iskander Valiev
 * created by isko
 * on 12/19/19
 */
public class VisitsCounterRepositoryImpl implements VisitsCounterRepository {

    private static Logger logger = Logger.getLogger(VisitsCounterRepository.class);

    //language=SQL
    private static final String UPDATE_VISITS_COUNT_VALUE = "UPDATE visits_count set count = count + 1";

    //language=SQL
    private static final String INSERT_FIRST_ROW = "INSERT INTO visits_count (count) values (0)";

    //language=SQL
    private static final String SELECT_VISITS_COUNT = "SELECT count FROM visits_count";

    public void addVisit() {
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_VISITS_COUNT_VALUE);
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            logger.error("Class not found exception has been occurred");
        } catch (SQLException e) {
            logger.error("SQLException: {}", e);
        }
    }

    @Override
    public Long getCount() {
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_VISITS_COUNT);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getLong("count");
        } catch (ClassNotFoundException e) {
            logger.error("Class not found exception has been occurred");
        } catch (SQLException e) {
            logger.error("SQLException", e);
        }
        return null;
    }
}
