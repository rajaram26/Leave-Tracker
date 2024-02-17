package Leave.tracker.Controller;

import Leave.tracker.Model.EmployeeDetails;
import Leave.tracker.Service.EmployeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AdminController {

    @Autowired
    EmployeeDetailsService employeeDetailsService;

    @GetMapping("/testApi")
    public String Test(){
        return "Success API is successfull";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@RequestBody EmployeeDetails employeeDetails){
        String returnString = "";
        if(employeeDetailsService.createEmployee(employeeDetails)){
            returnString = "User added successfully !";
        }else{
            returnString = "User not added successfully !";
        }
        return returnString;
    }
    @GetMapping("/getEmployeeDetails/{employeeId}")
    public EmployeeDetails getEmployeeDetails(@PathVariable(value = "employeeId") String employeeId){
        EmployeeDetails empDetails = employeeDetailsService.getEmployeeDetails(employeeId);
        return empDetails;
    }

}
