package com.ntu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.ntu.ConnectionFactory;
import com.ntu.domain.Pharmacy;
import com.ntu.domain.Preparations;
import com.ntu.domain.Manufacturer;

public class PreparationsDAOImpl implements PreparationsDAO{
	@Override
	public Preparations getPreparationsById(long idpr) {
        //try-with-resources 
      try (Connection connection = ConnectionFactory.getConnection();
      	 Statement stmt = connection.createStatement();
           ResultSet rs = stmt.executeQuery("SELECT * FROM preparation WHERE idpr=" + idpr);
      		)
      	{
          if(rs.next())
          {
          	return extractPreparationFromResultSet(rs);
          }
      } catch (SQLException ex) {
          ex.printStackTrace();

      }
    return null;	
    }
	@Override
	public List<Preparations> getAllPreparations(){
		   //try-with-resources 
        try (Connection connection = ConnectionFactory.getConnection();
        	 Statement stmt = connection.createStatement();
	         ResultSet rs = stmt.executeQuery("SELECT * FROM preparation");
        		)
        	{	    	  
	            
	            List<Preparations> preparations = new ArrayList<>(); 

	            while(rs.next())
	            {
	            	Preparations preparation = extractPreparationFromResultSet(rs);
	            	preparations.add(preparation);  
	            }
	            
	            return preparations;
	            
	        } catch (SQLException ex) {
	            ex.printStackTrace();

	        }

	      return null;
    }
	@Override
	public boolean insertPreparations(Preparations preparations) {
    	//try-with-resources 
        try (Connection connection = ConnectionFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO preparation(ipr, preparationscol, price, quantity, idph, idm) VALUES (?, ?, ?, ?, ?, ?)");
        	)
       	{
      
	        ps.setLong(1, preparations.getIdpr());
            ps.setString(2, preparations.getPreparationscol());
            ps.setString(3, preparations.getPrice());
            ps.setString(4, preparations.getQuantity());    
            ps.setLong(5, preparations.getPharmacy().getIdph());
            ps.setLong(6, preparations.getManufacturer().getIdm());
	        int i = ps.executeUpdate(); // for INSERT, UPDATE & ELETE

	      if(i == 1) {

	        return true;

	      }

	    } catch (SQLException ex) {

	        ex.printStackTrace();

	    }

	    return false;
	}
@Override
public boolean updatePreparations(Preparations preparations) {
	  try (Connection connection = ConnectionFactory.getConnection();
	    		PreparedStatement ps = connection.prepareStatement(" UPDATE preparation set preparationscol = ?, price = ?, quantity = ?, idph = ?, idm = ? WHERE idpr=?");
			  )
		    {   
	    	
	    	     ps.setString(1, preparations.getPreparationscol());
	             ps.setString(2, preparations.getPrice());
	             ps.setString(3, preparations.getQuantity());
	             ps.setLong(4, preparations.getPharmacy().getIdph());      
	             ps.setLong(5, preparations.getManufacturer().getIdm());  
	             ps.setLong(6, preparations.getIdpr());  

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
public boolean deletePreparations(long idpr) {
	 //try-with-resources 
    try (Connection connection = ConnectionFactory.getConnection();
 		PreparedStatement ps = connection.prepareStatement("DELETE FROM preparation WHERE idpr=?");
	      )
	    {   

         ps.setLong(1, idpr);  

	        int i = ps.executeUpdate(); // for INSERT, UPDATE & DELETE

	      if(i == 1) {

	        return true;

	      }

	    } catch (SQLException ex) {

	        ex.printStackTrace();

	    }

	    return false;
}
	private Preparations extractPreparationFromResultSet(ResultSet rs) throws SQLException {
		
		PharmacyDAO pharmacyDAO =  new PharmacyDAOImpl();	
    	ManufacturerDAO manufacturerDAO =  new ManufacturerDAOImpl();
    	
    	Pharmacy pharmacy = pharmacyDAO.getPharmacyById(rs.getLong("idph"));
    	Manufacturer manufacturer = manufacturerDAO.getManufacturerById(rs.getLong("idm"));

    	Preparations preparations = new Preparations();
    	preparations.setIdpr(rs.getLong("idpr"));
    	preparations.setPreparationscol(rs.getString("preparationscol"));
    	preparations.setPrice( rs.getString("price"));                
    	preparations.setQuantity( rs.getString("quantity"));
    	preparations.setPharmacy(pharmacy); 
    	preparations.setManufacturer(manufacturer); 
    
        return preparations;
	}
}






