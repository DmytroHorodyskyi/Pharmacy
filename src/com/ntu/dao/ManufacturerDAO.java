package com.ntu.dao;

import java.util.List;
import com.ntu.domain.Manufacturer;

public interface ManufacturerDAO {
	Manufacturer getManufacturerById(long idm);
	List<Manufacturer> getAllManufacturer();
    boolean insertManufacturer(Manufacturer manufacturer);
    boolean updateManufacturer(Manufacturer manufacturer);
    boolean deleteManufacturer(long idm);
}
