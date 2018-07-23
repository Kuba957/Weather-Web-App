package weather_package.Service.Impl;

import weather_package.Model.Database;
import weather_package.Repository.DatabaseRepository;
import weather_package.Service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("databaseService")
public class DatabaseServiceImpl implements DatabaseService {

    @Autowired
    private DatabaseRepository databaseRepository;

    @Override
    public List <Database> getAll(){
        return databaseRepository.findAll();
    }

    @Override
    public void saveItem(Database database)
    {
        databaseRepository.save(database);
    }
}
