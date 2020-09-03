/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personal;

import Persistence.QueryBuilder;

/**
 *
 * @author Ariel
 */
public class GetEmployeeById {
    
    public String Query(String identidad)
    {
         String query = new QueryBuilder.Builder()
                .Select()
                .WithColumn("EmployeeId")
                .WithColumn("FirstName")
                .WithColumn("MiddleName")
                .WithColumn("LastName1")
                .WithColumn("LastName2")
                .WithColumn("EmployeeSex")
                .WithColumn("EmployeePhone")
                .WithColumn("EmployeeDayOfBirth")
                .WithColumn("Puesto")
                .WithColumn("Estado")
                .From("employees")
                .WhereMatchString("EmployeeId", identidad)
                .Build()
                .MakeQuery();
         return query;
    }
    
}
