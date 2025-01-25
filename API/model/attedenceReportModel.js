var mongoose = require("mongoose");

var attedenceReport = new mongoose.Schema({
    _employeeID:{
        type:String
    },
    _Date:{
        type:Date
    },
    _Day:{
        type:String
    },
    timeForm:{
        type:String
    },
    timeTo:{
        type:String
    },
    dailyFillTime:{
        type:String
    },
    regularTime:{
        type:String
    },
    extraTime:{
        type:String
    },
    Reason:{
        type:String
    }
});

module.exports = mongoose.model("attedence_report",attedenceReport);