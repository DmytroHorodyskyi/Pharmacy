package com.ntu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.ntu.ConnectionFactory;
import com.ntu.domain.Manufacturer;

public class ManufacturerDAOImpl implements ManufacturerDAO{
	@Override
	public Manufacturer getManufacturerById(long idm){
		   // Connection connection = ConnectionFactory.getConnection();
        //try-with-resources 
      try (Connection connection = ConnectionFactory.getConnection();
      	 Statement stmt = connection.createStatement();
           ResultSet rs = stmt.executeQuery("SELECT * FROM manufacturer WHERE idm=" + idm);
      		)
      	{
          if(rs.next())
          {
          	return extractManufacturerFromResultSet(rs);
          }
      } catch (SQLException ex) {
          ex.printStackTrace();
      }
    return null;
	}
	@Override
	public List<Manufacturer> getAllManufacturer(){
		//try-with-resources 
        try (Connection connection = ConnectionFactory.getConnection();
        	 Statement stmt = connection.createStatement();
	         ResultSet rs = stmt.executeQuery("SELECT * FROM manufacturer");
)        	{	    	  
	            
	            List<Manufacturer> manufacturers = new ArrayList<>();

	            while(rs.next())
	            {
	            	Manufacturer manufacturer = extractManufacturerFromResultSet(rs);
	            	manufacturers.add(manufacturer);
	            }
	            
	            return manufacturers; 
	        } catch (SQLException ex) {
	            ex.printStackTrace();

	        }

	      return null;
	}
	@Override
	public boolean insertManufacturer(Manufacturer manufacturer) {
		//try-with-resources 
        try (Connection connection = ConnectionFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO manufacturer(idm, manufacturercol, phone, email) VALUES (?, ?, ?, ?)");
        	)
       	{
        	       	 
	        ps.setLong(1, manufacturer.getIdm());
            ps.setString(2, manufacturer.getManufacturercol());
            ps.setString(3, manufacturer.getPhone());
            ps.setString(4, manufacturer.getEmail()); 
            
	        int i = ps.executeUpdate(); // for INSERT, UPDATE & DELETE

	      if(i == 1) {

	        return true;

	      }

	    } catch (SQLException ex) {

	        ex.printStackTrace();

	    }

	    return false;
}
	@Override
	public boolean updateManufacturer(Manufacturer manufacturer){
		  //try-with-resources 
	       try (Connection connection = ConnectionFactory.getConnection();
	    		PreparedStatement ps = connection.prepareStatement( " UPDATE manufacturer set manufacturercol = ?, phone = ?,  email = ?   WHERE idm=?");
		      )
		    {   
	    	    ps.setString(1, manufacturer.getManufacturercol());
	            ps.setString(2, manufacturer.getPhone());
	            ps.setString(3, manufacturer.getEmail()); 
	            ps.setLong(4, manufacturer.getIdm());  

		        int i = ps.executeUpdate(); // for INSERT, UPDATE & DELETE

		      if(i == 1) {

		        return true;

		      }

		    } catch (SQLException ex) {

		        ex.printStackTrace();

		    }

		    return false;
	}
	@Override
	public boolean deleteManufacturer(long idm) {
		//try-with-resources 
	       try (Connection connection = ConnectionFactory.getConnection();
	    		PreparedStatement ps = connection.prepareStatement("DELETE FROM manufacturer WHERE idm=?");
		      )
		    {   
	            ps.setLong(1, idm);  

		        int i = ps.executeUpdate(); // for INSERT, UPDATE & DELETE

		      if(i == 1) {

		        return true;

		      }

		    } catch (SQLException ex) {

		        ex.printStackTrace();

		    }

		    return false;

	}

	private Manufacturer extractManufacturerFromResultSet(ResultSet rs) throws SQLException {
		 Manufacturer manufacturer = new Manufacturer();
         manufacturer.setIdm(rs.getLong("idm"));
         manufacturer.setManufacturercol(rs.getString("manufacturercol"));
         manufacturer.setPhone( rs.getString("phone"));                
         manufacturer.setEmail(rs.getString("email"));         
         return manufacturer;
	}
}
