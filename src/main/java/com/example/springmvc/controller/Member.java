package com.example.springmvc.controller;

import lombok.Data;

@Data
public class Member {
        private String id;
        private String pwd;
        private Integer age;

        public Member(){
        }

        public Member(String id, String pwd, Integer age) {
            this.id = id;
            this.pwd = pwd;
            this.age = age;
        }
    }