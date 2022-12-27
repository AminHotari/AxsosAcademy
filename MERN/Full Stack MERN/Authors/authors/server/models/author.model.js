const mongoose = require('mongoose');
const AuthorSchema = new mongoose.Schema({
    name: {
        type:String,
        required:[true,"Name Must be require"],
        minlength:[3, "Name Must be at least 3 characters"],
    },
},{timestamps: true} );
module.exports.author = mongoose.model('author', AuthorSchema);