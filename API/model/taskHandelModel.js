var mongoose = require('mongoose');

var taskHandelModel = new mongoose.Schema({
    employeeID:{
        type:String
    },
    taskDate:{
        type:String
    },
    taskDtl:{
        type:String
    },
    taskDone:{
        type:Boolean
    }
});

module.exports = mongoose.model('task_handel', taskHandelModel);