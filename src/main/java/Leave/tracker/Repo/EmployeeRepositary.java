package Leave.tracker.Repo;

import Leave.tracker.Model.EmployeeDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepositary extends MongoRepository<EmployeeDetails,String> {

}
