package com.ntu.dao;
import java.util.List;
import com.ntu.domain.Pharmacy;

public interface PharmacyDAO {
	Pharmacy getPharmacyById(long idph);
	List<Pharmacy> getAllPharmacy();
	boolean insertPharmacy(Pharmacy pharmacy);
	boolean updatePharmacy(Pharmacy pharmacy);
	boolean deletePharmacy(long idph);
}
