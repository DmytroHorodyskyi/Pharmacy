package com.ntu.dao;

import java.util.List;
import com.ntu.domain.Preparations;

public interface PreparationsDAO {
    Preparations getPreparationsById(long idpr);
    List<Preparations> getAllPreparations();
    boolean insertPreparations(Preparations preparations);
    boolean updatePreparations(Preparations preparations);
    boolean deletePreparations(long idpr);
}
