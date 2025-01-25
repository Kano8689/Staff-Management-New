var attedenceReportModel = require('../model/attedenceReportModel');

// exports.UpdateAttedence = async(req,res)=>{
//     var id = req.params.id;
//     var date = req.params.date;
//     var updateData = req.body;
//     // var data = await attedenceReportModel.find({"_id":id,"_Date":new Date(date)})
//     var data = await attedenceReportModel.findOneAndUpdate({ _id: id, _Date: new Date(date) },updateData);
//     res.status(200).json({
//         status:"Update Attedence Successfully..!",
//         data
//     })
// };

// exports.SelectAttedence = async(req,res)=>{
//     var id = req.params.id;
//     var date = req.params.date;
//     const data = await attedenceReportModel.find({ _id: id, _Date: parsedDate }, updateData,{ new: true });
//     res.status(200).json({
//         status:"Select Attedence Successfully..!",
//         data
//     })
// };


exports.UpdateAttedence = async (req, res) => {
    try {
        const { id, date,updateData } = req.body;

        const parsedDate = new Date(date);
        if (isNaN(parsedDate)) {
            return res.status(400).json({ status: "Invalid date format" });
        }

        const data = await attedenceReportModel.findOneAndUpdate({ "_id": id, "_Date": parsedDate }, updateData,{ new: true });

        if (!data) {
            return res.status(404).json({ status: "Attendance record not found" });
        }

        res.status(200).json({
            status: "Attendance Update Successfully!",
            data,
        });
    } catch (err) {
        console.error(err);
        res.status(500).json({ status: "Server error", error: err.message });
    }
};

exports.SelectAttedence = async (req, res) => {
    try {
        var { id, date } = req.body;

        if (!id || !date) {
            return res.status(400).json({ status: "ID and date are required" });
        }

        const parsedDate = new Date(date);
        if (isNaN(parsedDate)) {
            return res.status(400).json({ status: "Invalid date format" });
        }

        var data = await attedenceReportModel.find({ "_id": id, "_Date": parsedDate });

        if (data.length === 0) {
            return res.status(404).json({ status: "No attendance record found" });
        }

        res.status(200).json({
            status: "Select Attendance successfully!",
            data
        });
    } catch (err) {
        console.error(err);
        res.status(500).json({ status: "Server error", error: err.message });
    }
};

