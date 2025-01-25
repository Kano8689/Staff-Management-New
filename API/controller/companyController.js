var compnyRegisterModel = require('../model/companyModel');
//var storage = require('node-persist');

exports.CompanyRegister = async (req, res) => {
    var data = await compnyRegisterModel.create(req.body);
    res.status(200).json({
        status: "Company Regestration Successfully..",
        data
    })
};

// exports.CompanyLogin = async(req,res)=>{
//     var data = await compnyRegisterModel.create(req.body);
//     res.status(200).json({
//         status:"Company Login Successfully..",
//         data
//     })
// };

exports.CompanyLogin = async (req, res) => {
    var email = req.body.companyEmail;
    var password = req.body.companyPassword;
    var domain = req.body.workSpaceURL;
    // await storage.init();
    // var check_login = await storage.getItem('company_id');

    // if (check_login == undefined) 
    {
        var data = await compnyRegisterModel.find({ "companyEmail": email, "companyPassword": password, "workSpaceURL": domain });
        if (data.length != 0) {
            // await storage.init();
            // await storage.setItem('company_id', data[0].id);
            res.status(200).json({
                status: "Company Login Successfully.."
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
    //         status: "Company Already Login.."
    //     });
    // }
};