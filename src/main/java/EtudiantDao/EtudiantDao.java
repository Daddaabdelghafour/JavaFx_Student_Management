package EtudiantDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import DatabaseManager.databaseManager;
import Models.Etudiant;

public interface EtudiantDao {


    public boolean saveStudent(Etudiant e);
    
    public List<Etudiant> SelectAll();
}