package com.practice.repository.dataservice;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataServiceImpl implements IDataService{ 

    private Connection con;
    private final String driver = "oracle.jdbc.driver.OracleDriver";
    private final String connectionString = "jdbc:oracle:thin:@//localhost:1522/orcl";
    private final String user = "user";
    private  final String pwd = "user$123";

    public DataServiceImpl() {

    }

    public Connection openConnection() throws SQLException {

        try {
           Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        
        if(con == null || con.isClosed())
         con = DriverManager.getConnection(connectionString, user, pwd);
        
        return con;

    }

    public  void closeConnection() throws SQLException  {
    	if(con != null) {
    		if(!con.isClosed()) {    			
    			con.close();
    		}    		
    	}
    }
    
    public  void closeStatements(PreparedStatement st) throws SQLException  {
    	if(st != null) {
    		if(!st.isClosed()) {    			
    			st.close();
    		}    		
    	}
    }
    
    public  void closeCursor(ResultSet rs) throws SQLException  {
    	if(rs != null) {
    		if(!rs.isClosed()) {    			
    			rs.close();
    		}    		
    	}
    }

	public PreparedStatement getPreparedStatement(String query) throws SQLException {
		PreparedStatement preparedStatement=null;
		if(con != null) {
    		if(!con.isClosed()) {    			
    			preparedStatement = con.prepareStatement(query);
    		}    		
    	}
		return preparedStatement;
	}
	
	public boolean execute(PreparedStatement preparedStatement) throws SQLException {
		int rowCountUpdated=0;
		
		if(con != null) {
    		if(!con.isClosed()) {    			
    			preparedStatement.execute();
    			rowCountUpdated = preparedStatement.getUpdateCount();
    		}    		
    	}
		return rowCountUpdated>0;
	}

	public ResultSet getResultSet(PreparedStatement ps) throws SQLException {
		ResultSet rs = ps.executeQuery();
		return rs;
	}  	
    	
    
}