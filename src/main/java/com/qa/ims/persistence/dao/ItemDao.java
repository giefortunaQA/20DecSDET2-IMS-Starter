package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DatabaseUtilities;

public class ItemDao implements IDomainDao<Item>{

	public static final Logger LOGGER = LogManager.getLogger();
	
    @Override
    public Item create(Item item) {
        try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                PreparedStatement statement = connection
                        .prepareStatement("INSERT INTO items(name,qty,price) VALUES (?, ?,?)");) {
            statement.setString(1, item.getName());
            statement.setLong(2, item.getQty());
            statement.setDouble(3, item.getPrice());
            statement.executeUpdate();
            return readLatest();
        } catch (Exception e) {
        	LOGGER.debug(e);
        	LOGGER.error(e.getMessage());
        }
        return null;
    }
    
    public Item readLatest() {
        try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM items ORDER BY iid DESC LIMIT 1");) {
            resultSet.next();
            return modelFromResultSet(resultSet);
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }
    
    @Override
	public List<Item> readAll() {
		// TODO Auto-generated method stub
		return null;
	}
    
	@Override
	public Item update(Item t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Item modelFromResultSet(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
