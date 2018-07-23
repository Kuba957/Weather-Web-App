package weather_package.Service;

import weather_package.Model.Database;

import java.util.List;

public interface DatabaseService {
    public List<Database> getAll();
    public void saveItem(Database database);
}
