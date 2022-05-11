package com.org.wellsfargo.namepronunciation;

import java.util.ArrayList;
import java.util.List;

import com.org.wellsfargo.namepronunciation.dao.EmployeeService;
import com.org.wellsfargo.namepronunciation.dao.EmployeeService1;
import com.org.wellsfargo.namepronunciation.dao.EnrolledApplicationService;
import com.org.wellsfargo.namepronunciation.entity.Employee1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

//@ExtendWith(SpringExtension.class)
@WebMvcTest
public class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    EmployeeService1 employeeService1;
    @MockBean
    EmployeeService employeeService;
    @MockBean
    EnrolledApplicationService enrolledApplicationService;

   // @Test
    public void testGetDepartment() throws Exception {
        Employee1 employee = new Employee1();
        employee.setId(1);

        List<Employee1> employeeList = new ArrayList<>();
        employeeList.add(employee);

        given(employeeService1.findAll()).willReturn(employeeList);

        this.mockMvc.perform(get("/employees")).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1));
    }

}
