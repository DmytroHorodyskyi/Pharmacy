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

public class PharmacyDAOImpl implements PharmacyDAO{
	@Override
	public Pharmacy getPharmacyById(long idph) {
		  //try-with-resources 
        try (Connection connection = ConnectionFactory.getConnection();
        	 Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM pharmacy WHERE idph=" + idph);
        		)
        	{

            

            if(rs.next())
            {
            	return extractPharmacyFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

      return null;
	}
	@Override
	public List<Pharmacy> getAllPharmacy(){
		//try-with-resources 
        try (Connection connection = ConnectionFactory.getConnection();
        	 Statement stmt = connection.createStatement();
	         ResultSet rs = stmt.executeQuery("SELECT * FROM pharmacy");
        		)
        	{	    	  
	            
	            List<Pharmacy> personReaders = new ArrayList<>(); 

	            while(rs.next())
	            {
	            	Pharmacy personReader = extractPharmacyFromResultSet(rs);
	               personReaders.add(personReader);  
	            }
	            
	            return personReaders; 
	            
	        } catch (SQLException ex) {
	            ex.printStackTrace();

	        }

	      return null;
	}
	@Override
	public boolean insertPharmacy(Pharmacy pharmacy) {
		//try-with-resources 
        try (Connection connection = ConnectionFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO pharmacy(idph, pharmacycol, address, phone, owner) VALUES (?, ?, ?, ?, ?)");
        	)
       	{
        	       	 
	        ps.setLong(1, pharmacy.getIdph());
            ps.setString(2, pharmacy.getPharmacycol());
            ps.setString(3, pharmacy.getAddress());
            ps.setString(4, pharmacy.getPhone()); 
            ps.setString(5, pharmacy.getOwner());
            
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
	public boolean updatePharmacy(Pharmacy pharmacy) {

		  //try-with-resources 
	       try (Connection connection = ConnectionFactory.getConnection();
	    		PreparedStatement ps = connection.prepareStatement("UPDATE pharmacy set pharmacycol = ?, address = ?, phone = ?, owner = ? WHERE idph=?");
		      )
		    {   
	    	    ps.setString(1, pharmacy.getPharmacycol());
	            ps.setString(2, pharmacy.getAddress());
	            ps.setString(3, pharmacy.getPhone());
	            ps.setString(4, pharmacy.getOwner()); 
	            ps.setLong(5, pharmacy.getIdph());
	   

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
	public boolean deletePharmacy(long idph) {
		//try-with-resources 
	       try (Connection connection = ConnectionFactory.getConnection();
	    		PreparedStatement ps = connection.prepareStatement("DELETE FROM pharmacy WHERE idph=?");
		      )
		    {   

	            ps.setLong(1, idph);  

		        int i = ps.executeUpdate(); // for INSERT, UPDATE & DELETE

		      if(i == 1) {

		        return true;

		      }

		    } catch (SQLException ex) {

		        ex.printStackTrace();

		    }

		    return false;


	}
	
	private Pharmacy extractPharmacyFromResultSet(ResultSet rs) throws SQLException {

		Pharmacy pharmacy = new Pharmacy();		
	
		pharmacy.setIdph(rs.getLong("idph"));
		pharmacy.setPharmacycol( rs.getString("pharmacycol") );
		pharmacy.setAddress( rs.getString("address") );  
		pharmacy.setPhone( rs.getString("phone") );                
		pharmacy.setOwner( rs.getString("owner") );

        return pharmacy;

	}

}
