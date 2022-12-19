const mongoose =require("mongoose");

const JokesSchema = new mongoose.Schema({
    setup: {type:String,required:[true, "This field is required"],
            minlength:[10,"This field must be at least 10 characters long"]},
    punchline: {type:String,required:[true, "This field is required"],
                minlength:[3,"This field must be at least 3 characters long"]},


},{timestamps: true});

const Joke = mongoose.model("Joke",JokesSchema);

module.exports = Joke;