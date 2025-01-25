var teamDetailsModel = require('../model/teamDetailsModel');

exports.CreateTeam = async (req, res) => {
    var data = await teamDetailsModel.create(req.body);
    res.status(200).json({
        status: "Team Created Successfully..",
        data
    })
};

// exports.UpdateTeam = async(req,res)=>{
//     var data = await teamDetailsModel.find({"_id":req.body.id});
//     res.status(200).json({
//         status:"Team Data Update Successfully..!",
//         data
//     })
// };

// exports.SelectTeam = async(req,res)=>{
//     var data = await teamDetailsModel.find({"_id":req.body.id});
//     res.status(200).json({
//         status:"Team Data Select Successfully..!",
//         data
//     })
// };

exports.UpdateTeam = async (req, res) => {
    try {
        const { id, updateData } = req.body;

        if (!id || !updateData) {
            return res.status(400).json({ status: "Team ID and update data are required" });
        }

        const updatedTeam = await teamDetailsModel.findOneAndUpdate({ "_id": id }, updateData, { new: true });

        if (!updatedTeam) {
            return res.status(404).json({ status: "Team not found" });
        }

        res.status(200).json({
            status: "Team Data Updated Successfully!",
            data: updatedTeam
        });
    } catch (err) {
        console.error(err);
        res.status(500).json({ status: "Server error", error: err.message });
    }
};

exports.SelectTeam = async (req, res) => {
    try {
        const { id } = req.body;

        if (!id) {
            return res.status(400).json({ status: "Team ID is required" });
        }

        const data = await teamDetailsModel.findOne({ "_id": id });

        if (!data) {
            return res.status(404).json({ status: "Team not found" });
        }

        res.status(200).json({
            status: "Team Data Retrieved Successfully!",
            data
        });
    } catch (err) {
        console.error(err);
        res.status(500).json({ status: "Server error", error: err.message });
    }
};

