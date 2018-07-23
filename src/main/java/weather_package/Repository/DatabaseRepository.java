package weather_package.Repository;

import weather_package.Model.Database;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("databaseRepository")
public interface DatabaseRepository extends JpaRepository<Database,Long> {

}
