var taskHandelModel = require('../model/taskHandelModel');

// exports.AddTask = async(req,res)=>{
//     var data = await taskHandelModel.create(req.body);
//     res.status(200).json({
//         status:"Add Task Successfully..",
//         data
//     })
// };

// exports.UpdateTask = async(req,res)=>{
//     var data = await taskHandelModel.find({"_id":req.body.id,"taskDate":req.body.date});
//     res.status(200).json({
//         status:"Update Task Successfully..!",
//         data
//     })
// };

// exports.DeleteTask = async(req,res)=>{
//     var data = await taskHandelModel.find({"_id":req.body.id,"taskDate":req.body.date});
//     res.status(200).json({
//         status:"Delete Task Successfully..!",
//         data
//     })
// };

// exports.SelectTask = async(req,res)=>{
//     var data = await taskHandelModel.find({"_id":req.body.id,"taskDate":req.body.date});
//     res.status(200).json({
//         status:"Select Task Successfully..!",
//         data
//     })
// };

exports.AddTask = async (req, res) => {
    try {
        const { employeeID, taskDate, taskDtl, taskDone } = req.body;
        console.log(req.body);
        if (!employeeID || !taskDate || !taskDtl || !taskDone) {
            return res.status(400).json({ status: "All fields (employeeID, taskDate, taskDtl, taskDone) are required" });
        }
        const data = await taskHandelModel.create(req.body);

        res.status(201).json({
            status: "Task added successfully!",
            data
        });
    } catch (err) {
        console.error(err);
        res.status(500).json({ status: "Server error", error: err.message });
    }
};

exports.UpdateTask = async (req, res) => {
    try {
        const { id, date, updateData } = req.body;

        if (!id || !date) {
            return res.status(400).json({ status: "Task ID and date are required" });
        }
        console.log(new Date(date));
        console.log(date);
        const data = await taskHandelModel.findOneAndUpdate({ "employeeID": id, "taskDate": date }, updateData, { new: true });

        if (!data) {
            return res.status(404).json({ status: "Task not found" });
        }

        res.status(200).json({
            status: "Task updated successfully!",
            data
        });
    } catch (err) {
        console.error(err);
        res.status(500).json({ status: "Server error", error: err.message });
    }
};

exports.DeleteTask = async (req, res) => {
    try {
        const { id, date } = req.body;
        console.log(req.body);
        if (!id || !date) {
            return res.status(400).json({ status: "Task ID and date are required" });
        }

        const data = await taskHandelModel.findOneAndDelete({ "employeeID": id, "taskDate": date});

        if (!data) {
            return res.status(404).json({ status: "Task not found" });
        }

        res.status(200).json({
            status: "Task deleted successfully!",
            data
        });
    } catch (err) {
        console.error(err);
        res.status(500).json({ status: "Server error", error: err.message });
    }
};

exports.SelectTask = async (req, res) => {
    try {
        const { id, date } = req.body;

        if (!id || !date) {
            return res.status(400).json({ status: "Task ID and date are required" });
        }

        const taskDate = new Date(date);
        if (isNaN(taskDate)) {
            return res.status(400).json({ status: "Invalid date format" });
        }

        const data = await taskHandelModel.findOne({ "employeeID": id, "taskDate": date });

        if (!data) {
            return res.status(404).json({ status: "Task not found" });
        }

        res.status(200).json({
            status: "Task selected successfully!",
            data
        });
    } catch (err) {
        console.error(err);
        res.status(500).json({ status: "Server error", error: err.message });
    }
};