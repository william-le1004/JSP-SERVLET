package com.model;

import lombok.*;


/**
 * @author Will
 * @project FSOFT
 * @date 6/30/2023
 */
@AllArgsConstructor
@Getter
@ToString
@Setter
@Data
@NoArgsConstructor
public class User {
    private String username;
    private String password;
    public static void print(){
        System.out.println("Hello World");
    }
    public static void main(String[] args) {
    print();
    }
}
