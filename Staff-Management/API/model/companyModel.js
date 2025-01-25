var mongoose = require('mongoose');

var companyRegister = new mongoose.Schema({
    workSpaceURL:{
        type:String
    },
    companyName:{
        type:String
    },
    companyEmail:{
        type:String
    },
    companyPassword:{
        type:String
    }
});

module.exports = mongoose.model('company_register',companyRegister);