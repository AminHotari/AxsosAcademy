const {author} = require('../models/author.model');

module.exports.createAuthor = (request, response)=>{
    const {name}= request.body;
    author.create({
        name,
    })
        .then(author => response.json(author))
        .catch(err => response.status(400).json(err));
}

module.exports.getAllAuthors = (request,response)=>{
    author.find({})
        .then(authors => response.json(authors))
        .catch(err => response.json(err))
}

module.exports.getAuthor = (request,response)=>{
    author.findOne({_id: request.params.id})
        .then(author=> response.json(author))
        .catch(err=>response.json(err))
}

module.exports.deleteAuthor = (request,response)=>{
    author.deleteOne({_id: request.params.id})
        .then(deleteTheAuthor =>response.json(deleteTheAuthor))
        .catch(err => response.json(err))
}

module.exports.updateAuthor = (request, response) => {
    author.findOneAndUpdate({_id: request.params.id}, request.body, {new:true , runValidators:true})
        .then(updateTheAuthor => response.json(updateTheAuthor))
        .catch(err => response.status(400).json(err))
}
