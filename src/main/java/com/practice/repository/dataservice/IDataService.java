package com.practice.repository.dataservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDataService {
	public Connection openConnection() throws SQLException;
	public PreparedStatement getPreparedStatement(String query) throws SQLException;
	public boolean execute(PreparedStatement preparedStatement) throws SQLException;
	public ResultSet getResultSet(PreparedStatement ps) throws SQLException;
    public  void closeConnection() throws SQLException;    
    public  void closeStatements(PreparedStatement st) throws SQLException;    
    public  void closeCursor(ResultSet rs) throws SQLException;  	
    
}
