package com.org.wellsfargo.namepronunciation.controllers;

import com.org.wellsfargo.namepronunciation.dao.*;
import com.org.wellsfargo.namepronunciation.entity.*;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

@RestController
public class TestController {

    @Autowired
    private EmployeeService1 employeeService1;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EnrolledApplicationService enrolledApplicationService;

    @Autowired
    private AuditLogService auditLogService;

    @Autowired
    private NamePronunciationService namePronunciationService;

    // Select, Insert, Delete, Update Operations for an Employee

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    Employee1 getEmployee(@PathVariable Integer id) throws IOException {
        Employee emp = new Employee();
        emp.setEmpId("1901914");
        emp.setUid("u752502");
        emp.setEntitlementId(1);
        emp.setFirstName("Ravi");
        emp.setLastName("katkar");
        emp.setMiddleName("");
        emp.setCreatedBy("SYSTEM");
        emp.setCreatedTimestamp(new Date());
        emp.setModifiedTimestamp(new Date());
        employeeService.save(emp);

        EnrolledApplication enrolledApplication = new EnrolledApplication();
        enrolledApplication.setAppDesc("sampleApp");
        enrolledApplication.setAppToken(UUID.randomUUID().toString());
        enrolledApplication.setCreatedBy("SYSTEM");
        enrolledApplication.setCreatedTimestamp(new Date());
        enrolledApplication.setModifiedTimestamp(new Date());
        enrolledApplicationService.save(enrolledApplication);

        AuditLog auditLog = new AuditLog();
        auditLog.setAppId(1);
        auditLog.setRequestedName("ravi");
        auditLog.setUid("u752502");
        auditLog.setCreatedTimestamp(new Date());
        auditLog.setServiceName("myName");
        auditLogService.save(auditLog);

        NamePronunciation namePronunciation = new NamePronunciation();
        byte[] sound = FileUtils.readFileToByteArray(new File("C:\\Users\\ravi katkar\\IdeaProjects\\spring-boot-data-H2-embedded\\src\\main\\resources\\sampleVoice.mp3"));
        namePronunciation.setPronunciationSound(sound);
        namePronunciation.setFormat("MP3");
        namePronunciation.setUid("u752502");
        namePronunciation.setCreatedBy("SYSTEM");
        namePronunciation.setCreatedTimestamp(new Date());
        namePronunciation.setModifiedTimestamp(new Date());
        namePronunciationService.save(namePronunciation);
        return employeeService1.findById(id).get();
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    String addEmployee(@RequestBody Employee1 employee) {

        return "SUCCESS";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    Employee1 updateEmployee(@RequestBody Employee1 employee) {
        return employeeService1.save(employee);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.DELETE)
    Map<String, String> deleteEmployee(@RequestParam Integer id) {
        Map<String, String> status = new HashMap<>();
        Optional<Employee1> employee = employeeService1.findById(id);
        if (employee.isPresent()) {
            employeeService1.delete(employee.get());
            status.put("Status", "Employee deleted successfully");
        } else {
            status.put("Status", "Employee not exist");
        }
        return status;
    }

    // Select, Insert, Delete for List of Employees

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    List<Employee1> getAllEmployee() {
        return employeeService1.findAll();
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    String addAllEmployees(@RequestBody List<Employee1> employeeList) {
        employeeService1.saveAll(employeeList);
        return "SUCCESS";
    }

    @RequestMapping(value = "/employees", method = RequestMethod.DELETE)
    String addAllEmployees() {
        employeeService1.deleteAll();
        return "SUCCESS";
    }
}
