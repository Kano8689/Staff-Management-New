var mongoose = require('mongoose');

var employeeRegister = new mongoose.Schema({
    workSpaceURL:{
        type:String
    },
    companyName:{
        type:String
    },
    employeeName:{
        type:String
    },
    employeeRole:{
        type:String
    },
    employeeEmail:{
        type:String
    },
    employeeMono:{
        type:String
    },
    employeeJoinDate:{
        type:Date
    },
    employeeSalary:{
        type:Number
    },
    employeePassword:{
        type:String
    },
});

module.exports = mongoose.model('employee_register', employeeRegister);