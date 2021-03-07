package sample.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import sample.dto.EmployeeDto;
import sample.handler.DeleteEmployeeHandler;
import sample.handler.SaveEmployeeHandler;

import java.util.Arrays;
import java.util.List;

public class EmployeeRestClient {

    private static final String EMPLOYEE_URL = "http://localhost:8080/employees";

    private final RestTemplate restTemplate;


    public EmployeeRestClient() {
        restTemplate = new RestTemplate();
    }

    public List<EmployeeDto> getEmployees() {
        ResponseEntity<EmployeeDto[]> employeesResponseEntity = restTemplate.getForEntity(EMPLOYEE_URL, EmployeeDto[].class);
        return Arrays.asList(employeesResponseEntity.getBody());

    }

    public void saveEmployee(EmployeeDto dto, SaveEmployeeHandler handler) {
        ResponseEntity<EmployeeDto> responseEntity = restTemplate.postForEntity(EMPLOYEE_URL, dto, EmployeeDto.class);
        if (HttpStatus.OK.equals(responseEntity.getStatusCode())) {
            handler.handle();
        }else {
            //TODO implements
        }

    }

    public EmployeeDto getEmployee(Long idEmployee) {
        String url = EMPLOYEE_URL +"/"+idEmployee;
        ResponseEntity<EmployeeDto> responseEntity = restTemplate.getForEntity(url, EmployeeDto.class);
        if (HttpStatus.OK.equals(responseEntity.getStatusCode())){
            return responseEntity.getBody();
        }else {
            //TODO IMPLEMENTS
            throw new RuntimeException("Can't load employee");
        }
    }

    public void deleteEmployee(Long idEmployee, DeleteEmployeeHandler handler) {

        restTemplate.delete(EMPLOYEE_URL +"/"+idEmployee);
        handler.handle();


    }
}
