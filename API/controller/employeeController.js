var employeeModel = require('../model/employeeModel');
// var storage = require('node-persist');

exports.EmployeeRegister = async (req, res) => {
    var data = await employeeModel.create(req.body);
    res.status(200).json({
        status: "Employee Register Successfully..",
        data
    })
};

exports.EmployeeLogin = async (req, res) => {
    var email = req.body.employeeEmail;
    var password = req.body.employeePassword;
    var domain = req.body.workSpaceURL;
    // await storage.init();
    // var check_login = await storage.getItem('employee_id');
    // var check_login = await storage.getItem('employee_id');

    // if (check_login == undefined) 
    {
        var data = await employeeModel.find({ "employeeEmail": email, "employeePassword": password, "workSpaceURL": domain });
        if (data.length != 0) {
            // await storage.init();
            // await storage.setItem('company_id', data[0].id);
            res.status(200).json({
                status: "Employee Login Successfully.."
            });
        }
        else {
            res.status(200).json({
                status: "Invalid Data.."
            });
        }
    }
    // else 
    // {
    //     res.status(200).json({
    //         status: "Employee Already Login.."
    //     });
    // }
};

exports.EmployeeProfile = async (req, res) => {
    try {
        const { id } = req.body;
        console.log(req.body);
        if (!id) {
            return res.status(400).json({ status: "Employee ID is required" });
        }

        const data = await employeeModel.findOne({ "_id": id });

        if (!data) {
            return res.status(404).json({ status: "Employee not found" });
        }

        res.status(200).json({
            status: "Employee Profile Retrieved Successfully!",
            data
        });
    } catch (err) {
        console.error(err);
        res.status(500).json({ status: "Server error", error: err.message });
    }
};

exports.SelectAll = async (req, res) => {
    try {
        const employees = await employeeModel.find();

        if (employees.length === 0) {
            return res.status(404).json({
                status: "No employees found"
            });
        }

        res.status(200).json({
            status: "Employees retrieved successfully",
            data: employees
        });

    } catch (err) {
        console.error(err);
        res.status(500).json({
            status: "Server error",
            error: err.message
        });
    }
};


// exports.EmployeeProfile = async(req,res)=>{
//     var data = await employeeModel.find({"_id":req.body.id});
//     res.status(200).json({
//         status:"Get Employee Profile Successfully..!",
//         data
//     })
// };