var mongoose = require('mongoose');

const TeamEmployeeDetailsSchema = new mongoose.Schema({
    employeeName: {
        type: String,
        default: ""
    },
    employeeRole: {
        type: String,
        default: ""
    }
});

const teamDetails = new mongoose.Schema({
    teamName: {
        type: String
    },
    projectName: {
        type: String
    },
    projectStartDate: {
        type: Date
    },
    employeeList: {
        type: [TeamEmployeeDetailsSchema],
        default: []
    }
});

module.exports = mongoose.model('team_details', teamDetails);