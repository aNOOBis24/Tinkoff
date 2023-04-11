package ru.tinkoff.edu.scrapper.database;

import org.junit.jupiter.api.Test;
import ru.tinkoff.edu.scrapper.utils.IntegrationEnvironment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DatabaseTest extends IntegrationEnvironment {

    @Test
    void migrationChatTest() {

        try (Connection connection = POSTGRE_SQL_CONTAINER.createConnection("")) {

            List<String> expectedColumns = List.of("id", "username");


            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM chat");
            ResultSet resultSet = preparedStatement.executeQuery();


            assertThat(resultSet.getMetaData().getColumnCount()).isEqualTo(expectedColumns.size());
            for (int i = 1; i <= expectedColumns.size(); i++) {
                assertTrue(expectedColumns.contains(resultSet.getMetaData().getColumnName(i)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void migrationLinkTest() {
        try (Connection connection = POSTGRE_SQL_CONTAINER.createConnection("")) {

            List<String> expectedColumns = List.of("id", "url", "updated_at");


            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM link");
            ResultSet resultSet = preparedStatement.executeQuery();


            assertThat(resultSet.getMetaData().getColumnCount()).isEqualTo(expectedColumns.size());
            for (int i = 1; i <= expectedColumns.size(); i++) {
                assertTrue(expectedColumns.contains(resultSet.getMetaData().getColumnName(i)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}