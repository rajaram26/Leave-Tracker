package Leave.tracker.Service;

import Leave.tracker.Model.EmployeeDetails;
import Leave.tracker.Repo.EmployeeRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EmployeeDetailsService {

    @Autowired
    EmployeeRepositary employeeRepositary;

    public boolean createEmployee(EmployeeDetails employeeDetails){
        try{
            this.employeeRepositary.save(employeeDetails);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public EmployeeDetails getEmployeeDetails(String id){
        Optional<EmployeeDetails> employeeDetails = null;
        try{
            employeeDetails = this.employeeRepositary.findById(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return employeeDetails.get();
    }
}
