var express = require('express');
var router = express.Router();

var { CompanyRegister, CompanyLogin } = require('../controller/companyController');
var { EmployeeRegister, EmployeeLogin, EmployeeProfile, SelectAll, index, SelectAll1 } = require('../controller/employeeController');
var { AddTask, UpdateTask, DeleteTask, SelectTask } = require('../controller/taskHandelController');
var { UpdateAttedence, SelectAttedence } = require('../controller/attedenceReportController');
var { CreateTeam, UpdateTeam, SelectTeam } = require('../controller/teamDetailsController');


router.post('/CompanyRegister', CompanyRegister); //done
router.post('/CompanyLogin', CompanyLogin);  //done

router.post('/EmployeeRegister', EmployeeRegister);  //done
router.post('/EmployeeLogin', EmployeeLogin);  //done
router.post('/EmployeeProfile', EmployeeProfile);  //done
router.post('/SelectAll', SelectAll);

router.get('/SelectAll1', SelectAll1);
router.get('/index', index);

router.post('/AddTask', AddTask);  //done
router.post('/UpdateTask', UpdateTask);  //done
router.post('/DeleteTask', DeleteTask);  //done 
router.post('/SelectTask', SelectTask);  //done

router.post('/UpdateAttedence', UpdateAttedence);  //
router.post('/SelectAttedence', SelectAttedence);  //

router.post('/CreateTeam', CreateTeam);  //done
router.post('/UpdateTeam', UpdateTeam);  //done
router.post('/SelectTeam', SelectTeam);  //done


module.exports = router;
