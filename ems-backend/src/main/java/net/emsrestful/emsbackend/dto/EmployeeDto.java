package net.emsrestful.emsbackend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


// This dto is to transfer the data between client and server
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//this employeeDto will be the response for https
public class EmployeeDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private Long phone;

    private String address;



}
